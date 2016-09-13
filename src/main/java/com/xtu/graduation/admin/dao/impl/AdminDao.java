package com.xtu.graduation.admin.dao.impl;

import org.springframework.stereotype.Repository;

import com.xtu.graduation.admin.dao.IAdminDao;
import com.xtu.graduation.admin.entity.Admin;
import com.xtu.graduation.common.dao.jpa.JpaDaoTemplate;

@Repository
public class AdminDao extends JpaDaoTemplate implements IAdminDao {

	@Override
	public Admin loginConfirm(String userName, String password) {
		String query = "Select Entity From Admin Entity Where Entity.account = ? and Entity.password = ?";
		Admin admin  = this.find(Admin.class, query, userName,password);
		return admin;
	}

}
