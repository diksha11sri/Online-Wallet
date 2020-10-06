package com.capgemini.onlinewallet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinewallet.entities.WalletAccount;
import com.capgemini.onlinewallet.entities.WalletUser;
import com.capgemini.onlinewallet.repository.BankAccountRepository;
import com.capgemini.onlinewallet.repository.UserRepository;
import com.capgemini.onlinewallet.repository.WalletAccountRepository;

@Service
public class WalletAccountServiceImpl implements WalletAccountService {
	@Autowired 
	WalletAccountRepository walletAccountRepository;
	
	@Autowired
	BankAccountRepository bankAccountRepository;
	
	@Autowired
	UserRepository userRepository;
	
//create wallet account
public WalletAccount createWalletAccount(WalletAccount account) 
{
		WalletAccount wa = null;
		wa = walletAccountRepository.save(account);
		return wa;
}
	
//update wallet account
public WalletAccount updateWalletAccount(WalletAccount account) 
{
		WalletAccount walletAccount = null;
		walletAccount = walletAccountRepository.save(account);
		return walletAccount;
}

//show user account details on the basis of id
public WalletAccount showAccount(int userId)
{
		Optional<WalletUser> findById = userRepository.findById(userId);
	if (findById.isPresent())
	{
		WalletAccount wallet = walletAccountRepository.findWalletByUserId(userId);
		return wallet;
	}
	return null;
}
	
//show wallet account on the basis of wallet id
public WalletAccount showAccountById(int userId) 
{
Optional<WalletAccount> findById = walletAccountRepository.findById(userId);
	if (findById.isPresent()) 
	{
		WalletAccount user = findById.get();
		return user;
	}
return null;
}

//find bank exists in wallet
public boolean findBankToWallet(int walletAccountId) 
{
boolean flag = false;
		flag = bankAccountRepository.existsById(walletAccountId);
		return flag;
}

//get sender  balance on the basis of id
public double getBalance(int accountId)
{
double balance = 0;
balance = walletAccountRepository.findById(accountId).get().getAccountBalance();
return balance;
}

//update wallet account balance 
public double updateBalance(WalletAccount account)
{
	double totalBalance = 0;
		walletAccountRepository.save(account);
		totalBalance = this.getBalance(account.getAccountId());
return totalBalance;

}
	
}

	

	

