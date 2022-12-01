package com.mt.minipi;

public class ConnectionException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnectionException(String message) {
		super(message);
	}
	
	ConnectionException(Throwable cause) {
        super(cause);
    }
}
