package com.quanbio.rawData;

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
import com.quanbio.device.Device;




@CrossOrigin

@RestController 
@RequestMapping("/api/signals")
public class RawDataController {
	
	@Autowired 
	private RawDataRepository signalRepository  ;
	
	//GET: get all users 
		@GetMapping
		public List<RawData> getAllSignals() {
			return this.signalRepository.findAll();
		} 
		
	// GET(ID): get one user 
		@GetMapping("/{id}")
		public RawData getSignalById(@PathVariable (value = "id") long signalId) {
			return this.signalRepository.findById(signalId)
					.orElseThrow(() -> new PatientNotFoundException(signalId));
		}
		
	// POST: add a new user 
		@PostMapping
		public RawData createSignal(@RequestBody RawData signal) {
			return this.signalRepository.save(signal);
		}
	
	// update: do it later :D 
	// Have just added update device 
		@PutMapping("/{id}")
		public RawData updateDevice(@RequestBody RawData rawdata, @PathVariable ("id") long rawdataId) {
			RawData existingRawData = this.signalRepository.findById(rawdataId)
					.orElseThrow(() -> new PatientNotFoundException(rawdataId));
			//existingDevice.setId(device.getId());
			existingRawData.setDevice(rawdata.getDevice());
							
			return this.signalRepository.save(existingRawData);
		}
		
	// DELETE: remove a user 
		@DeleteMapping("/{id}")
		public ResponseEntity<RawData> deleteSignal(@PathVariable ("id") long signalId){
			RawData existingSignal = this.signalRepository.findById(signalId)
					.orElseThrow(() -> new PatientNotFoundException(signalId));
			 this.signalRepository.delete(existingSignal);
			 return ResponseEntity.ok().build();
		}

}
