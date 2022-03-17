package com.quanbio.config;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class PatientNotFoundException extends RuntimeException  {

	//private static final long serialVersionUID = 1L;



	public PatientNotFoundException(long patientId) {
		// TODO Auto-generated constructor stub
		super("Could not find patient " + patientId);
	}
}




