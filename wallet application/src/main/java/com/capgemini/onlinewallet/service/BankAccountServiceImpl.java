package com.capgemini.onlinewallet.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinewallet.entities.BankAccount;
import com.capgemini.onlinewallet.entities.WalletAccount;
import com.capgemini.onlinewallet.repository.BankAccountRepository;
import com.capgemini.onlinewallet.repository.WalletAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	BankAccountRepository bankDao;
	
	@Autowired
	WalletAccountRepository walletDao;
	
//add bank account to wallet
@Override
public BankAccount addBankAccount(BankAccount bank)
	{
		BankAccount bankAccount=null;
		Random rand = new Random(); 
		bank.setAccountNo(rand.nextInt(100000));	
	    bankAccount=bankDao.save(bank);
		return bankAccount;
	}

// show account details on the basis of id
public BankAccount showBankAccount(int walletId) 
{
		WalletAccount bankId=walletDao.findById(walletId).get();
		Optional<BankAccount> findById = bankDao.findById(bankId.getAccountId());
		if (findById.isPresent()) 
		{
			BankAccount user = findById.get();
			return user;
		}
		return null;	
}

//search bank account on the basis of id
public BankAccount findBankAccount(int walletId)
{
		Optional<WalletAccount> findById = walletDao.findById(walletId);
	      if (findById.isPresent())
	      {
			BankAccount account = bankDao.findBankByWalletId(walletId);
		    return account;
	       }
	return null;
}
}




