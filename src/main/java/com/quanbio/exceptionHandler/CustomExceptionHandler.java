package com.quanbio.exceptionHandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
//  Original Error handling 
// This method returns String only 
//  @ResponseBody
//  @ExceptionHandler(RecordNotFoundException.class)
//  @ResponseStatus(HttpStatus.NOT_FOUND)
//  String RecordNotFoundHandler(RecordNotFoundException ex) {
//    return ex.getMessage();
//  }
	
	
	 
//	  Possible wait to declare the message is: 
//	 @Value(value = "${data.exception.INCORRECT_REQUEST}")
//	 private String INCORRECT_REQUEST ;
//	  Add in Application.properties this 
//	 data.exception.INCORRECT_REQUEST = "INCORRECT_REQUEST"

	
//// Second wait to handle errors: Message and details (return a JSON structure)
private String INCORRECT_REQUEST = "INCORRECT_REQUEST";     
  // This solution returns a structure Error 
  @ExceptionHandler(RecordNotFoundException.class)
  public final ResponseEntity<ErrorResponse> handleObjectNotFoundException
            (RecordNotFoundException ex, WebRequest request) 
  {

    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    
    ErrorResponse error = new ErrorResponse(INCORRECT_REQUEST, details);
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
  

	  
//  // Third Wait to handle Errors 
//  // This third solution returns a String Only
//  @ExceptionHandler(value = RecordNotFoundException.class)
//  public ResponseEntity<String> handleObjectNotFoundException(RecordNotFoundException ex) {
//      return new ResponseEntity<>(INCORRECT_REQUEST, HttpStatus.NOT_FOUND);
//  }
  
  
  
 // This solution works 
  // Try to handle an existing exception differently 
  private String CONSTRAINT_VIOLATION = "CONSTRAINT_VIOLATION";
  @ExceptionHandler(java.sql.SQLIntegrityConstraintViolationException.class)
  public final ResponseEntity<ErrorResponse> handleConstraintViolationException
  (java.sql.SQLIntegrityConstraintViolationException ex, WebRequest request) 
		{
		  
	  	List<String> details = new ArrayList<>();  	
	  	details.add(ex.getLocalizedMessage());
		
		ErrorResponse error = new ErrorResponse(CONSTRAINT_VIOLATION, details);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
  
}