package com.quanbio.service.impl;

import com.quanbio.model.RawData;
import com.quanbio.model.SecondDerivative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate; 

@Service 
public class RawService {
	
	//@Autowired // Autowired 
	// Cannot use a direct constructor 
	// Later improve it 
	//private RestTemplate template=new RestTemplate();
	
	@Autowired
	private RestTemplate template;
	
	public SecondDerivative callAPIPython(RawData raw)
	{
		SecondDerivative response = template.postForObject("http://127.0.0.1:5000/second", raw, SecondDerivative.class);
		return response;
	}

}
  