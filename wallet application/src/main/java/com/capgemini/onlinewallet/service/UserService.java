package com.capgemini.onlinewallet.service;

import org.springframework.stereotype.Service;

import com.capgemini.onlinewallet.dto.WalletUserDto;
import com.capgemini.onlinewallet.entities.WalletUser;

@Service
public interface UserService {

	WalletUser showUserById(int userId);

	WalletUser addUser(WalletUser user);

	String updateUser(int userId, WalletUser walletUser);

	WalletUser checkUserLogin(String loginName, String password);
	
	Boolean updatePassword(int userId, WalletUserDto walletUser);

}