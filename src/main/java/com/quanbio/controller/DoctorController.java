package com.quanbio.controller;

import java.util.List;

import com.quanbio.mapper.DoctorRepository;
import com.quanbio.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quanbio.exceptionHandler.RecordNotFoundException;


@CrossOrigin

@RestController 
@RequestMapping("/api/doctors")
public class DoctorController {
	
	@Autowired 
	private DoctorRepository doctorRepository;
	
	//GET: get all doctors 
	@GetMapping
	public List<Doctor> getAllDoctors() {
		return this.doctorRepository.findAll();
	} 
	
	// GET(ID): get one doctor 
	@GetMapping("/{id}")
	public Doctor getDoctorById(@PathVariable (value = "id") long doctorId) {
		return this.doctorRepository.findById(doctorId)
				.orElseThrow(() -> new RecordNotFoundException("Doctor id '" + doctorId + "' does not exist"));
	}
	
	// POST: add a new doctor
	@PostMapping
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return this.doctorRepository.save(doctor);
	}
	
	// update: do it later :D 
	// UPdate the DocorName + Department only 
			
	@PutMapping("/{id}")
	public Doctor updateDoctor(@RequestBody Doctor doctor, @PathVariable ("id") long doctorId) {
		Doctor existingDoctor = this.doctorRepository.findById(doctorId)
				.orElseThrow(() -> new RecordNotFoundException("Doctor id '" + doctorId + "' does not exist"));
		
		existingDoctor.setDoctorName(doctor.getDoctorName());
		existingDoctor.setDepatment(doctor.getDepatment());
								
		return this.doctorRepository.save(existingDoctor);
	}
	
	// DELETE: remove a user 
	@DeleteMapping("/{id}")
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable ("id") long doctorId){
		Doctor existingDoctor = this.doctorRepository.findById(doctorId)
				.orElseThrow(() -> new RecordNotFoundException("Doctor id '" + doctorId + "' does not exist"));
		this.doctorRepository.delete(existingDoctor);
		return ResponseEntity.ok().build();
				
	}
	



}
