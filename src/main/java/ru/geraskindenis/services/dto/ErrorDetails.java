package ru.geraskindenis.services.dto;

import java.math.BigDecimal;

public class ErrorDetails {
	
	private long accountId;
	private BigDecimal amountTotal;
	private BigDecimal amountTransfer;
	private String message;
	
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
