package com.springboot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pojo.FrontendTransaction;
import com.springboot.pojo.Message;
import com.springboot.pojo.Transactions;
import com.springboot.service.TransactionsService;

@CrossOrigin
@RestController
public class TransactionController {
	
	@Autowired
	private TransactionsService transactionsService;
	
	@PostMapping("/transactions/putTransaction")
	public Message putTransaction(@RequestBody Transactions transactions) {
		Message message = new Message(this.transactionsService.addTransaction(transactions));
		return message;
	}
	
	@GetMapping("/transactions/{accountNumber}")
	public List<FrontendTransaction> getTransactionsByAccountNumber(@PathVariable String accountNumber) {
		return this.transactionsService.getTransactionsForAccountNumber(accountNumber);
	}
	
	@GetMapping("/admin/get-all-pending-transactions")
	public List<Transactions> getPendingTransactions() {
		return this.transactionsService.getAllPendingTransactions();
	}
	
	@GetMapping("/admin/allow/transaction/{id}")
	public Message permitTransaction(@PathVariable int id) {
		Message message = new Message(this.transactionsService.updateTransaction(id));
		return message;
	}
	
	@GetMapping("/transactions/{accountNumber}/{startDate}/{endDate}")
	public List<FrontendTransaction> getFilteredTransactions(
			@PathVariable String accountNumber,
			@PathVariable String startDate,
			@PathVariable String endDate
	) {
		return this.transactionsService.getFilteredTransactions(accountNumber, startDate, endDate);
	}

}
