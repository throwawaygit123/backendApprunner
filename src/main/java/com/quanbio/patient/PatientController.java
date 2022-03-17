package com.quanbio.patient;



import java.util.List;

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


import com.quanbio.config.PatientNotFoundException;

@CrossOrigin

@RestController 
@RequestMapping("/api/patients")
public class PatientController {
 // NEED: define properly the exception of orElseThrow 
	
	@Autowired 
	private PatientRepository patientRepository  ;
	
	//GET: get all users 
	@GetMapping
	public List<Patient> getAllPatients() {
		return this.patientRepository.findAll();
	} 
	
	// GET(ID): get one user 
	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable (value = "id") long patientId) {
		return this.patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException(patientId));
	}
	
	// POST: add a new user 
	@PostMapping
	public Patient createPatient(@RequestBody Patient patient) {
		return this.patientRepository.save(patient);
	}
	
	// PUT: update a user 
	@PutMapping("/{id}")
	public Patient updatePatient(@RequestBody Patient patient, @PathVariable ("id") long patientId) {
		Patient existingPatient = this.patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException(patientId));
		existingPatient.setFamilyName(patient.getFamilyName());
		existingPatient.setFirstName(patient.getFirstName());
		existingPatient.setMiddleName(patient.getMiddleName());
		
		existingPatient.setOccupation(patient.getOccupation());
		existingPatient.setRace(patient.getRace());
		existingPatient.setGender(patient.getGender());
		
		
		
		 return this.patientRepository.save(existingPatient);
	}
	
	// DELETE: remove a user 
	@DeleteMapping("/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable ("id") long patientId){
		Patient existingPatient = this.patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException(patientId));
		 this.patientRepository.delete(existingPatient);
		 return ResponseEntity.ok().build();
	}
	
	
	
}
