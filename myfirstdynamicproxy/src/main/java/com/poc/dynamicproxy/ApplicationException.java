package com.poc.dynamicproxy;

public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ApplicationException(Throwable cause) {
		super(cause);
	
	}
	
	public ApplicationException(String msg) {
			super(msg);
	
		}

}
