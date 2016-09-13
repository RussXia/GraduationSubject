package com.xtu.graduation.teacher.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.xtu.graduation.AbstractSpringTest;
import com.xtu.graduation.common.util.EDSUtil;
import com.xtu.graduation.subject.entity.SubjectIdealVO;
import com.xtu.graduation.teacher.entity.Teacher;
import com.xtu.graduation.teacher.service.ITeacherService;

public class TeacherDaoTest extends AbstractSpringTest {
	
	@Resource
	private ITeacherDao teacherDao;
	
	@Resource
	private ITeacherService teacherService;
	
	@Test
	public void testSave(){
		Teacher teacher = new Teacher();
		teacher.setTeacherSno("12551415");
		teacher.setCellPhone("13851293468");
		teacher.setDepartmentId(2L);
		teacher.setEmail("1217201052@qq.com");
		teacher.setIntroduction("化工院教授");
		teacher.setPassword("123");
		teacher.setTeacherName("孙三");
		teacherDao.save(teacher);
	}
	
	@Test
	public void loginConfirm(){
		String userName = "12551435";
		String password = EDSUtil.encrypt("123456");
		Teacher t = teacherDao.loginConfirm(userName, password);
		System.out.println("==================="+1+"====================");
		System.out.println(t);
		System.out.println("==================="+1+"====================");
	}
	
	@Test
	public void testDeleteSubject(){
		String str = this.teacherService.deleteGraduationSubjectById(10L);
		System.out.println(str);
	}
	
	@Test
	public void teatGetAllSubjectIdealVO(){
		List<SubjectIdealVO> list = this.teacherService.getAllSubjectIdealVO(1L);
		System.out.println(list);
		System.out.println(list.size());
	}
	
	@Test
	public void teatRefuseIdeal(){
		String result = this.teacherService.refuseIdeal(9L);
		System.out.println(result);
	}
	
	@Test
	public void teatConfirmIdeal(){
		String result = this.teacherService.confirmIdeal(9L);
		System.out.println(result);
	}
}
