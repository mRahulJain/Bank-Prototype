package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pojo.Accounts;
import com.springboot.pojo.Message;
import com.springboot.service.AccountsService;

@CrossOrigin
@RestController
public class AccountsController {

	@Autowired
	private AccountsService accountsService;
	
	@GetMapping("/accounts")
	public List<Accounts> getAllAccounts() {
		return this.accountsService.getAllAccounts();
	}
	
	@GetMapping("/accounts/{accountNumber}")
	public Accounts getAccount(@PathVariable String accountNumber) {
		return this.accountsService.getAccount(accountNumber);
	}
	
	@GetMapping("/accounts/isNetBankingActivated/{accountNumber}")
	public boolean checkIfNetBankingActivated(@PathVariable String accountNumber) {
		return this.accountsService.isNetBankingReg(accountNumber);
	}
	
	@PostMapping("/accounts/add-account")
	public Message addAccount(@RequestBody Accounts account) {
		this.accountsService.putAccount(account);
		return new Message("Account Added!");
	}
	
}
