package com.xtu.graduation.common.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICommonService {
	public Object loginConfirm(String userName, String password, Integer userType) ;
}
