package com.xtu.graduation.teacher.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtu.graduation.subject.entity.GraduationSubject;
import com.xtu.graduation.teacher.service.ITeacherService;

@RequestMapping("/teacherSubject")
@Controller
public class TeacherSubjectHandler {

	@Autowired
	private ITeacherService teacherService;
	
	
	@ResponseBody
	@RequestMapping(value="/addGraduationSubject",method=RequestMethod.POST)
	public String addGraduationSubject(GraduationSubject subject){
		this.teacherService.addGraduationSubject(subject);
		return "发布课题成功!";
	}
	
	@ResponseBody
	@RequestMapping(value="/updateSubject",method=RequestMethod.POST)
	public String updateSubject(@RequestParam("graduationSubjectId")Long graduationSubjectId,
			@RequestParam("subjectName")String subjectName, 
			@RequestParam("level")String level,
			@RequestParam("subjectOrientation")String subjectOrientation,
			@RequestParam("subjectType")String subjectType){
		
		String result = null;
		try{
			result = this.teacherService.updateGraduationSubject(graduationSubjectId,subjectName,level,subjectOrientation,subjectType);
		} catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		return result;
	}
	
	@RequestMapping(value="/deleteSubject/{subjectId}",method=RequestMethod.POST)
	public @ResponseBody String deleteSubject(@PathVariable Long subjectId){
		String result = null;
		try{
			result = this.teacherService.deleteGraduationSubjectById(subjectId);
		}catch (Exception e){
			e.printStackTrace();
			return "fail";
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/confirmIdeal",method=RequestMethod.POST)
	public String confirmIdeal(@RequestParam(value="subjectIdealId") Long subjectIdealId){
		String result = null;
		try{
			result = this.teacherService.confirmIdeal(subjectIdealId);
		}catch (Exception e){
			e.printStackTrace();
			return "fail";
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/refuseIdeal",method=RequestMethod.POST)
	public String refuseIdeal(@RequestParam(value="subjectIdealId") Long subjectIdealId){
		String result = null;
		try{
			result = this.teacherService.refuseIdeal(subjectIdealId);
		}catch (Exception e){
			e.printStackTrace();
			return "fail";
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteMyStudent",method=RequestMethod.POST)
	public String deleteMyStudent(@RequestParam(value="subjectResultId") Long subjectResultId){
		String result = null;
		try{
			result = this.teacherService.deleteMyStudent(subjectResultId);
		}catch (Exception e){
			e.printStackTrace();
			return "fail"+e.getMessage();
		}
		return result;
	}
	
}
