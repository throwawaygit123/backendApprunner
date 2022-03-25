package com.quanbio.testEntity;

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




//@CrossOrigin(allowedHeaders="*")

@CrossOrigin
@RestController 
@RequestMapping("/api/testentity")
public class TestEntityController {
	
	@Autowired 
	private TestEntityRepository testEntityRepository  ;
	
	
	// Get 
	@GetMapping
	public List<TestEntity> getAllTestEntity() {
		return this.testEntityRepository.findAll();
	} 
	
	// get by ID 
	@GetMapping("/{id}")
	public TestEntity getTestEntityById(@PathVariable (value = "id") long testEntityId) {
		return this.testEntityRepository.findById(testEntityId)
				.orElseThrow(() -> new PatientNotFoundException(testEntityId));
	}
	
	// port 
	@PostMapping
	public TestEntity createTestEntity(@RequestBody TestEntity testEntity) {
		return this.testEntityRepository.save(testEntity);
	}
	
	// update 
	@PutMapping("/{id}")
	public TestEntity updateTestEntity(@RequestBody TestEntity testEntity, @PathVariable ("id") long testEntityId) {
		TestEntity existingTestEntity = this.testEntityRepository.findById(testEntityId)
				.orElseThrow(() -> new PatientNotFoundException(testEntityId));
		//existingDevice.setId(device.getId());
		existingTestEntity.setNameEntity(testEntity.getNameEntity());
						
		return this.testEntityRepository.save(existingTestEntity);
	}
	
	
	// delete 
	@DeleteMapping("/{id}")
	public ResponseEntity<TestEntity> deleteTestEntity(@PathVariable ("id") long testEnityId){
		TestEntity existingTestEntity = this.testEntityRepository.findById(testEnityId)
				.orElseThrow(() -> new PatientNotFoundException(testEnityId));
		 this.testEntityRepository.delete(existingTestEntity);
		 return ResponseEntity.ok().build();
	}
	
	


}
