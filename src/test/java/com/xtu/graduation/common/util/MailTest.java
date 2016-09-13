package com.xtu.graduation.common.util;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xtu.graduation.AbstractSpringTest;

public class MailTest extends AbstractSpringTest {

	@Autowired
	private MailTemplate mailTemplate;
	
	@Test
	public void testSendMail(){
		String [] toAddress={"18373238813@163.com"};
		mailTemplate.send(toAddress, null, null, "Test", "This is a Test", false);
	}
}
