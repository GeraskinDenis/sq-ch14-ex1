package ru.geraskindenis.controllers.dto;

import java.math.BigDecimal;

public class TransferRequest {

	private long senderAccountId;
	private long receiverAccountId;
	private BigDecimal amount;

	public long getSenderAccountId() {
		return senderAccountId;
	}

	public void setSenderAccountId(long senderAccountId) {
		this.senderAccountId = senderAccountId;
	}

	public long getReceiverAccountId() {
		return receiverAccountId;
	}

	public void setReceiverAccountId(long receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransferRequest [senderAccountId=" + senderAccountId + ", receiverAccountId=" + receiverAccountId
				+ ", amount=" + amount + "]";
	}

}
