package com.capgemini.onlinewallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinewallet.entities.WalletUser;

@Repository
public interface UserRepository  extends JpaRepository< WalletUser ,Integer> {
		
	@Query( value="select * from wallet_user where user_name=:userName or user_password=:password", nativeQuery=true)
	public Optional<WalletUser> checkUserLogin(@Param(value = "userName") String userName, @Param(value = "password") String password);

	
}
