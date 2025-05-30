package org.jsp.rest_crud.helper;

import org.jsp.rest_crud.dto.Student;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class ResponseStructure<T>{
	String message;
	int status;
	T data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public void setStatus(String string) {
		
	}
	
	

}
