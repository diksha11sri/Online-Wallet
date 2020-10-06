package com.capgemini.onlinewallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.capgemini.onlinewallet.dto.UserCredentialDto;
import com.capgemini.onlinewallet.dto.WalletUserDto;
import com.capgemini.onlinewallet.entities.WalletUser;
import com.capgemini.onlinewallet.exception.*;
import com.capgemini.onlinewallet.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public String addUser()
	{

			return "working";
	}
	
// create new wallet user 
@PostMapping("/addUser")
public WalletUser addUser(@RequestBody WalletUser user)
{
   WalletUser add = new WalletUser();
   add = userService.addUser(user);
      if (user == null)
      {
		throw new UserNotFoundException("Record Not Found");

	  } 
		return add;
}

// get user details on the basis of Id
@GetMapping("/findUserById/{id}")
@ExceptionHandler(UserNotFoundException.class)
public WalletUser showUserById(@PathVariable("id") int userId) 
{
		WalletUser user = new WalletUser();
		user = userService.showUserById(userId);
        if (user == null)
        {
			throw new UserNotFoundException("Record Not Found");
        }
			return user;
}

//update user id on the basis of id
@PutMapping("/updateUser/{id}")
public String updateUser(@PathVariable(value = "id") int userId,@Validated @RequestBody WalletUser walletUser) 
{
	userService.updateUser(userId, walletUser);
	return "User updated";
}

//check user login to the wallet portal
@PostMapping("/login")
public WalletUser validUserLogin(@Validated @RequestBody UserCredentialDto walletUser)
{
	WalletUser user = userService.checkUserLogin(walletUser.getUserName(),walletUser.getPassword());
	return user;
			}
	


//update user id on the basis of id
@PutMapping("/updatePass/{id}")
public String updatePassword(@PathVariable(value = "id") int userId,@Validated @RequestBody WalletUserDto walletUserDto) 
{
	if(userService.updatePassword(userId, walletUserDto))
	return "User updated";
	 
	return "Error Occured";
}

}
