package com.quanbio.doctor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quanbio.hospital.Hospital;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "doctor") 

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Doctor {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name ="doctor_name")
	private String doctorName;
	
	@Column(name ="depatment")
	private String depatment;
	
	@ManyToOne
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;
	

}
