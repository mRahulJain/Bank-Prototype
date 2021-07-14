package com.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.pojo.Accounts;

@Repository(value = "accountsRepository")
public interface AccountsRepository extends JpaRepository<Accounts, String> {

	@Query(value = "SELECT * from accounts where ACCOUNT_NUMBER like ?1", nativeQuery = true)
	List<Accounts> getAccountByAccountNumber(String accountNumber);

	@Transactional
	@Modifying
	@Query(value = "UPDATE accounts set ACCOUNT_IS_NET_BANKING_REG=?1 where ACCOUNT_NUMBER like ?2", nativeQuery = true)
	void updateAccountNetBankingStatus(int status, String accountNumber);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE accounts set ACCOUNT_BALANCE_PRIMARY=?1 where ACCOUNT_NUMBER like ?2", nativeQuery = true)
	void updatePrimaryBalance(double balance, String accountNumber);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE accounts set ACCOUNT_BALANCE_SAVINGS=?1 where ACCOUNT_NUMBER like ?2", nativeQuery = true)
	void updateSavingsBalance(double balance, String accountNumber);

}
