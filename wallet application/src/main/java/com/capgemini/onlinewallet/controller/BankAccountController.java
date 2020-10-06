package com.capgemini.onlinewallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capgemini.onlinewallet.entities.BankAccount;
import com.capgemini.onlinewallet.entities.WalletAccount;
import com.capgemini.onlinewallet.exception.*;
import com.capgemini.onlinewallet.service.BankAccountService;
import com.capgemini.onlinewallet.service.WalletAccountService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/BankAccount")
public class BankAccountController {
	
	@Autowired 
	BankAccountService bankAccountService;
	
	@Autowired
	WalletAccountService walletAccountService;
	
//add bank account to the wallet
@PostMapping("/addAccount/{walletId}")
public BankAccount addBankAccount(@PathVariable int walletId, @RequestBody BankAccount bankAccount) 
	{
		BankAccount bank=new BankAccount();
		WalletAccount account = new WalletAccount();
		account=walletAccountService.showAccountById(walletId);
		
		// System.out.println();
		bankAccount.setWalletAccount(account);
		bank = bankAccountService.addBankAccount(bankAccount);
		return bank;
	}
		
//find the bank account on the basis of wallet id
@GetMapping("/findBankAccount/{walletId}")
public BankAccount findBankAccount(@PathVariable int walletId) 
	{
		BankAccount bank = new BankAccount();
		bank=bankAccountService.findBankAccount(walletId);
			if (bank == null)
			{
				throw new UserNotFoundException("Record Not Found");
		    }
		return bank;
	}

}
