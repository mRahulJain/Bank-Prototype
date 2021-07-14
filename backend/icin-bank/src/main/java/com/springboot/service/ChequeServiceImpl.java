package com.springboot.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.pojo.Cheque;
import com.springboot.repository.ChequeRepository;

@Service(value = "chequeService")
public class ChequeServiceImpl implements ChequeService {

	@Autowired
	private ChequeRepository chequeRepository;

	@Override
	public String generateChequeBookRequest(String accountNumber, String accountType) {
		if(isSomeChequeBookRequested(accountNumber, accountType).equals("No pending requests")) {
			int count = getChequeBookCount(accountNumber) + 1;
			Cheque cheque = new Cheque();
			cheque.setAccountNumber(accountNumber);
			cheque.setChequeBookNumber(accountNumber+""+count);
			cheque.setAccountType(accountType);
			cheque.setChequeBookIssueDate(new Date());
			cheque.setChequeBookStatus(0);
			this.chequeRepository.save(cheque);
			return "Requested for a cheque book for account number - "+accountNumber;
		} 
		return "There is already a pending request for cheque book from "+accountType+" account - "+accountNumber;
	}

	@Override
	public int getChequeBookCount(String accountNumber) {
		int count = 0;
		List<Cheque> list = this.chequeRepository.findAll();
		for(Cheque temp : list) {
			if(temp.getAccountNumber().equals(accountNumber)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public String isSomeChequeBookRequested(String accountNumber, String accountType) {
		List<Cheque> list = this.chequeRepository.findAll();
		for(Cheque temp : list) {
			if(temp.getAccountNumber().equals(accountNumber) && temp.getAccountType().equals(accountType)) {
				if(temp.getChequeBookStatus() == 0) {
					return "Already Requested!";
				}
			}
		}
		return "No pending requests";
	}

	@Override
	public String changeChequeBookStatus(String chequeBookNumber) {
		Cheque cheque = this.chequeRepository.getOne(chequeBookNumber);
		this.chequeRepository.updateChequeBookStatus(1, chequeBookNumber);
		return "Cheque Book Request Accepted for account number - "+cheque.getAccountNumber();
	}

	@Override
	public List<Cheque> getAllChequeBookIssued(String accountNumber) {
		return this.chequeRepository.getChequeBookIssuedByAccountNumber(accountNumber);
	}

	@Override
	public List<Cheque> getAllPendingChequeBookRequests() {
		return this.chequeRepository.getAllPendingChequeBookRequests(0);
	}
}
