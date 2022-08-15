package com.quanbio.model;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity 
@Table(name = "patient") 

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Patient {
	
@Id	 
@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
@GenericGenerator(name = "native", strategy = "native")
private long id; 

@Column(name ="family_name")
private String familyName;

@Column(name ="first_name")
private String firstName;

@Column(name ="middle_name")
private String middleName;

@Column(name ="occupation")
private String occupation; 

@Column(name ="gender")
private String gender;

@Column(name ="race")
private String race;

@Column(name ="date_birth")
private Date dataBirth; 

// Used in case on a bidirectional relation between Patient and MedicalHistory 
// Can comment this part in case of unidirectional relation 
@OneToOne(mappedBy = "patient")
private MedicalHistory medicalHistory;

//Used in case on a bidirectional relation between Patient and BioData 
//Can comment this part in case of unidirectional relation 
@OneToOne(mappedBy = "patient")
private BioData biodata;

// This means that the owning side of this relation is DOCTOR 
// Insert works from doctor side
// See later, may be need to change the owning side to Patient --> move MappedBy to Doctor class 
@ManyToMany(mappedBy = "patient")
private List<Doctor> doctor; 

//Used in case on a bidirectional relation between Patient and RawData 
//Can comment this part in case of unidirectional relation 
@OneToOne(mappedBy = "patient")
private RawData rawdata; 


 
}
