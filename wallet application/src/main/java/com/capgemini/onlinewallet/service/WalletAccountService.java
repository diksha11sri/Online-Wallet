package com.capgemini.onlinewallet.service;

import org.springframework.stereotype.Service;

import com.capgemini.onlinewallet.entities.WalletAccount;
import com.capgemini.onlinewallet.entities.WalletTransaction;

@Service
public interface WalletAccountService {

	WalletAccount showAccountById(int senderId);

	double updateBalance(WalletAccount senderAccount);

	WalletAccount createWalletAccount(WalletAccount account);

	WalletAccount showAccount(int userId);

	double getBalance(int senderId);

}