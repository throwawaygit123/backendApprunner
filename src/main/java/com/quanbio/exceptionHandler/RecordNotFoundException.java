package com.quanbio.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException
{
  private static final long serialVersionUID = 1L;
 
  
  public RecordNotFoundException(String message) {
        super(message);
    }
  
  
  // Some Other Constructors may need 
//  public RecordNotFoundException() {
//      super();
//  }
//  
//  public RecordNotFoundException(String message, Throwable cause) {
//      super(message, cause);
//  }
//
//  
//  public RecordNotFoundException(Throwable cause) {
//      super(cause);
//  }
  
  
}




