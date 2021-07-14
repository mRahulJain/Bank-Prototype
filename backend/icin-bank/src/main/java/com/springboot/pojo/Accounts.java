package com.springboot.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Accounts {

	@Id
	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;
	
	@Column(name = "ACCOUNT_HOLDER_NAME")
	private String accountHolderName;
	
	@Column(name = "ACCOUNT_CIF_NUMBER")
	private String accountCIFNumber;
	
	@Column(name = "ACCOUNT_BRANCH")
	private String accountBranch;
	
	@Column(name = "ACCOUNT_IS_NET_BANKING_REG")
	private int accountIsNetBankingReg;
	
	@Column(name = "ACCOUNT_BALANCE_PRIMARY")
	private double accountBalancePrimary;
	
	@Column(name = "ACCOUNT_BALANCE_SAVINGS")
	private double accountBalanceSavings;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountCIFNumber() {
		return accountCIFNumber;
	}

	public void setAccountCIFNumber(String accountCIFNumber) {
		this.accountCIFNumber = accountCIFNumber;
	}

	public String getAccountBranch() {
		return accountBranch;
	}

	public void setAccountBranch(String accountBranch) {
		this.accountBranch = accountBranch;
	}
	
	public int getAccountIsNetBankingReg() {
		return accountIsNetBankingReg;
	}

	public void setAccountIsNetBankingReg(int accountIsNetBankingReg) {
		this.accountIsNetBankingReg = accountIsNetBankingReg;
	}
	
	public double getAccountBalancePrimary() {
		return accountBalancePrimary;
	}

	public void setAccountBalancePrimary(double accountBalancePrimary) {
		this.accountBalancePrimary = accountBalancePrimary;
	}

	public double getAccountBalanceSavings() {
		return accountBalanceSavings;
	}

	public void setAccountBalanceSavings(double accountBalanceSavings) {
		this.accountBalanceSavings = accountBalanceSavings;
	}

	@Override
	public String toString() {
		return "Accounts [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", accountCIFNumber=" + accountCIFNumber + ", accountBranch=" + accountBranch
				+ ", accountIsNetBankingReg=" + accountIsNetBankingReg + ", accountBalancePrimary="
				+ accountBalancePrimary + ", accountBalanceSavings=" + accountBalanceSavings + "]";
	}

	public Accounts(String accountNumber, String accountHolderName, String accountCIFNumber, String accountBranch,
			int accountIsNetBankingReg, double accountBalancePrimary, double accountBalanceSavings) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountCIFNumber = accountCIFNumber;
		this.accountBranch = accountBranch;
		this.accountIsNetBankingReg = accountIsNetBankingReg;
		this.accountBalancePrimary = accountBalancePrimary;
		this.accountBalanceSavings = accountBalanceSavings;
	}

	public Accounts() {
		super();
	}
	
}
