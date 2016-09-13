package com.xtu.graduation.student.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.xtu.graduation.AbstractSpringTest;
import com.xtu.graduation.department.dao.IDepartmentDao;
import com.xtu.graduation.student.entity.Student;



public class StudentDaoTest extends AbstractSpringTest{
	
	@Resource
	private IStudentDao studentDao;
	
	@Resource
	private IDepartmentDao departmentDao;
	
	@Test
	public void testSave() throws ParseException {
		Student student = new Student();
		student.setStudentSno("2012551813");
		student.setPassword("123");
		student.setStudentName("王五");
		student.setSex("男");
		student.setDepartmentId(2L);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("1994-06-04");
		student.setBirth(date);
		student.setCellPhone("18373238813");
		student.setEmail("1217201052@qq.com");
		studentDao.save(student);
	}
	
	@Test
	public void testFind(){
		Student s = studentDao.findStudentBySno("2012551435");
		System.out.println(s);
	}
	
	@Test
	public void testGetPresentIdealNum(){
		Integer i = studentDao.getPresentIdealNum("2012551435");
		System.out.println("==================="+i+"====================");
		Boolean tt = studentDao.isConfirm("2012551435");
		System.out.println("==================="+tt+"====================");
	}
	
	
	@Test
	public void testLogin(){
		String userName = "2012551435";
		String password = "123456";
		Student stu = studentDao.loginConfirm(userName, password);
		System.out.println("==================="+1+"====================");
		System.out.println(stu);
		System.out.println("==================="+1+"====================");
	}
	
	@Test
	public void testFindList(){
		Student s = studentDao.findStudentBySno("2012551435");
//		List<Student> list = studentDao.find
		System.out.println(s);
	}
	
}
