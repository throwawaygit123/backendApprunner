package com.quanbio.rawData;

import java.sql.SQLIntegrityConstraintViolationException;
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

import com.quanbio.exceptionHandler.RecordNotFoundException;


@CrossOrigin

@RestController 
@RequestMapping("/api/rawdata")
public class RawDataController {
	
	@Autowired 
	private RawDataRepository rawDataRepository  ;
	
	//@Autowired // This Autowired is not working 
	// Cannot use a direct constructor 
	// Later improve it  
//	private RawService service=new RawService() ;
	
	@Autowired  
	private RawService service;
	
	//GET: get all users 
		@GetMapping
		public List<RawData> getAllRawData() {
			return this.rawDataRepository.findAll();
		} 
		
	// GET(ID): get one user 
		@GetMapping("/{id}")
		public RawData getRawDataById(@PathVariable (value = "id") long rawdataId) {
			return this.rawDataRepository.findById(rawdataId)
					.orElseThrow(() -> new RecordNotFoundException("Raw Data id '" + rawdataId + "' does no exist"));
		}
		
//	// POST: add a new user 
//	// original post
//		@PostMapping
//		public RawData createRawData(@RequestBody RawData rawdata) {
//			return this.rawDataRepository.save(rawdata);
//		}
		
		// POST: add a new user 
		// post with patient ID unique 
			@PostMapping
			public RawData createRawData(@RequestBody RawData rawdata) throws SQLIntegrityConstraintViolationException {
				
				if (this.rawDataRepository.existsByPatientId(rawdata.getPatient().getId()))
					{
						throw new java.sql.SQLIntegrityConstraintViolationException("The patient with ID = "+ rawdata.getPatient().getId() +" already have an associated RawData stored in the database");
					}
			
				return this.rawDataRepository.save(rawdata);
			}
		
	// Another Post to call Python 
		@PostMapping("/python")
		public SecondDerivative callPythonn(@RequestBody RawData rawdata) {
			return this.service.callAPIPython(rawdata);
		}
	
	// update: do it later :D 
//	// Have just added update device 
//	// Maybe need to add updated patient later 
//		@PutMapping("/{id}")
//		public RawData updateDevice(@RequestBody RawData rawdata, @PathVariable ("id") long rawdataId) {
//			RawData existingRawData = this.rawDataRepository.findById(rawdataId)
//					.orElseThrow(() -> new PatientNotFoundException(rawdataId));
//			
//			existingRawData.setPpgSignal(rawdata.getPpgSignal());
//		
//							
//			return this.rawDataRepository.save(existingRawData);
//		}
		
		
	// DELETE: remove a user 
	// Original delete 
		@DeleteMapping("/{id}")
		public ResponseEntity<RawData> deleteRawData(@PathVariable ("id") long rawdataId){
			RawData existingRawData = this.rawDataRepository.findById(rawdataId)
					.orElseThrow(() -> new RecordNotFoundException("Raw Data id '" + rawdataId + "' does not exist"));
			 this.rawDataRepository.delete(existingRawData);
			 return ResponseEntity.ok().build();
		}
		
		// DELETE: remove a user 
		// delete RawData by patient ID 
		 @DeleteMapping("deleteByPI/{id}")
		 public ResponseEntity<RawData> deleteRawDataByPatientID(@PathVariable ("id") long patientId){
				RawData existingRawData = this.rawDataRepository.findByPatientId(patientId)
					 .orElseThrow(() -> new RecordNotFoundException("Patient id '" + patientId + "' does not exist"));
					 this.rawDataRepository.delete(existingRawData);
					 return ResponseEntity.ok().build();
				}

}
