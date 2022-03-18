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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name ="device_name")
	private String deviceName;
	
	@Column(name ="port_number")
	private String portNumber; 
	
	@OneToMany(mappedBy = "device")
	private List<RawData> rawData;
	
// This case if fore bidirectional mapping 	
// it works with the first bloc in RawData mentioned as (**)
//	@OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
//  private List<RawData> rawData;
	
	// I want to test without MappedBy to see if the relation table is created 
//		@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//		private List<RawData> rawData;
	
	// What I am using NOW: Unidirectionnel 
//	  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "device_id")
//    private List<RawData> rawData;
	
//	@OneToMany(mappedBy = "device")
//	private List<RawData> rawData;
	
	
	

}
