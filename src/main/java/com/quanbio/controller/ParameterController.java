package com.quanbio.controller;

import java.util.List;

import com.quanbio.model.Parameter;
import com.quanbio.mapper.ParameterRepository;
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
@RequestMapping("/api/parameter")
public class ParameterController {
	
	@Autowired 
	private ParameterRepository parameterRepository;
	
	//GET: get all parameters 
	@GetMapping
	public List<Parameter> getAllParameters() {
		return this.parameterRepository.findAll();
	} 
	
	// GET(ID): get one parameter 
	@GetMapping("/{id}")
	public Parameter getParameterById(@PathVariable (value = "id") long parameterId) {
		return this.parameterRepository.findById(parameterId)
				.orElseThrow(() -> new RecordNotFoundException("Parameter id '" + parameterId + "' does not exist"));
	}
	 
	// POST: add a new parameter
	@PostMapping
	public Parameter createParameter(@RequestBody Parameter parameter) {
		return this.parameterRepository.save(parameter);
	}
	
	// update: do it later :D 
	
	// DELETE: remove a user 
	@DeleteMapping("/{id}")
	public ResponseEntity<Parameter> deleteParameter(@PathVariable ("id") long parameterId){
		Parameter existingParameter = this.parameterRepository.findById(parameterId)
				.orElseThrow(() -> new RecordNotFoundException("Parameter id '" + parameterId + "' does not exist"));
		this.parameterRepository.delete(existingParameter);
		return ResponseEntity.ok().build();
				
	}
	
}
