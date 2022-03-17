package com.quanbio.patient;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity 
@Table(name = "patients") 

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Patient {
	
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
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

// confirm later 
@Column(name ="id_physique_data")
private long  idPhysiqueData; 


 
}
