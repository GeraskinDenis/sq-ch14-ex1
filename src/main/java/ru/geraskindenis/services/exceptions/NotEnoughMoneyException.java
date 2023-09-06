package ru.geraskindenis.services.exceptions;

import java.math.BigDecimal;

public class NotEnoughMoneyException extends RuntimeException {

	private static final long serialVersionUID = -4895768055067109881L;
	
	private long accountId;
	private BigDecimal amountTotal;
	private BigDecimal amountTransfer;

	public NotEnoughMoneyException(String message) {
		super(message);
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(BigDecimal amountTotal) {
		this.amountTotal = amountTotal;
	}

	public BigDecimal getAmountTransfer() {
		return amountTransfer;
	}

	public void setAmountTransfer(BigDecimal amountTransfer) {
		this.amountTransfer = amountTransfer;
	}

}
