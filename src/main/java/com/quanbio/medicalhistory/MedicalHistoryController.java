package com.quanbio.medicalhistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanbio.config.PatientNotFoundException;



@CrossOrigin

@RestController 
@RequestMapping("/api/medicalHistory")
public class MedicalHistoryController {
	
	@Autowired 
	private MedicalHistoryRepository medicalHistoryRepository;
	
	//GET: get all medical histories  
	@GetMapping
	public List<MedicalHistory> getAllMedicalHistory() {
		return this.medicalHistoryRepository.findAll();
	} 
	
	// GET(ID): get one medical history  
	@GetMapping("/{id}")
	public MedicalHistory getMedicalHistoryById(@PathVariable (value = "id") long medicalId) {
		return this.medicalHistoryRepository.findById(medicalId)
			.orElseThrow(() -> new PatientNotFoundException(medicalId));
	}
	
	
	// POST: add a new medical history 
	@PostMapping
	public MedicalHistory createMedicalHistory(@RequestBody MedicalHistory medicalHisory) {
		return this.medicalHistoryRepository.save(medicalHisory);
	}
	
	// update: do it later :D 
	
	// DELETE: remove a medical history 
	@DeleteMapping("/{id}")
	public ResponseEntity<MedicalHistory> deleteMedicalHistory(@PathVariable ("id") long medicalId){
		MedicalHistory existingMedicalHistory = this.medicalHistoryRepository.findById(medicalId)
				.orElseThrow(() -> new PatientNotFoundException(medicalId));
		this.medicalHistoryRepository.delete(existingMedicalHistory);
		return ResponseEntity.ok().build();
	}

	

}
