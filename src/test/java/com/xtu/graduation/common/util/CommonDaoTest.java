package com.xtu.graduation.common.util;

import javax.annotation.Resource;

import org.junit.Test;

import com.xtu.graduation.AbstractSpringTest;
import com.xtu.graduation.common.dao.ICommonDao;

public class CommonDaoTest extends AbstractSpringTest {
	
	@Resource
	private ICommonDao commonDao;
	
	@Test
	public void testLogin1(){
		Integer userType = 1;
		String userName = "2012551435";
		String password = "123456";
		Object obj =  commonDao.loginConfirm(userName, password, userType);
		System.out.println("==============================================================");
		System.out.println(obj.getClass().getSimpleName());
		System.out.println("==============================================================");
	}
	
	@Test
	public void testLogin2(){
		Integer userType = 2;
		String userName = "12551435";
		String password = "123456";
		Object obj =  commonDao.loginConfirm(userName, password, userType);
		System.out.println("==============================================================");
		System.out.println(obj.getClass().getSimpleName());
		System.out.println("==============================================================");
	}
	
	@Test
	public void testLogin3(){
		Integer userType = 3;
		String userName = "admin";
		String password = "admin";
		Object obj =  commonDao.loginConfirm(userName, password, userType);
		System.out.println("==============================================================");
		System.out.println(obj.getClass().getSimpleName());
		System.out.println("==============================================================");
	}
}
