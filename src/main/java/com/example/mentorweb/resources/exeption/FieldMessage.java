package com.example.mentorweb.resources.exeption;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;  
	
	
	private String FieldName;
	private String FieldEmail;
	private String message;
	
	
	public FieldMessage() {
		
	}


	public FieldMessage(String fieldName, String fieldEmail, String message) {
		super();
		FieldName = fieldName;
		FieldEmail = fieldEmail;
		this.message = message;
	}


	public String getFieldName() {
		return FieldName;
	}


	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}


	public String getFieldEmail() {
		return FieldEmail;
	}


	public void setFieldEmail(String fieldEmail) {
		FieldEmail = fieldEmail;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
}
