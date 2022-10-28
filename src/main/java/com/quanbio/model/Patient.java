package com.quanbio.model;
import java.sql.Date;
import java.util.List;

//import javax.persistence.Column;
import javax.persistence.*;

import com.sun.istack.internal.Interned;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity 
@Table(name = "patient") 

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Patient{
	
@Id	 
@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
@GenericGenerator(name = "native", strategy = "native")
private long id; 

// This part should be removed after Extends Added
private String firstName;
private String middleName;
private String familyName ;
private String email;
private String password;
private String gender;
private Date dataBirth;

// Specific to patient 
private String occupation; 
private String race;

// BioData
private String bio_type; 
private double bio_kg;
private double bio_meters; 
private String bio_ft;
private double bio_lb; 



// Used in case on a bidirectional relation between Patient and MedicalHistory 
// Can comment this part in case of unidirectional relation 
@OneToOne(mappedBy = "patient")
private MedicalHistory medicalHistory;


// This means that the owning side of this relation is DOCTOR 
// Insert works from doctor side
// See later, may be need to change the owning side to Patient --> move MappedBy to Doctor class 
@ManyToMany(mappedBy = "patient")
private List<Doctor> doctor; 

//Used in case on a bidirectional relation between Patient and RawData 
//Can comment this part in case of unidirectional relation 
@OneToMany(mappedBy = "patient")
private List<RawData> rawdata; 


 
}
