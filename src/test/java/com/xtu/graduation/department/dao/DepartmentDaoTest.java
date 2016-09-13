package com.xtu.graduation.department.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.xtu.graduation.AbstractSpringTest;
import com.xtu.graduation.department.entity.Department;

public class DepartmentDaoTest extends AbstractSpringTest{
	
	@Resource
	private IDepartmentDao departmentDao;
	
	@Test
	public void testSaveDepart(){
		String[] strs = {"信息工程学院","商学院","法学院","文学与新闻学院","外国语学院","数学与计算科学学院",
				"物理与光电工程学院","化学学院","机械工程学院","土木工程与力学学院","艺术学院"};
		for(String str : strs){
			Department depart = new Department();
			depart.setDepartmentName(str);
			departmentDao.save(depart);
		}
	}
	
	@Test
	public void testFindDepart(){
		Long id = 1L;
		Department depart = departmentDao.find(Department.class, id);
		Long i = departmentDao.count(Department.class);
		System.out.println(depart+"======"+i);
	}

}
