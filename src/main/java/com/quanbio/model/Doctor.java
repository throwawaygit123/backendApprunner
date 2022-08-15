package com.quanbio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id; 
	
	@Column(name ="doctor_name")
	private String doctorName;
	
	@Column(name ="depatment")
	private String depatment;
	
	@ManyToOne
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;
	
	@ManyToMany
	private List<Patient> patient;

}
