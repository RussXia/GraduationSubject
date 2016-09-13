package com.xtu.graduation.department.service;

import org.springframework.transaction.annotation.Transactional;

import com.xtu.graduation.department.entity.Department;

@Transactional
public interface IDepartmentService {
	
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
