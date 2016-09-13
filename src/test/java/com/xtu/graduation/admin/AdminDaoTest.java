package com.xtu.graduation.admin;

import javax.annotation.Resource;

import org.junit.Test;

import com.xtu.graduation.AbstractSpringTest;
import com.xtu.graduation.admin.dao.IAdminDao;
import com.xtu.graduation.admin.entity.Admin;

public class AdminDaoTest extends AbstractSpringTest {
	
	@Resource
	private IAdminDao adminDao;
	
	
	@Test
	public void testSaveAdmin(){
		Admin admin = new Admin();
		admin.setAccount("admin");
		admin.setPassword("admin");
		admin.setUserName("Admin");
		adminDao.save(admin);
	}
	
	@Test
	public void testLogin(){
		String userName = "admin";
		String password = "admin";
		Admin admin = adminDao.loginConfirm(userName, password);
		System.out.println("================"+admin);
	}
}
