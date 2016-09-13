package com.xtu.graduation.admin.dao;

import com.xtu.graduation.admin.entity.Admin;
import com.xtu.graduation.common.dao.IDaoSupport;

public interface IAdminDao extends IDaoSupport {

	public Admin loginConfirm(String userName, String password);
}
