package com.xtu.graduation.common.util;

import org.junit.Test;

public class EDSUtilTest {
	
	@Test
	public  void testEDSUtil() {
		String a = EDSUtil.encrypt("123456");
		System.out.println(a);
		String b = EDSUtil.decrypt(a);
		System.out.println(b);
	}
}
