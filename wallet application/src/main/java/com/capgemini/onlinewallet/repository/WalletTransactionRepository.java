package com.capgemini.onlinewallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinewallet.entities.WalletTransaction;

import java.util.List;

@Repository("walletTransactionRepository")
public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Integer>{

	@Query(value="select wt from WalletTransaction wt where wt.accountId= :accountId")
	List<WalletTransaction> findAllByAccountId(@Param("accountId")int accountId);

}
