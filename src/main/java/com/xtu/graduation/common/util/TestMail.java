package com.xtu.graduation.common.util;

public class TestMail {

	public static void main(String[] args) {
		MailTemplate mailTemplate = (MailTemplate) ApplicationContextUtil.getApplicationContext().getBean("mailTemplate");
		String [] toAddress={"1217201052@qq.com"};
		mailTemplate.send(toAddress, null, null, "Test", "This is a Test", false);
	}
}
