package com.quanbio.medicalhistory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.quanbio.patient.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "medical_history") 

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MedicalHistory {
	@Id	
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id; 
	
	@Column(name ="diabete_mellitus")
	private boolean diabeteMellitus;
	
	@Column(name ="neuropathy")
	private boolean neuropathy; 
	
	@Column(name ="hypertension")
	private boolean hypertension;
	
	@Column(name ="implanted_pacemaker")
	private boolean implantedPacemaker; 
	
	@Column(name ="liver_disease")
	private boolean liverDisease; 
	
	@Column(name ="kidney_disease")
	private boolean kidneyDisease; 
	
	@Column(name ="nicotineUse")
	private boolean nicotineUse; 
	
	@Column(name ="dialisis_treatment")
	private boolean dialisisTreatment; 
	
	@Column(name ="covid19")
	private boolean covid19;
	
	@Column(name ="myocardial_infarction")
	private boolean myocardialInfarction; 
	
	@Column(name ="peripheral_vascular_disease")
	private boolean peripheralVascularDisease;
	
	@Column(name ="percutaneous_transluminal")
	private boolean percutaneousTransluminal;
	
	@Column(name ="cerebrovascular_accident")
	private boolean cerebrovascularAccident; 
	
	@Column(name ="congestive_heartFailure")
	private boolean congestiveHeartFailure; 
	
	@Column(name ="coronary_arteryBypass")
	private boolean coronaryArteryBypass;
	
	@Column(name ="list_current_medication")
	private String listCurrentMedication;
	
	@Column(name ="other_health_test_result")
	private String otherHealthTestResult;
	
	@Column(name ="additional_comments")
	private String additionalComments; 
	
	@Column(name ="reason_clinical_visit")
	private String reasonClinicalVisit;
	
	@OneToOne
	@JoinColumn(name = "patient_id", unique=true)
//	@MapsId
	private Patient patient;

}
