package com.springboot.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.pojo.Transactions;

@Repository(value = "transactionsRepository")
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

	@Query(
			value = "SELECT * from transactions where FROM_ACCOUNT_NUMBER like ?1 OR TO_ACCOUNT_NUMBER like ?1 order by ID desc",
			nativeQuery = true)
	List<Transactions> getTransactionsForAccountNumber(String accountNumber);
	
	@Query(
			value = "SELECT * from transactions where FROM_ACCOUNT_NUMBER like ?1 order by TRANSFER_DATE desc",
			nativeQuery = true)
	List<Transactions> getTransactionsByAccountNumber(String accountNumber);
	
	@Query(
			value = "SELECT * from transactions where TRANSFER_STATUS like ?1 order by TRANSFER_DATE",
			nativeQuery = true)
	List<Transactions> getPendingTransactions(int status);
	
	@Query(
			value = "SELECT * from transactions "
					+ "where (FROM_ACCOUNT_NUMBER like ?1 OR TO_ACCOUNT_NUMBER like ?1) "
					+ "and "
					+ "(TRANSFER_DATE between CAST(?2 as DATE) and CAST(?3 as DATE)) "
					+ "order by TRANSFER_DATE desc",
			nativeQuery = true)
	List<Transactions> getFilteredTransactions(String accountNumber, String startDate, String endDate);
	
	@Transactional
	@Modifying
	@Query(
			value = "UPDATE transactions set TRANSFER_STATUS=?1 where ID like ?2",
			nativeQuery = true)
	void updateTransaction(int status, int id);
	
}
