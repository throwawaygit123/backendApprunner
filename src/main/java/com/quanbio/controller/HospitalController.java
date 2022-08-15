package com.quanbio.controller;

import java.util.List;

import com.quanbio.mapper.HospitalRepository;
import com.quanbio.model.Hospital;
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
@RequestMapping("/api/hospitals")
public class HospitalController {
	
	@Autowired 
	private HospitalRepository hospitalRepository;

	//GET: get all hospitals 
	@GetMapping
	public List<Hospital> getAllHospitals() {
		return this.hospitalRepository.findAll();
	} 
	
	
	// GET(ID): get one hospital 
	@GetMapping("/{id}")
	public Hospital getHospitalById(@PathVariable (value = "id") long hospitalId) {
		return this.hospitalRepository.findById(hospitalId)
				.orElseThrow(() -> new RecordNotFoundException("Hospital id '" + hospitalId + "' does not exist"));
	}
	
	
	// POST: add a new hospital 
	@PostMapping
	public Hospital createHospital(@RequestBody Hospital hospital) {
		return this.hospitalRepository.save(hospital);
	}
	
	
	// update: do it later :D 
	// UPdate the hospitalName only
	@PutMapping("/{id}")
	public Hospital updateHospital(@RequestBody Hospital hospital, @PathVariable ("id") long hospitalId) {
		Hospital existingHospital = this.hospitalRepository.findById(hospitalId)
				.orElseThrow(() -> new RecordNotFoundException("Hospital id '" + hospitalId + "' does not exist"));
	
		existingHospital.setHospitalName(hospital.getHospitalName());
	
								
		return this.hospitalRepository.save(existingHospital);		
	}
	
	// DELETE: remove a user 
	@DeleteMapping("/{id}")
	public ResponseEntity<Hospital> deleteHospital(@PathVariable ("id") long hospitalId){
		Hospital existingHospital = this.hospitalRepository.findById(hospitalId)
				.orElseThrow(() -> new RecordNotFoundException("Hospital id '" + hospitalId + "' does not exist"));
		this.hospitalRepository.delete(existingHospital);
		return ResponseEntity.ok().build();
	}

}
