package com.quanbio.biodata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.quanbio.patient.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "bio_data") 

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BioData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String type; 
	
	private double kg;
	private double meters; 
	
	private String ft;
	private double lb; 
	
	@OneToOne
	@JoinColumn(name = "patient_id", unique=true)
	private Patient patient; 
	
	

}
