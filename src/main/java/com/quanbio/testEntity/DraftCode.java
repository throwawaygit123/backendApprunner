package com.quanbio.testEntity;

public class DraftCode {
	
//	//Class: BioDataController
//	// GET(ID): get one BioData 
	// Get by ID with null on the attributes that loop 
//		@GetMapping("/{id}")
//		public BioData getBioDataByIdNull(@PathVariable (value = "id") long biodataId) {
//			Optional<BioData> bio = this.biodataRepository.findById(biodataId);
//			if (bio.isEmpty())  
//			{
//				throw new RecordNotFoundException("BioData id '" + biodataId + "' does not exist");
//			}
//			else 
//			{
//				// Put Null on the bidirectional relations 
//				BioData bioWithNull = bio.get(); 
//				bioWithNull.setPatient(null);
//				return bioWithNull;
//			}
//				
//		}
	
	
	// Class: Device 
	// This case if fore bidirectional mapping 	
	// it works with the first bloc in RawData mentioned as (**)
//		@OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
	//  private List<RawData> rawData;
		
		// I want to test without MappedBy to see if the relation table is created 
//			@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//			private List<RawData> rawData;
		
		// What I am using NOW: Unidirectionnel 
//		  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	    @JoinColumn(name = "device_id")
//	    private List<RawData> rawData;
		
//		@OneToMany(mappedBy = "device")
//		private List<RawData> rawData;
	
	

}
