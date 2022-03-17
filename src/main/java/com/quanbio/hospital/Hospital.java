package com.quanbio.hospital;

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
@Table(name = "hospital") 

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Hospital {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name ="hospital_name")
	private String hospitalName;

	@Column(name ="depatment")
	private String depatment;

}
