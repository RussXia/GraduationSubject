package com.xtu.graduation.department.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xtu.graduation.department.dao.IDepartmentDao;
import com.xtu.graduation.department.entity.Department;
import com.xtu.graduation.department.service.IDepartmentService;
@Service
public class DepartmentService implements IDepartmentService {
	
	@Resource
	private IDepartmentDao departmentDao;
	
	@Override
	public Department findDepartmentById(Long id) {
		return departmentDao.findDepartmentById(id);
	}

	@Override
	public Department findDepartmentByName(String departName) {
		// TODO Auto-generated method stub
		return departmentDao.findDepartmentByName(departName);
	}

}
