package com.capgemini.onlinewallet.service;

import org.springframework.stereotype.Service;

import com.capgemini.onlinewallet.entities.BankAccount;

@Service
public interface BankAccountService 
{

	BankAccount addBankAccount(BankAccount bankAccount);

	BankAccount findBankAccount(int walletId);

	BankAccount showBankAccount(int walletId);


}