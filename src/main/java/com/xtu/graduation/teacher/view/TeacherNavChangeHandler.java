package com.xtu.graduation.teacher.view;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xtu.graduation.common.util.PageUtil;
import com.xtu.graduation.subject.entity.GraduationSubject;
import com.xtu.graduation.subject.entity.SubjectIdealVO;
import com.xtu.graduation.subject.entity.SubjectResult;
import com.xtu.graduation.teacher.entity.Teacher;
import com.xtu.graduation.teacher.service.ITeacherService;

@RequestMapping("/teacher")
@Controller
public class TeacherNavChangeHandler {
	
	private static final String TEACHER = "teacher/";
	
	@Autowired
	private ITeacherService teacherService;
	
	@RequestMapping(value="/personalData",method=RequestMethod.GET)
	public String personalData(){
		return TEACHER+"personalData";
	}
	
	@RequestMapping(value="/changePassword",method=RequestMethod.GET)
	public String changePassword(){
		return TEACHER+"changePassword";
	}
	
	@RequestMapping(value="/changeEmail",method=RequestMethod.GET)
	public String changeEmail(){
		return TEACHER+"changeEmail";
	}
	
	@RequestMapping(value="/addGraduationSubject",method=RequestMethod.GET)
	public String addGraduationSubject(){
		return TEACHER+"addGraduationSubject";
	}
	
	@RequestMapping(value="/manageSubject",method=RequestMethod.GET)
	public String manageSubject(HttpSession httpSession,ModelMap modelMap){
		Teacher teacher = (Teacher) httpSession.getAttribute("user");
		List<GraduationSubject> mySubjects = this.teacherService.findSubjectByTeacherId(teacher.getTeacherId());
		modelMap.put("mySubjects",mySubjects);
		return TEACHER+"subjectManage";
	}
	
	@RequestMapping(value="/confirmIdeal",method=RequestMethod.GET)
	public String confirmIdeal(@RequestParam(value="operate",required=false,defaultValue="0")Integer operate,
			@RequestParam(value="currentPage",required=false,defaultValue="1")Integer currentPage,
			HttpSession httpSession,ModelMap modelMap){
		//页面分页
		if(operate == 1){
			currentPage ++;
		}else if(operate == -1){
			currentPage --;
		}else{
			currentPage = 1;
		}
		int firstResult  = (currentPage-1) * PageUtil.PageSize;
		
		Teacher teacher = (Teacher) httpSession.getAttribute("user");
		List<SubjectIdealVO> subjectIdealVOs = this.teacherService.getAllSubjectIdealVO(teacher.getTeacherId());
		
		if(subjectIdealVOs != null && subjectIdealVOs.size() > 0){
			//list : 给前端返回的数据
			List<SubjectIdealVO> list = new ArrayList<SubjectIdealVO>();
			//选取PageUtil.PageSize个元素塞进list中(不足的话，能选多少个选多少个)
			for(int index = 0 ; index < PageUtil.PageSize ; index++){
				if(subjectIdealVOs.size()<(index+firstResult+1)){
					break;
				}
				list.add(subjectIdealVOs.get(index+firstResult));
			}
			modelMap.put("subjectIdealVOs", list);
		}
		
		int countPage =subjectIdealVOs.size()%PageUtil.PageSize == 0?(subjectIdealVOs.size()/PageUtil.PageSize):(subjectIdealVOs.size()/PageUtil.PageSize+1);
		modelMap.put("currentPage", currentPage);
		modelMap.put("countPage", countPage);
		return TEACHER+"confirmIdeal";
	}
	
	@RequestMapping(value="/myStudent",method=RequestMethod.GET)
	public String myStudent(HttpSession httpSession,ModelMap modelMap){
		Teacher teacher = (Teacher) httpSession.getAttribute("user");
		List<SubjectResult> subjectResults = this.teacherService.findAllSubjectResultByTeacherId(teacher.getTeacherId());
		modelMap.put("mySubjectResults",subjectResults);
		return TEACHER+"myStudent";
	}
	
	@RequestMapping(value="/excelDownload",method=RequestMethod.GET)
	public String excelDownload(){
		return TEACHER+"excelDownload";
	}
}
