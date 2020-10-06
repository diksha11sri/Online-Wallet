package com.capgemini.onlinewallet.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.onlinewallet.entities.WalletTransaction;

public interface WalletTransactionService {
	
	
	public void createTransaction(int senderId,WalletTransaction transaction);
	
	
	public List<WalletTransaction> findAllByAccountId(@Param("accountId")int accountId);
	
	List<WalletTransaction> getTransactionList(int accountId);



}
