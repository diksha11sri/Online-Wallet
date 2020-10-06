package com.capgemini.onlinewallet.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinewallet.entities.Status;
import com.capgemini.onlinewallet.entities.WalletAccount;
import com.capgemini.onlinewallet.entities.WalletUser;
import com.capgemini.onlinewallet.exception.*;
import com.capgemini.onlinewallet.service.UserService;
import com.capgemini.onlinewallet.service.WalletAccountService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/WalletAccount")
public class WalletController{

@Autowired
private WalletAccountService walletAccountService;

@Autowired
private UserService userService;

//create walletUser account
@GetMapping(value = "/create/{userId}")
public WalletAccount createWalletUser(@PathVariable int userId) {
	WalletAccount account = new WalletAccount();
	WalletUser user=new WalletUser();
	user=userService.showUserById(userId);
	Random random=new Random();
	account.setAccountId(random.nextInt(100000));
	account.setStatus(Status.ACTIVE);
	account.setAccountBalance(0);
	account.setWalletUser(user);
	account = walletAccountService.createWalletAccount(account);
	return account;
}

//show account details on the basis of id
@GetMapping("/seeWalletAccount/{id}")
@ExceptionHandler(UserNotFoundException.class)
public WalletAccount showAccount(@PathVariable("id") int walletId) 
{
	WalletAccount wallet = new WalletAccount();
	wallet = walletAccountService.showAccountById(walletId);
      if (wallet == null)
      {
			throw new UserNotFoundException("Record Not Found");
      }
	return wallet;
} 

//show account details on the basis of id
@GetMapping("/getBalance/{id}")
public Double getWalletAccountBalance(@PathVariable("id") int walletId) 
{
	// WalletAccount wallet = new WalletAccount();
	Double balance = walletAccountService.getBalance(walletId);
    if (balance == null)
    {
			return 0.0;
    }
	return balance;
}

// add money to wallet
@GetMapping("/addMoney/{accountId}/{amount}")
public double addMoney(@PathVariable int accountId, @PathVariable double amount) 
{
	double finalBalance = 0;
		WalletAccount account = walletAccountService.showAccountById(accountId);
		double prevBalance = account.getAccountBalance();
		finalBalance  = prevBalance + amount;
		account.setAccountBalance(finalBalance);
		finalBalance = walletAccountService.updateBalance(account);
return finalBalance;
}
}
