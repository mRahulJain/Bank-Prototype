package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pojo.Cheque;
import com.springboot.pojo.Message;
import com.springboot.pojo.Users;
import com.springboot.service.ChequeService;
import com.springboot.service.UsersService;

@CrossOrigin
@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private ChequeService chequeService;
	
	@GetMapping("/users/{loginUserId}")
	public Users getUserViaUserId(@PathVariable String loginUserId) {
		return this.usersService.getUserViaUserId(loginUserId);
	}
	
	@GetMapping("/users/check/{loginUserId}/{loginUserPassword}")
	public Message checkUserByIdAndPassword(@PathVariable String loginUserId, @PathVariable String loginUserPassword) {
		Message message = new Message(this.usersService.checkUserByIdAndPassword(loginUserId, loginUserPassword));
		return message;
	}
	
	@PostMapping("/users/addUser")
	public Message putUser(@RequestBody Users user) {
		Message message = new Message(this.usersService.putUser(user));
		return message;
	}
	
	@GetMapping("/users/update/loginPassword/{newPassword}/{accountNumber}")
	public Message updateLoginPassword(@PathVariable String newPassword, @PathVariable String accountNumber) {
		Message message = new Message(this.usersService.updateLoginPassword(newPassword, accountNumber));
		return message;
	}
	
	@GetMapping("/users/request-cheque-book/{accountNumber}/{accountType}")
	public Message requestChequeBook(@PathVariable String accountNumber, @PathVariable String accountType) {
		Message message = new Message(this.chequeService.generateChequeBookRequest(accountNumber, accountType));
		return message;
	}
	
	@GetMapping("/users/cheque-books/{accountNumber}")
	public List<Cheque> getChequeBooksIssuedByAccountNumber(@PathVariable String accountNumber) {
		return this.chequeService.getAllChequeBookIssued(accountNumber);
	}
	
	@GetMapping("/admin/cheque-books-requests")
	public List<Cheque> getAllChequeBookRequests() {
		return this.chequeService.getAllPendingChequeBookRequests();
	}
	
	@GetMapping("/admin/cheque-books-requests/accept/{chequeBookNumber}")
	public Message acceptChequeBookRequest(@PathVariable String chequeBookNumber) {
		Message message = new Message(this.chequeService.changeChequeBookStatus(chequeBookNumber));
		return message;
	}
	
	@GetMapping("/users/block/{loginUserId}")
	public Message blockUser(@PathVariable String loginUserId) {
		Message message = new Message(this.usersService.blockUser(loginUserId));
		return message;
	}
	
	@GetMapping("/users/unblock/{loginUserId}")
	public Message unblockUser(@PathVariable String loginUserId) {
		Message message = new Message(this.usersService.unblockUser(loginUserId));
		return message;
	}
	
	@GetMapping("/users/blocked-users")
	public List<Users> unblockUser() {
		return this.usersService.getAllBlockedUser();
	}
	
	
}
