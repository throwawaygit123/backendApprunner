package com.quanbio.biodata;

import java.util.List;
import java.util.Optional;

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


import com.quanbio.exceptionHandler.RecordNotFoundException;



@CrossOrigin
@RestController 
@RequestMapping("/api/biodata")
public class BioDataController {
	@Autowired 
	private BioDataDataRepository biodataRepository;
	
	
	//GET: get all BioData 
	@GetMapping
	public List<BioData> getAllBioData() {
		return this.biodataRepository.findAll();
	} 
		

	// GET(ID): get one BioData 
	// Original get by ID 
	@GetMapping("/{id}")
	public BioData getBioDataById(@PathVariable (value = "id") long biodataId) {
		
		return this.biodataRepository.findById(biodataId)
			.orElseThrow(() -> new RecordNotFoundException("BioData id '" + biodataId + "' does not exist"));
	}

	// POST: add a new BioData 
	@PostMapping
	public BioData createBioData(@RequestBody BioData bioData) {
		return this.biodataRepository.save(bioData);
	}
	
	// update: do it later :D 
	
	// DELETE: remove a BioData 
	@DeleteMapping("/{id}")
	public ResponseEntity<BioData> deleteBioData(@PathVariable ("id") long biodataId){
		BioData existingBioData = this.biodataRepository.findById(biodataId)
				.orElseThrow(() -> new RecordNotFoundException("BioData id '" + biodataId + "' does not exist"));
		this.biodataRepository.delete(existingBioData);
		return ResponseEntity.ok().build();
	}

}
