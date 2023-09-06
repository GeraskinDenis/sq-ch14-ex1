package ru.geraskindenis.services.exceptions;

public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String name;
	private long id;

	public AccountNotFoundException(String name) {
		super("Account not found!");
		this.name = name;
	}

	public AccountNotFoundException(long id) {
		super("Account not found!");
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

}
