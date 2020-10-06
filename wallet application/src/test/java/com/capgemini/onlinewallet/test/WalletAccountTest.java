package com.capgemini.onlinewallet.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import com.capgemini.onlinewallet.entities.WalletAccount;

@ContextConfiguration
public class WalletAccountTest {
	RestTemplate template;
	
	@BeforeEach
	public void setUp()
	{
		template=new RestTemplate();		
	}
	
	
	@Test
	public void showAccountById() {
		WalletAccount wallet =template.getForObject("http://localhost:8071/WalletAccount/seeWalletAccount/50908", WalletAccount.class);
		Assertions.assertNotNull(wallet);
		System.out.println("!! Search wallet account By Wallet Id Works !!");
	}
	
	
	
	
}
