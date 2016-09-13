package com.xtu.graduation.student.dao.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.xtu.graduation.common.dao.jpa.JpaDaoTemplate;
import com.xtu.graduation.department.dao.IDepartmentDao;
import com.xtu.graduation.department.entity.Department;
import com.xtu.graduation.student.dao.IStudentDao;
import com.xtu.graduation.student.entity.Student;

/**
 * StudentDao 学生dao
 * @author Xia
 * @since StudentDaoImpl.java 2016年3月29日
 */
@Repository("studentDao")
public class StudentDao extends JpaDaoTemplate implements IStudentDao{
	
	@Resource
	private IDepartmentDao departmentDao;
	
	/**
	 * 通过学号查询当前的志愿数
	 * @param id
	 * @return
	 */
	@Override
	public Integer getPresentIdealNum(String sno) {
		return this.findStudentBySno(sno).getPresentIdealNum();
	}
	
	/**
	 * 通过学号查询是否已确选
	 * @param id
	 * @return
	 */
	@Override
	public Boolean isConfirm(String sno) {
		return this.findStudentBySno(sno).getIsConfirm();
	}
	/**
	 * 根据学号查找学生
	 * @param sno
	 * @return
	 */
	@Override
	public Student findStudentBySno(String sno) {
		String query = "Select Entity From Student Entity Where Entity.studentSno = ?";
		Student stu = this.find(Student.class, query, sno);
		return stu;
	}
	

	@Override
	public List<Student> findStudentsByName(String name) {
		String query = "Select Entity From Student Entity Where Entity.studentName = ?";
		return this.list(Student.class, query, name);
	}

	@Override
	public Student loginConfirm(String userName, String password) {
		String query = "Select Entity From Student Entity Where Entity.studentSno = ? and Entity.password = ?";
		Student stu = this.find(Student.class, query, userName,password);
		return stu;
	}

	@Override
	public List<Student> findStudentByDepartmentName(String departmentName) {
		Department department = departmentDao.findDepartmentByName(departmentName);
		String query = "Select Entity From Student Entity Where Entity.departmentId = ?";
		return this.list(Student.class, query, department.getDepartmentId());
	}

	@Override
	public void deleteStudentBySno(String sno) {
		String query = "DELETE From Student Entity Where Entity.studentSno = ?";
		this.execute(query, sno);
	}

	@Override
	public Student findStudentById(Long studentId) {
		return this.find(Student.class, studentId);
	}

}
