package com.quanbio.rawData;



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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "RawData") 

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
	
//	This is the first block mentioned as (**)
//	@ManyToOne
//    @JoinColumn(name = "device_id")
//    private Device device;
	
	@ManyToOne
    private Device device;
	
	
	
	

}
