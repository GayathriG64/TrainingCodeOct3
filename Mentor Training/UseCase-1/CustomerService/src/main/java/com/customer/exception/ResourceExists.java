package com.customer.exception;

public class ResourceExists extends RuntimeException {

	public static final long serialVersionUID=1L;
	private final String resourceName;
	public final String getResourceName() {
		return resourceName;
	}
	public ResourceExists(String resourceName) {
		super(String.format("%s already exists!", resourceName));
		
		this.resourceName = resourceName;
	}
	
}
