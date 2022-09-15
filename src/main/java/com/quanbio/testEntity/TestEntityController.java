//package com.quanbio.testEntity;
//
//import java.sql.SQLIntegrityConstraintViolationException;
//import java.util.List;
//import java.util.Optional;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.quanbio.exceptionHandler.RecordNotFoundException;
//
//
//
//
////@CrossOrigin(allowedHeaders="*")
//
//@CrossOrigin
//@RestController
//@RequestMapping("/api/testentity")
//public class TestEntityController {
//
//	@Autowired
//	private TestEntityRepository testEntityRepository  ;
//
//
//	// Get
//	@GetMapping
//	public List<TestEntity> getAllTestEntity() {
//		return this.testEntityRepository.findAll();
//	}
//
//
//
//	// get by ID
//	// Original One
//	@GetMapping("/{id}")
//	public TestEntity getTestEntityById(@PathVariable (value = "id") long testEntityId) {
//		return this.testEntityRepository.findById(testEntityId)
//				.orElseThrow(() -> new RecordNotFoundException("Test Entity id '" + testEntityId + "' does no exist"));
//	}
//
//
////	// get by ID
////		// try to return a response entity
////		@GetMapping("/{id}")
////		public ResponseEntity<TestEntity> getTestEntityById(@PathVariable (value = "id") long testEntityId) {
////		Optional <TestEntity> t=this.testEntityRepository.findById(testEntityId);
////			if (t.isEmpty()) {
////				new RecordNotFoundException("Test Entity id '" + testEntityId + "' does no exist");
////			}
////			return  new ResponseEntity<>(t.get(), HttpStatus.OK);
////		}
//
//
////	// get by ID
////	// New exception handling: locally
////	// This I tried it by my own, but it didn't work
////	// Other examples here: https://www.programcreek.com/java-api-examples/?api=org.springframework.web.server.ResponseStatusException
////	@GetMapping("/{id}")
////	public TestEntity getTestEntityById(@PathVariable (value = "id") long testEntityId) {
////
////		return this.testEntityRepository.findById(testEntityId)
////				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Test Entity not found"));
////	}
//
//
//
////	// get by ID
////	// New exception handling: locally
////	// This one did not work. Solution 5 of https://www.baeldung.com/exception-handling-for-rest-with-spring
//	//	@GetMapping("/{id}")
//	//	public TestEntity getTestEntityById(@PathVariable (value = "id") long testEntityId, HttpServletResponse response) {
//	//		try {
//	//			//eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, response));
//	//			return this.testEntityRepository.findById(testEntityId).get();
//	//		}
//	//
//	//		catch (RecordNotFoundException exc) {
//	//			throw new ResponseStatusException(
//	//			           HttpStatus.NOT_FOUND, "Test Entity not found", exc);
//	//		}
//	//	}
//
//
//	// post
//	// Original Post
//	// The origin should be changed by adding the exception of ID already exists
//	@PostMapping
//	public TestEntity createTestEntity(@RequestBody TestEntity testEntity) {
//		return this.testEntityRepository.save(testEntity);
//	}
//
//
//
////	// post
////	// Post testing if the Name entity is unique
////	@PostMapping
////	public TestEntity createTestEntity(@RequestBody TestEntity testEntity) throws SQLIntegrityConstraintViolationException {
//////		// Test the new exist Method //
//////
////		if (this.testEntityRepository.existsByNameEntity(testEntity.getNameEntity()))
////			{
////				throw new java.sql.SQLIntegrityConstraintViolationException("The patient with ID = "+ testEntity.getNameEntity() +" already have an associated RawData stored in the database");
////			}
////		return this.testEntityRepository.save(testEntity);
////	}
//
//
//
////	// post
////	// Post with Exception Handle
//	// Change Return to response Entity
////	// Change RecordNotFoundException later to Record found
////		@PostMapping
////		public ResponseEntity<TestEntity> createTestEntity(@RequestBody TestEntity testEntity) {
////			if (testEntityRepository.existsById(testEntity.getId())) {
////	            throw new RecordNotFoundException("Test Entity id '" + testEntity.getId() + "' already exists");
////	        }
////			return new ResponseEntity<TestEntity>(this.testEntityRepository.save(testEntity), HttpStatus.CREATED);
////		}
//
//
//
//	// update
//	// Original update
//	@PutMapping("/{id}")
//	public TestEntity updateTestEntity(@RequestBody TestEntity testEntity, @PathVariable ("id") long testEntityId) {
//		TestEntity existingTestEntity = this.testEntityRepository.findById(testEntityId)
//				.orElseThrow(() -> new RecordNotFoundException("Test Entity id '" + testEntityId + "' does no exist"));
//		//existingDevice.setId(device.getId());
//		existingTestEntity.setNameEntity(testEntity.getNameEntity());
//
//		return this.testEntityRepository.save(existingTestEntity);
//	}
//
//
////	// update
////	// Update with a response Entity
////	// Later we can create a new Class UpdateRespense
////	@PutMapping("/{id}")
////	public ResponseEntity<String> updateTestEntity(@RequestBody TestEntity testEntity, @PathVariable ("id") long testEntityId) {
////		TestEntity existingTestEntity = this.testEntityRepository.findById(testEntityId)
////				.orElseThrow(() -> new RecordNotFoundException("Test Entity id '" + testEntityId + "' does no exist"));
////		//existingDevice.setId(device.getId());
////		existingTestEntity.setNameEntity(testEntity.getNameEntity());
////		this.testEntityRepository.save(existingTestEntity);
////		return new ResponseEntity<>("Test Entity was successfully updated", HttpStatus.OK) ;
////	}
//
//
//	// delete
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteTestEntity(@PathVariable ("id") long testEntityId){
//		TestEntity existingTestEntity = this.testEntityRepository.findById(testEntityId)
//				.orElseThrow(() -> new RecordNotFoundException("Test Entity id '" + testEntityId + "' does no exist"));
//		 this.testEntityRepository.delete(existingTestEntity);
//		 return new ResponseEntity<>("Test Entity  was successfully deleted", HttpStatus.OK) ;
//	}
//
//
//
//
//}
