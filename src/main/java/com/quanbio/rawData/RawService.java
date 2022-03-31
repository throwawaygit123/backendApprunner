package com.quanbio.rawData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate; 


public class RawService {
	
	//@Autowired
	// Cannot use a direct constructor 
	// Later imporve it 
	private RestTemplate template=new RestTemplate();
	
	public SecondDerivative callAPIPython(RawData raw) 
	{
		SecondDerivative response = template.postForObject("http://127.0.0.1:5000/second", raw, SecondDerivative.class);
		return response;
	}

}
  