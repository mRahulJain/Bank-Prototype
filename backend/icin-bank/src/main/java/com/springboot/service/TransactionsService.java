package com.springboot.service;

import java.util.Date;
import java.util.List;

import com.springboot.pojo.FrontendTransaction;
import com.springboot.pojo.Transactions;

public interface TransactionsService {

	public List<Transactions> getAllPendingTransactions();
	public String addTransaction(Transactions transactions);
	public String updateTransaction(int id);
	public List<FrontendTransaction> getTransactionsForAccountNumber(String accountNumber);
	public List<FrontendTransaction> getFilteredTransactions(String accountNumber, String startDate, String endDate);
	
}
