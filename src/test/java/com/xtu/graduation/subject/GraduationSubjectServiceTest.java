package com.xtu.graduation.subject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xtu.graduation.AbstractSpringTest;
import com.xtu.graduation.subject.service.IGraduationSubjectService;

public class GraduationSubjectServiceTest extends AbstractSpringTest {

	@Autowired
	private IGraduationSubjectService graduationSubjectService;
	
	@Test
	public void testQuery(){
		String subjectName = "测试";
		String teacherName = "测试";
		String subjectOrientation = "测试";
		String level = "简单";
		String subjectType = "";
		System.out.println(this.graduationSubjectService.findGraduationSubjectBySearchParam
				(subjectName,teacherName,subjectOrientation,level,subjectType,1L).size());
	}
	
	
	@Test
	public void testQuery2(){
		System.out.println(this.graduationSubjectService.findGraduationSubjectByDepartmentId(1L));
	}
}
