package com.xtu.graduation.department.dao.impl;


import org.springframework.stereotype.Repository;

import com.xtu.graduation.common.dao.jpa.JpaDaoTemplate;
import com.xtu.graduation.department.dao.IDepartmentDao;
import com.xtu.graduation.department.entity.Department;
/**
 * DepartmentDao 院系dao
 * @author Xia
 * @since DepartmentDao.java 2016年3月29日
 */
@Repository("departmentDao")
public class DepartmentDao extends JpaDaoTemplate implements IDepartmentDao{

	@Override
	public Department findDepartmentById(Long id) {
		return this.getEntityManager().find(Department.class, id);
	}
	
	@Override
	public Department findDepartmentByName(String departName){
		String query = "Select Entity From Department Entity Where Entity.departmentName = ?";
		return this.find(Department.class, query, departName);
		
	}
	
}
