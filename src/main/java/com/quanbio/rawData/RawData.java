package com.quanbio.rawData;


import com.quanbio.parameter.Parameter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import com.quanbio.device.Device;
import com.quanbio.patient.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "raw_data") 

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RawData  {
	@Id	
	@GeneratedValue
	@Column(name ="id_data")
	private long id_data; 
	
	@Column(name ="ppg_signal")
	private int[] ppgSignal;
	
	@Column(name ="heart_rate")
	private int heatRate; 
	
	@Column(name ="systolic_blood_pressure")
	private int systolicBP;
	
	@Column(name ="diastolic_blood_pressure")
	private int diastolicBP;
	
	@Column(name ="blood_oxygen_saturation")
	private int spo2;
	
	@Column(name ="microcirculation")
	private int microcirculation;
	
	@ManyToOne
	@JoinColumn(name = "device_id")
    private Device device;
	
	@OneToOne
	@JoinColumn(name = "patient_id", unique=true)
	private Patient patient; 
	
	@OneToMany(mappedBy = "rawdata")
	private List<Parameter> parameter; 
	
//	This is the first block mentioned as (**)
//	@ManyToOne
//    @JoinColumn(name = "device_id")
//    private Device device;
	
//	@ManyToOne
//	@JoinColumn(name = "device_id")
//    private Device device;
	
	
	
	

}
