package com.capgemini.onlinewallet.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinewallet.entities.WalletTransaction;
import com.capgemini.onlinewallet.exception.LowBalanceException;
import com.capgemini.onlinewallet.service.WalletAccountService;
import com.capgemini.onlinewallet.service.WalletTransactionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

	@Autowired
	private WalletTransactionService walletTransactionService;
	@Autowired
	private WalletAccountService walletAccountService;

// transfer the fund from one account to the other account
@PostMapping("/transaction/{id}")
public String transferFund(@PathVariable("id") int senderId, @RequestBody WalletTransaction transaction) throws LowBalanceException 
{
		double availableBalance = walletAccountService.getBalance(senderId);
		System.out.println(availableBalance);
	    System.out.println(senderId);
		System.out.println(transaction.getAmount());
		System.out.println(transaction.toString());
		if (availableBalance >= transaction.getAmount()) 
		{
			walletTransactionService.createTransaction(senderId, transaction);
			return "Transaction Created";
		}
		else 
		{
			throw new LowBalanceException("Low Balance Exception...");
		}
	}

// this method is used to display the list of transactions done by a user
@GetMapping("/transactionList/{accountId}")
public List<WalletTransaction> getTransactionList(@PathVariable int accountId){
		List<WalletTransaction> list = walletTransactionService.getTransactionList(accountId);
		if(list == null)
			return new ArrayList<>();
		else
			return list;
	
}
}
