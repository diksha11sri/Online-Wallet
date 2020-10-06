package com.capgemini.onlinewallet.test;

import org.junit.jupiter.api.Assertions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capgemini.onlinewallet.OnlinewalletApplication;
import com.capgemini.onlinewallet.entities.WalletTransaction;

@SpringBootTest
public class WalletTransactionTests {

	static Logger logger=LoggerFactory.getLogger(OnlinewalletApplication.class);
	
	RestTemplate template;
	
	@BeforeEach
	public void setUp()
	{
		template=new RestTemplate();		
	}
	@Test
	public void getTransactionList() {
		List<WalletTransaction> walletTrans= template.getForObject("http://localhost:8071/transactionList/10001", List.class);
		Assertions.assertNotNull(walletTrans);
		logger.info("!! The accountId fetch list works !!");
	}
}
