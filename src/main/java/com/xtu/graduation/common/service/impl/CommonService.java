package com.xtu.graduation.common.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xtu.graduation.common.dao.ICommonDao;
import com.xtu.graduation.common.service.ICommonService;
@Service
public class CommonService implements ICommonService {

	@Resource
	private ICommonDao commonDao;
	
	@Override
	public Object loginConfirm(String userName, String password, Integer userType) {
		// TODO Auto-generated method stub
		return commonDao.loginConfirm(userName, password, userType);
	}

}
