package com.xtu.graduation.common.dao;

public interface ICommonDao extends IDaoSupport  {

	public Object loginConfirm(String userName, String password, Integer userType) ;
}
