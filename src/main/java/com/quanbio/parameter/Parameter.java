package com.quanbio.parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quanbio.rawData.RawData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "parameter") 

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parameter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String paramName; 
	
	private String paramAbbreviation; 
	
	private String resultInterpretation; 
	
	private String paramDescription; 
	
	private String paramUnit; 
	
	private Double result;
	
	private Double minNormalRange;
	
	private Double maxNormalRange;
	
	private Double stepRange; 
	
	private String category; 
	
	@ManyToOne
	@JoinColumn(name = "device_id")
	private RawData rawdata; 
	

}
