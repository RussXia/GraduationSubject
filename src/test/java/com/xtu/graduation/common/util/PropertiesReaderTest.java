package com.xtu.graduation.common.util;

import org.junit.Test;


public class PropertiesReaderTest {

	@Test
	public void testGetProperties(){
		String url = PropertiesReaderHelper.getEmailProperties().getProperty("XTUGraduation_URL");
		System.out.println(url);
	}
}
