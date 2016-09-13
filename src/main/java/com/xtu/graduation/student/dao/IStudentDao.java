package com.xtu.graduation.student.dao;

import java.util.List;

import com.xtu.graduation.common.dao.IDaoSupport;
import com.xtu.graduation.student.entity.Student;

public interface IStudentDao extends IDaoSupport{
	/**
	 * 根据学生id查询学生
	 * @param studentId
	 * @return
	 */
	public Student findStudentById(Long studentId);
	
	/**
	 * 查询当前的志愿数
	 * @param id
	 * @return
	 */
	public Integer getPresentIdealNum(String sno);
	/**
	 * 查询是否已确选
	 * @param id
	 * @return
	 */
	public Boolean isConfirm(String sno);
	
	/**
	 * 通过学号查找学生
	 * @param sno
	 * @return
	 */
	public Student findStudentBySno(String sno);
	
	/**
	 * 通过姓名查询学生
	 * @param name
	 * @return
	 */
	public List<Student> findStudentsByName(String name);
	/**
	 * 学生登陆
	 * @param userName
	 * @param password
	 * @return
	 */
	public Student loginConfirm(String userName, String password);
	
	/**
	 * 通过所属院系名称查找学生
	 * @param name
	 * @return
	 */
	public List<Student> findStudentByDepartmentName(String departmentName);
	
	/**
	 * 通过学号sno删除学生信息
	 * @param sno
	 */
	public void deleteStudentBySno(String sno);
	
}
