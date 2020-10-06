package com.capgemini.onlinewallet.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import com.capgemini.onlinewallet.entities.WalletUser;


@ContextConfiguration
public class OnlineWalletSystemTest {

	RestTemplate template;
		
		@BeforeEach
		public void setUp()
		{
			template=new RestTemplate();		
		}
		
		@Test
		public void addUser() {
			WalletUser user=new WalletUser();
			user.setUserId(900);
		user.setUserName("Aish");
		user.setPassword("aish");		
		user.setPhoneNumber(1345667090);
			
			WalletUser user1=template.postForObject
					("http://localhost:8071/User/addUser", 
					user, WalletUser.class);
			Assertions.assertNotNull(user1);
			System.out.println("Add User Working "+user1);
			
		}
		
		@Test
		public void showUserByUserId() {
			
			WalletUser user =template.getForObject("http://localhost:8071/User/findUserById/73", WalletUser.class);
			Assertions.assertNotNull(user);
			System.out.println("!! Search user By User Id Works !!");
		}
		 
}
