package com.xtu.graduation.department.dao;

import com.xtu.graduation.common.dao.IDaoSupport;
import com.xtu.graduation.department.entity.Department;

public interface IDepartmentDao extends IDaoSupport{
	/**
	 * 根据院系id查询院系
	 * @param id
	 * @return
	 */
	public Department findDepartmentById(Long id);
	
	/**
	 * 根据院系名称查询院系
	 * @param departName
	 * @return
	 */
	public Department findDepartmentByName(String departName);
}
