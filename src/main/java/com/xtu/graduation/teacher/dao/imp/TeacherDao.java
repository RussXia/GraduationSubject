package com.xtu.graduation.teacher.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.xtu.graduation.common.dao.jpa.JpaDaoTemplate;
import com.xtu.graduation.department.dao.IDepartmentDao;
import com.xtu.graduation.department.entity.Department;
import com.xtu.graduation.teacher.dao.ITeacherDao;
import com.xtu.graduation.teacher.entity.Teacher;

/**
 * TeacherDao 教师dao
 * @author Xia
 * @since TeacherDao.java 2016年3月29日 
 */
@Repository
public class TeacherDao extends JpaDaoTemplate implements ITeacherDao {
	
	@Resource
	private IDepartmentDao departmentDao;
	
	@Override
	public Teacher loginConfirm(String userName, String password) {
		String query = "Select Entity From Teacher Entity Where Entity.teacherSno = ? and Entity.password = ?";
		Teacher teacher  = this.find(Teacher.class, query, userName,password);
		return teacher;
	}

	@Override
	public void deleteTeacherBySno(String sno) {
		String query = "DELETE From Teacher Entity Where Entity.teacherSno = ?";
		this.execute(query, sno);
	}

	@Override
	public Teacher findTeacherById(Long id) {
		return this.find(Teacher.class, id);
	}

	@Override
	public Teacher findTeacherBySno(String sno) {
		String query = "Select Entity From Teacher Entity Where Entity.teacherSno = ?";
		Teacher teacher = this.find(Teacher.class, query, sno);
		return teacher;
	}

	@Override
	public List<Teacher> findTeacherByName(String name) {
		String query = "Select Entity From Teacher Entity Where Entity.teacherName = ?";
		return this.list(Teacher.class, query, name);
	}

	@Override
	public List<Teacher> findTeacherByDepartmentName(String departmentName) {
		Department department = departmentDao.findDepartmentByName(departmentName);
		String query = "Select Entity From Student Entity Where Entity.departmentId = ?";
		return this.list(Teacher.class, query, department.getDepartmentId());
	}

}
