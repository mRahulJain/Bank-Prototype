package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.pojo.Accounts;
import com.springboot.pojo.Users;
import com.springboot.repository.AccountsRepository;
import com.springboot.repository.UsersRepository;

@Service(value = "usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Override
	public String putUser(Users user) {
		List<Accounts> accounts = this.accountsRepository.findAll();
		Accounts account = null;
		for(Accounts temp : accounts) {
			if(temp.getAccountNumber().equals(user.getAccountNumber())) {
				account = temp;
				break;
			}
		}
		if(account == null) {
			return "No such account exist!";
		}
		if(!account.getAccountHolderName().equals(user.getAccountHolderName())) {
			return "Name does not match with the database!";
		}
		if(account.getAccountIsNetBankingReg() == 1) {
			return "Account already registered!";
		}
		this.accountsRepository.updateAccountNetBankingStatus(1, account.getAccountNumber());
		this.usersRepository.save(user);
		return "Successfully registered!";
	}

	@Override
	public String checkUserByIdAndPassword(String loginUserId, String loginUserPassword) {
		List<Users> list = this.usersRepository.findAll();
		for(Users user : list) {
			if(user.getAccountLoginUserId().equals(loginUserId)) {
				if(user.getAccountIsBlocked() == 1) {
					return "failure";
				}
				if(user.getAccountLoginPassword().equals(loginUserPassword)) {
					return "success";
				} else {
					return "Password entered is wrong!";
				}
			}
		}
		return "no-user";
	}

	@Override
	public Users getUserViaUserId(String loginUserId) {
		List<Users> list = this.usersRepository.findAll();
		for(Users user : list) {
			if(user.getAccountLoginUserId().equals(loginUserId)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public String updateLoginPassword(String newPassword, String accountNumber) {
		this.usersRepository.updateUserPassword(newPassword, accountNumber);
		return "Successfully changed login password!";
	}

	@Override
	public String blockUser(String loginUserId) {
		this.usersRepository.toggleBlockUser(1, loginUserId);
		return "You account has been blocked!\nPlease contact your nearest ICIN bank!";
	}

	@Override
	public String unblockUser(String loginUserId) {
		this.usersRepository.toggleBlockUser(0, loginUserId);
		return "Account Unblocked";
	}

	@Override
	public List<Users> getAllBlockedUser() {
		return this.usersRepository.getAllBlockedUser(1);
	}

}
