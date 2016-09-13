package com.xtu.graduation.teacher.dao;

import java.util.List;

import com.xtu.graduation.common.dao.IDaoSupport;
import com.xtu.graduation.teacher.entity.Teacher;

/**
 * @author Xia
 * @since ITeacherDao.java 2016年3月29日 
 */
public interface ITeacherDao extends IDaoSupport {
	
	public Teacher loginConfirm(String userName, String password);
	
	/**
	 * 通过工号sno删除教师信息
	 * @param sno
	 */
	public void deleteTeacherBySno(String sno);
	
	/**
	 * 通过id查找教师信息
	 * @param id
	 * @return
	 */
	public Teacher findTeacherById(Long id);
	
	/**
	 * 通过学号查找教师
	 * @param sno
	 * @return
	 */
	public Teacher findTeacherBySno(String sno);
	
	/**
	 * 通过姓名查找教师
	 * @param name
	 * @return
	 */
	public List<Teacher> findTeacherByName(String name);
	
	/**
	 * 通过所属院系名称查找教师
	 * @param name
	 * @return
	 */
	public List<Teacher> findTeacherByDepartmentName(String departmentName);
}
