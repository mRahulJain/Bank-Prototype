package com.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.pojo.Accounts;
import com.springboot.pojo.FrontendTransaction;
import com.springboot.pojo.Transactions;
import com.springboot.repository.AccountsRepository;
import com.springboot.repository.TransactionsRepository;

@Service(value = "transactionsService")
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired
	private TransactionsRepository transactionsRepository;
	@Autowired
	private AccountsRepository accountsRepository;

	@Override
	public String addTransaction(Transactions transactions) {
		List<Transactions> list = this.transactionsRepository
				.getTransactionsByAccountNumber(transactions.getFromAccountNumber());
		double amountPrimary = 0;
		double amountSavings = 0;
		for (Transactions temp : list) {
			if (temp.getTransferStatus() == 0) {
				if (temp.getFromAccountType().equals("Primary")) {
					amountPrimary += temp.getTransferAmount();
				} else {
					amountSavings += temp.getTransferAmount();
				}
			}
		}

		Accounts accountSender = this.accountsRepository.getOne(transactions.getFromAccountNumber());
		Accounts accountReceiver = this.accountsRepository.getOne(transactions.getToAccountNumber());

		boolean check = false;
		List<Accounts> accountsList = this.accountsRepository.findAll();
		for (Accounts temp : accountsList) {
			if (temp.getAccountNumber().equals(transactions.getToAccountNumber())) {
				check = true;
			}
		}
		if (!check) {
			return "Transfer bank account does not exists!";
		}

		Accounts myAccount = this.accountsRepository.getOne(transactions.getFromAccountNumber());
		if (transactions.getFromAccountType().equals("Primary")) {
			if (myAccount.getAccountBalancePrimary() - amountPrimary < transactions.getTransferAmount()) {
				return "You already have some pending transactions!\nYour primary account would not have that much balance if these transactions are permitted!";
			}
		} else {
			if (myAccount.getAccountBalanceSavings() - amountSavings < transactions.getTransferAmount()) {
				return "You already have some pending transactions!\nYour savings account would not have that much balance if these transactions are permitted!";
			}
		}

		Transactions finalTransaction = new Transactions(transactions.getFromAccountNumber(),
				transactions.getToAccountNumber(), accountSender.getAccountHolderName(),
				accountReceiver.getAccountHolderName(), transactions.getFromAccountType(),
				transactions.getToAccountType(), transactions.getTransferAmount(), transactions.getTransferMessage(),
				new Date(), transactions.getTransferStatus());

		this.transactionsRepository.save(finalTransaction);
		return "Transfer initiated.\nCheck the status in the transactions tab!";
	}

	@Override
	public String updateTransaction(int id) {
		Transactions transaction = this.transactionsRepository.getOne(id);
		
		Accounts receiverAccount = this.accountsRepository.getOne(transaction.getToAccountNumber());
		Accounts senderAccount = this.accountsRepository.getOne(transaction.getFromAccountNumber());
		
		if(transaction.getFromAccountType().equals("Primary")) {
			if(transaction.getToAccountType().equals("Primary")) {
				this.accountsRepository.updatePrimaryBalance(
						receiverAccount.getAccountBalancePrimary()+transaction.getTransferAmount(), 
						receiverAccount.getAccountNumber()
				);
			} else {
				this.accountsRepository.updateSavingsBalance(
						receiverAccount.getAccountBalanceSavings()+transaction.getTransferAmount(), 
						receiverAccount.getAccountNumber()
				);
			}
			this.accountsRepository.updatePrimaryBalance(
					senderAccount.getAccountBalancePrimary()-transaction.getTransferAmount(), 
					senderAccount.getAccountNumber()
			);
		} else {
			if(transaction.getToAccountType().equals("Primary")) {
				this.accountsRepository.updatePrimaryBalance(
						receiverAccount.getAccountBalancePrimary()+transaction.getTransferAmount(), 
						receiverAccount.getAccountNumber()
				);
			} else {
				this.accountsRepository.updateSavingsBalance(
						receiverAccount.getAccountBalanceSavings()+transaction.getTransferAmount(), 
						receiverAccount.getAccountNumber()
				);
			}
			this.accountsRepository.updateSavingsBalance(
					senderAccount.getAccountBalanceSavings()-transaction.getTransferAmount(), 
					senderAccount.getAccountNumber()
			);
		}
		
		this.transactionsRepository.updateTransaction(1, id);
		return "Transaction Permitted!";
	}

	@Override
	public List<FrontendTransaction> getTransactionsForAccountNumber(String accountNumber) {
		List<Transactions> mainList = this.transactionsRepository.getTransactionsForAccountNumber(accountNumber);
		List<FrontendTransaction> toReturnList = new ArrayList<FrontendTransaction>();
		for (Transactions temp : mainList) {
			FrontendTransaction tempTransaction = new FrontendTransaction();
			tempTransaction.setId(temp.getId());
			tempTransaction.setFromAccountNumber(temp.getFromAccountNumber());
			tempTransaction.setToAccountNumber(temp.getToAccountNumber());
			tempTransaction.setFromAccountHolderName(temp.getFromAccountHolderName());
			tempTransaction.setToAccountHolderName(temp.getToAccountHolderName());
			tempTransaction.setFromAccountType(temp.getFromAccountType());
			tempTransaction.setToAccountType(temp.getToAccountType());
			tempTransaction.setTransferAmount(temp.getTransferAmount());
			tempTransaction.setTransferMessage(temp.getTransferMessage());
			tempTransaction.setTransferDate(temp.getTransferDate()+"");
			tempTransaction.setTransferStatus(temp.getTransferStatus());
			if (temp.getFromAccountNumber().equals(accountNumber)) {
				tempTransaction.setTransferType("Debited");
			} else {
				tempTransaction.setTransferType("Credited");
			}
			toReturnList.add(tempTransaction);
		}
		return toReturnList;
	}

	@Override
	public List<Transactions> getAllPendingTransactions() {
		return this.transactionsRepository.getPendingTransactions(0);
	}

	@Override
	public List<FrontendTransaction> getFilteredTransactions(String accountNumber, String startDate, String endDate) {
		List<Transactions> mainList = this.transactionsRepository
				.getFilteredTransactions(accountNumber, startDate, endDate);
		System.out.println(mainList);
		List<FrontendTransaction> toReturnList = new ArrayList<FrontendTransaction>();
		for (Transactions temp : mainList) {
			FrontendTransaction tempTransaction = new FrontendTransaction();
			tempTransaction.setId(temp.getId());
			tempTransaction.setFromAccountNumber(temp.getFromAccountNumber());
			tempTransaction.setToAccountNumber(temp.getToAccountNumber());
			tempTransaction.setFromAccountHolderName(temp.getFromAccountHolderName());
			tempTransaction.setToAccountHolderName(temp.getToAccountHolderName());
			tempTransaction.setFromAccountType(temp.getFromAccountType());
			tempTransaction.setToAccountType(temp.getToAccountType());
			tempTransaction.setTransferAmount(temp.getTransferAmount());
			tempTransaction.setTransferMessage(temp.getTransferMessage());
			tempTransaction.setTransferDate(temp.getTransferDate()+"");
			tempTransaction.setTransferStatus(temp.getTransferStatus());
			if (temp.getFromAccountNumber().equals(accountNumber)) {
				tempTransaction.setTransferType("Debited");
			} else {
				tempTransaction.setTransferType("Credited");
			}
			toReturnList.add(tempTransaction);
		}
		return toReturnList;
	}
}
