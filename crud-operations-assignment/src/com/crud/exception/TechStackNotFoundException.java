package com.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class TechStackNotFoundException extends RuntimeException {
	
	  private static final long serialVersionUID = 1L;

	    public TechStackNotFoundException(String message){
	        super(message);
	    }

}
