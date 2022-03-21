package com.quanbio.parameter;

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
@RequestMapping("/api/parameter")
public class ParameetrController {
	
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
				.orElseThrow(() -> new PatientNotFoundException(parameterId));
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
				.orElseThrow(() -> new PatientNotFoundException(parameterId));
		this.parameterRepository.delete(existingParameter);
		return ResponseEntity.ok().build();
				
	}
	
}
