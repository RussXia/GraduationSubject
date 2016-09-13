package com.xtu.graduation.common.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.xtu.graduation.admin.dao.IAdminDao;
import com.xtu.graduation.admin.entity.Admin;
import com.xtu.graduation.common.dao.ICommonDao;
import com.xtu.graduation.common.dao.jpa.JpaDaoTemplate;
import com.xtu.graduation.department.dao.IDepartmentDao;
import com.xtu.graduation.department.entity.Department;
import com.xtu.graduation.student.dao.IStudentDao;
import com.xtu.graduation.student.entity.Student;
import com.xtu.graduation.teacher.dao.ITeacherDao;
import com.xtu.graduation.teacher.entity.Teacher;

@Repository
public class CommonDao extends JpaDaoTemplate implements ICommonDao{
	
	@Resource
	private IStudentDao studentDao;
	
	@Resource
	private ITeacherDao teacherDao;
	
	@Resource
	private IAdminDao adminDao;
	
	@Resource
	private IDepartmentDao departmentDao;
	
	@Override
	public Object loginConfirm(String userName, String password, Integer userType) {
		//用户类型：1.学生	2.教师	3.管理员
		if( userType == 1){
			Student stu = studentDao.loginConfirm(userName, password);
			if(stu != null ){
				Department department = departmentDao.findDepartmentById(stu.getDepartmentId());
				stu.setDepartment(department);
				return stu;
			}
		}else if( userType == 2){
			Teacher teacher = teacherDao.loginConfirm(userName, password);
			if(teacher != null ){
				Department department = departmentDao.findDepartmentById(teacher.getDepartmentId());
				teacher.setDepartment(department);
				return teacher;
			}
		}else if( userType == 3){
			Admin admin = adminDao.loginConfirm(userName, password);
			if(admin != null )
				return admin;
		}
		return null;
	}

}
