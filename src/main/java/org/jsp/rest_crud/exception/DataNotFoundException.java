package org.jsp.rest_crud.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataNotFoundException extends RuntimeException{
	public DataNotFoundException(String string) {
		
	}

	String message="Data Not Found";
	
}