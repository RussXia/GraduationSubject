package com.xtu.graduation.student.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.xtu.graduation.AbstractSpringTest;
import com.xtu.graduation.common.util.EDSUtil;
import com.xtu.graduation.student.entity.Student;
import com.xtu.graduation.subject.entity.GraduationSubject;
import com.xtu.graduation.subject.service.IGraduationSubjectService;

public class StudentServiceTest extends AbstractSpringTest {
	
	@Resource
	private IStudentService studentService;
	
	@Resource
	private IGraduationSubjectService graduationSubjectService;
	
	@Test
	public void testAddStudent() throws ParseException{
		Student student = new Student();
		student.setStudentSno("2012551434");
		student.setPassword(EDSUtil.encrypt("123456"));
		student.setStudentName("刘欢");
		student.setSex("男");
		student.setDepartmentId(1L);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("1993-12-21");
		student.setBirth(date);
		student.setCellPhone("18373238819");
		student.setEmail("1217201096@qq.com");
		studentService.addStudent(student);
		student.setCellPhone("17333332222");
		studentService.updateStudent(student);
	}
	
	@Test
	public void testUpdateStudent() throws ParseException{
		Student student = new Student();
		student.setStudentId(1L);
		student.setStudentSno("2012551435");
		student.setPassword("1");
		student.setStudentName("夏正月");
		student.setSex("男");
		student.setDepartmentId(1L);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("1994-07-12");
		student.setBirth(date);
		student.setCellPhone("17333331111");
		student.setEmail("1217201052@qq.com");
		studentService.updateStudent(student);
	}
	
	
	@Test
	public void testDeleteStudent(){
		Student student = new Student();
		student.setStudentId(6L);
		studentService.deleteStudent(student);
	}
	
	@Test
	public void testDeleteStudentBySno(){
		studentService.deleteStudentBySno("2012551435");
	}
	
	@Test
	public void testFindSubject(){
//		GraduationSubject sub = graduationSubjectService.findGraduationSubjectBySubjectId(34L);
//		sub.setIsChoosen(true);
//		graduationSubjectService.updateGraduationSubject(sub);
		List<GraduationSubject> list = studentService.findGraduationSubjectByDepartmentIdNotConfirm(1L);
		System.out.println(list.size());
	}
	
	@Test
	public void tesFindStudentBySno(){
		Student stu = studentService.findStudentBySno("2012551435");
		System.out.println(stu);
	}
	
	@Test
	public void testDeleteStudentById(){
		Long id = 6L;
		studentService.deleteStudentById(id);
	}
	
	@Test
	public void test(){
		Long studentId = 1L;
		//获取该院系下所有的课题
		Long departmentId = studentService.findStudentById(studentId).getDepartmentId();
		List<GraduationSubject> subjectList = studentService.findGraduationSubjectByDepartmentId(departmentId);
		//获取该学生已经选择的课程
		List<GraduationSubject> hasChoosen = studentService.findGraduationSubjectByStudentId(studentId);
		//将已经选择的课程从所有课程中去除
		for(GraduationSubject graduationSubject : hasChoosen){
			if(subjectList.contains(graduationSubject)){
				subjectList.remove(graduationSubject);
			}
		}
		System.out.println(subjectList);
	}
}
