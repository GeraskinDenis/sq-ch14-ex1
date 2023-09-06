package ru.geraskindenis.services.exceptions;

public class TransferServiceException extends RuntimeException {

	private static final long serialVersionUID = 2458674234117802809L;
	
	public TransferServiceException(String message) {
		super(message);
	}
}
