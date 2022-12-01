package com.mt.minipi;

public class ConnectionException extends RuntimeException {
	
	public ConnectionException(String message) {
		super(message);
	}
	
	ConnectionException(Throwable cause) {
        super(cause);
    }
}
