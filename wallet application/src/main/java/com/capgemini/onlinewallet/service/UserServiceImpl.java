package com.capgemini.onlinewallet.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.onlinewallet.dto.WalletUserDto;
import com.capgemini.onlinewallet.entities.WalletUser;
import com.capgemini.onlinewallet.exception.*;
import com.capgemini.onlinewallet.repository.*;

@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
		UserRepository userRepository;
	
//register new user	
public WalletUser addUser(WalletUser user)
{
	Optional<WalletUser> findById= userRepository.findById(user.getUserId());
		if(!findById.isPresent()) 
		{
			WalletUser newUser=userRepository.save(user);
			return newUser;
		}
		return null;
}
	
//returns user by Id
public WalletUser showUserById(int userId) 
{
   Optional<WalletUser> findById = userRepository.findById(userId);
	  if (findById.isPresent()) 
	  {
		 WalletUser user = findById.get();
			return user;
	  }
			return null;
}
		
// update data of user
public String updateUser(int userId, WalletUser walletUser) 
{
   Optional<WalletUser> findById = userRepository.findById(userId);
		if (findById.isPresent())
		{
		  WalletUser user = findById.get();
		  user.setUserName(walletUser.getUserName());
		  user.setPassword(walletUser.getPassword());
		  user.setPhoneNumber(walletUser.getPhoneNumber());
		  //	userRepository.save(walletUser);
			return "User Updated";
		 }
		else 
		{
			throw new UserNotFoundException("User Not Found for Id" + userId);
		}
			
}

//authenticate user to login by using name and password
public WalletUser checkUserLogin(String loginName,String password) 
{
	Optional<WalletUser> user = userRepository.checkUserLogin(loginName,password);
	System.out.println(user);
	if(user.isPresent()) 
	 {
			return user.get();
	 }
	else
 	 throw new InvalidPasswordException("User Not Found");
}


@Override
public Boolean updatePassword(int userId, WalletUserDto walletUser) {
	// TODO Auto-generated method stub
	   Optional<WalletUser> findById = userRepository.findById(userId);
			if (findById.isPresent())
			{
			  WalletUser user = findById.get();
			  System.out.println(user.toString());
			  if(user.getPassword().equals(walletUser.getPassword())) {
				  user.setPassword(walletUser.getNewPassword());
				  return true;
			  }else {
				  throw new InvalidPasswordException("Invalid Password");
			  }
			 }
			else 
			{
				throw new UserNotFoundException("User Not Found for Id" + userId);
			}
}



}
