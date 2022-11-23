package com.customer.exception;

public class ResourceNotFoundException extends RuntimeException{

	public static final long serialVersionUID=1L;
	private String resourceName;
	private String fieldName;
	private String fieldValue;
	public String getResourceName() {
		return resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s:  %s", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
