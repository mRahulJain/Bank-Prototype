package com.springboot.pojo;

import java.util.Date;

public class FrontendTransaction {

	private int id;

	private String fromAccountNumber;

	private String toAccountNumber;

	private String fromAccountHolderName;

	private String toAccountHolderName;

	private String fromAccountType;

	private String toAccountType;

	private double transferAmount;
	
	private String transferMessage;

	private String transferType;

	private String transferDate;

	private int transferStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public String getFromAccountType() {
		return fromAccountType;
	}

	public void setFromAccountType(String fromAccountType) {
		this.fromAccountType = fromAccountType;
	}

	public String getToAccountType() {
		return toAccountType;
	}

	public void setToAccountType(String toAccountType) {
		this.toAccountType = toAccountType;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	public int getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(int transferStatus) {
		this.transferStatus = transferStatus;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getFromAccountHolderName() {
		return fromAccountHolderName;
	}

	public void setFromAccountHolderName(String fromAccountHolderName) {
		this.fromAccountHolderName = fromAccountHolderName;
	}

	public String getToAccountHolderName() {
		return toAccountHolderName;
	}

	public void setToAccountHolderName(String toAccountHolderName) {
		this.toAccountHolderName = toAccountHolderName;
	}

	public String getTransferMessage() {
		return transferMessage;
	}

	public void setTransferMessage(String transferMessage) {
		this.transferMessage = transferMessage;
	}

	@Override
	public String toString() {
		return "FrontendTransaction [id=" + id + ", fromAccountNumber=" + fromAccountNumber + ", toAccountNumber="
				+ toAccountNumber + ", fromAccountHolderName=" + fromAccountHolderName + ", toAccountHolderName="
				+ toAccountHolderName + ", fromAccountType=" + fromAccountType + ", toAccountType=" + toAccountType
				+ ", transferAmount=" + transferAmount + ", transferMessage=" + transferMessage + ", transferType="
				+ transferType + ", transferDate=" + transferDate + ", transferStatus=" + transferStatus + "]";
	}

	public FrontendTransaction(int id, String fromAccountNumber, String toAccountNumber, String fromAccountHolderName,
			String toAccountHolderName, String fromAccountType, String toAccountType, double transferAmount,
			String transferMessage, String transferType, String transferDate, int transferStatus) {
		super();
		this.id = id;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.fromAccountHolderName = fromAccountHolderName;
		this.toAccountHolderName = toAccountHolderName;
		this.fromAccountType = fromAccountType;
		this.toAccountType = toAccountType;
		this.transferAmount = transferAmount;
		this.transferMessage = transferMessage;
		this.transferType = transferType;
		this.transferDate = transferDate;
		this.transferStatus = transferStatus;
	}

	public FrontendTransaction() {
		super();
	}

}
