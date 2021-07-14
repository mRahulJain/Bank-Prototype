package com.springboot.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Users {

	@Id
	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;

	@Column(name = "ACCOUNT_HOLDER_NAME")
	private String accountHolderName;

	@Column(name = "ACCOUNT_LOGIN_USER_ID")
	private String accountLoginUserId;

	@Column(name = "ACCOUNT_LOGIN_PASSWORD")
	private String accountLoginPassword;
	
	@Column(name = "ACCOUNT_IS_BLOCKED")
	private int accountIsBlocked;

	public Users() {
		super();
	}

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

	public String getAccountLoginUserId() {
		return accountLoginUserId;
	}

	public void setAccountLoginUserId(String accountLoginUserId) {
		this.accountLoginUserId = accountLoginUserId;
	}

	public String getAccountLoginPassword() {
		return accountLoginPassword;
	}

	public void setAccountLoginPassword(String accountLoginPassword) {
		this.accountLoginPassword = accountLoginPassword;
	}

	public int getAccountIsBlocked() {
		return accountIsBlocked;
	}

	public void setAccountIsBlocked(int accountIsBlocked) {
		this.accountIsBlocked = accountIsBlocked;
	}

	@Override
	public String toString() {
		return "Users [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", accountLoginUserId=" + accountLoginUserId + ", accountLoginPassword=" + accountLoginPassword
				+ ", accountIsBlocked=" + accountIsBlocked + "]";
	}

	public Users(String accountNumber, String accountHolderName, String accountLoginUserId, String accountLoginPassword,
			int accountIsBlocked) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountLoginUserId = accountLoginUserId;
		this.accountLoginPassword = accountLoginPassword;
		this.accountIsBlocked = accountIsBlocked;
	}
	
}
