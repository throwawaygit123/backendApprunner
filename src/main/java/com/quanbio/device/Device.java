package com.quanbio.device;

import com.quanbio.rawData.RawData;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@OneToMany(mappedBy = "device")
	private List<RawData> rawData;
	

	
	
	

}
