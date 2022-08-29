package com.quanbio.model;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "device") 


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Device {
	
	@Id	
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id; 
	
	@Column(name ="device_name")
	private String deviceName;
	
	@Column(name ="port_number")
	private String portNumber; 
	
//	@OneToMany(mappedBy = "device")
//	private List<RawData> rawData;
	
	@ManyToOne
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;

	
	
	

}
