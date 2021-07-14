package com.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.Cheque;
import com.springboot.pojo.Users;

@Repository(value = "usersRepository")
public interface UsersRepository extends JpaRepository<Users, String> {

	@Query(value = "SELECT * from users where ACCOUNT_LOGIN_USER_ID like ?1", nativeQuery = true)
	List<Users> getUserByLoginUserID(String loginUserId);

	@Query(value = "SELECT * from users where ACCOUNT_IS_BLOCKED like ?1", nativeQuery = true)
	List<Users> getAllBlockedUser(int status);

	@Transactional
	@Modifying
	@Query(value = "UPDATE users set ACCOUNT_LOGIN_PASSWORD=?1 where ACCOUNT_NUMBER like ?2", nativeQuery = true)
	void updateUserPassword(String newPassword, String accountNumber);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE users set ACCOUNT_IS_BLOCKED=?1 where ACCOUNT_LOGIN_USER_ID like ?2", nativeQuery = true)
	void toggleBlockUser(int status, String loginUserId);

}
