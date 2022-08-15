package com.quanbio.model;


import com.quanbio.model.Parameter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.quanbio.model.Device;
import com.quanbio.model.Patient;

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
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id; 
	
	@Column(name ="ppg_signal",columnDefinition="BLOB")
	private int[] ppgSignal;
	
	// Need to change type to int[]
	@Column(name ="heart_rate")
	private int[] heatRate; 
	
	// Need to change type to int[]
	@Column(name ="systolic_blood_pressure")
	private int[] systolicBP;
	
	// Need to change type to int[]
	@Column(name ="diastolic_blood_pressure")
	private int[] diastolicBP;
	
	// Need to change type to int[]
	@Column(name ="blood_oxygen_saturation")
	private int[] spo2;
	
	// Need to change type to int[]
	@Column(name ="microcirculation")
	private int[] microcirculation;
	
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
