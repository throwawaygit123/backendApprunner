package com.quanbio.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.quanbio.model.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "hospital") 

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Hospital {
	@Id	
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id; 
	
	@Column(name ="hospital_name")
	private String hospitalName;
	
	@OneToMany(mappedBy = "hospital")
	private List<Doctor> doctors;
	
	@OneToMany(mappedBy="hospital")
	private List<Device> device; 

}
