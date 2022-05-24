package com.quanbio.device;

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
@RequestMapping("/api/devices")
public class DeviceController {
	
	@Autowired 
	private DeviceRepository deviceRepository  ;
	
	//GET: get all devices 
	@GetMapping
	public List<Device> getAllDevices() {
		return this.deviceRepository.findAll();
	} 
			
	// GET(ID): get one device 
	@GetMapping("/{id}")
	public Device getDeviceById(@PathVariable (value = "id") long deviceId) {
		return this.deviceRepository.findById(deviceId)
			.orElseThrow(() -> new RecordNotFoundException("Device id '" + deviceId + "' does not exist"));
	}
	
	// POST: add a new device 
	@PostMapping
	public Device createDevice(@RequestBody Device device) {
		return this.deviceRepository.save(device);
	}
			
	// update: do it later :D 
	// UPdate the deviceName + PortNumber 	
	@PutMapping("/{id}")
	public Device updateDevice(@RequestBody Device device, @PathVariable ("id") long deviceId) {
		Device existingDevice = this.deviceRepository.findById(deviceId)
			.orElseThrow(() -> new RecordNotFoundException("Device id '" + deviceId + "' does not exist"));
		//existingDevice.setId(device.getId());
		existingDevice.setDeviceName(device.getDeviceName());
		existingDevice.setPortNumber(device.getPortNumber());
								
		return this.deviceRepository.save(existingDevice);
	}
	
			
	// DELETE: remove a device 
	@DeleteMapping("/{id}")
	public ResponseEntity<Device> deleteDevice(@PathVariable ("id") long deviceId){
		Device existingDevice = this.deviceRepository.findById(deviceId)
				.orElseThrow(() -> new RecordNotFoundException("Device id '" + deviceId + "' does not exist"));
		this.deviceRepository.delete(existingDevice);
		return ResponseEntity.ok().build();
	}

}
