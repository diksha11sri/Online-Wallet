package com.capgemini.onlinewallet.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinewallet.entities.WalletAccount;
import com.capgemini.onlinewallet.entities.WalletTransaction;
import com.capgemini.onlinewallet.exception.*;
import com.capgemini.onlinewallet.repository.WalletAccountRepository;
import com.capgemini.onlinewallet.repository.WalletTransactionRepository;

@Service
public class WalletTransactionServiceImpl implements WalletTransactionService{
	
	@Autowired 
	WalletTransactionRepository walletTransactionRepository;
	
	@Autowired
	WalletAccountRepository walletAccountRepository;
	
	@Autowired 
	WalletAccountService walletAccountService;
	
//transfer amount from one account to other account
// senderId is wallet id of sender
@Override
public void createTransaction(int senderId, WalletTransaction transaction)
{
		   LocalDateTime now = LocalDateTime.now();  
		   WalletAccount senderAccount = new WalletAccount();
		   WalletAccount receiverAccount = new WalletAccount();
		   
			 int recipientAccountId = transaction.getReceiverAccountId();
		     double transferAmount = transaction.getAmount();
			 senderAccount = walletAccountService.showAccountById(senderId);
			 // System.out.println(senderAccount);
			 
			 double senderPrevBalance = senderAccount.getAccountBalance();
			 receiverAccount = walletAccountService.showAccountById(transaction.getReceiverAccountId());
			 
			 double receiverPrevBalance = receiverAccount.getAccountBalance();
			 double senderFinalBalance  = senderPrevBalance - transferAmount;
			 double receiverfinalBalance = receiverPrevBalance + transferAmount;
			 senderAccount.setAccountBalance(senderFinalBalance);
			 receiverAccount.setAccountBalance(receiverfinalBalance);
			
			 senderFinalBalance = walletAccountService.updateBalance(senderAccount);
			 receiverfinalBalance = walletAccountService.updateBalance(receiverAccount);
			 transaction.setAccountId(senderId);
		     transaction.setAccountBalance(senderFinalBalance);
			 transaction.setDateOfTransaction(now);
			 walletTransactionRepository.save(transaction);	
}
 
//list all the transactions done in wallet
@Override
	public List<WalletTransaction> getTransactionList(int accountId) {
   	Optional<WalletAccount> isUser = walletAccountRepository.findById(accountId);
   	if(isUser.isPresent())
		    return walletTransactionRepository.findAllByAccountId(accountId);
   	else	
			return null;
}
	@Override
	public List<WalletTransaction> findAllByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}
}