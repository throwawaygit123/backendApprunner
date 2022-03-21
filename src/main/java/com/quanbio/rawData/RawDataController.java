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
@RequestMapping("/api/rawdata")
public class RawDataController {
	
	@Autowired 
	private RawDataRepository rawDataRepository  ;
	
	//GET: get all users 
		@GetMapping
		public List<RawData> getAllRawData() {
			return this.rawDataRepository.findAll();
		} 
		
	// GET(ID): get one user 
		@GetMapping("/{id}")
		public RawData getRawDataById(@PathVariable (value = "id") long rawdataId) {
			return this.rawDataRepository.findById(rawdataId)
					.orElseThrow(() -> new PatientNotFoundException(rawdataId));
		}
		
	// POST: add a new user 
		@PostMapping
		public RawData createRawData(@RequestBody RawData rawdata) {
			return this.rawDataRepository.save(rawdata);
		}
	
	// update: do it later :D 
	// Have just added update device 
	// Maybe need to add updated patient later 
		@PutMapping("/{id}")
		public RawData updateDevice(@RequestBody RawData rawdata, @PathVariable ("id") long rawdataId) {
			RawData existingRawData = this.rawDataRepository.findById(rawdataId)
					.orElseThrow(() -> new PatientNotFoundException(rawdataId));
			//existingDevice.setId(device.getId());
			existingRawData.setDevice(rawdata.getDevice());
							
			return this.rawDataRepository.save(existingRawData);
		}
		
	// DELETE: remove a user 
		@DeleteMapping("/{id}")
		public ResponseEntity<RawData> deleteRawData(@PathVariable ("id") long rawdataId){
			RawData existingRawData = this.rawDataRepository.findById(rawdataId)
					.orElseThrow(() -> new PatientNotFoundException(rawdataId));
			 this.rawDataRepository.delete(existingRawData);
			 return ResponseEntity.ok().build();
		}

}
