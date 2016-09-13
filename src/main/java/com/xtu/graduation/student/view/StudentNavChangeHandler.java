package com.xtu.graduation.student.view;


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
import com.xtu.graduation.student.entity.Student;
import com.xtu.graduation.student.service.IStudentService;
import com.xtu.graduation.subject.entity.GraduationSubject;
import com.xtu.graduation.subject.entity.SubjectResult;

@RequestMapping("/student")
@Controller
public class StudentNavChangeHandler {
	
	@Autowired
	private IStudentService studentService;
	
	private static final String STUDENT = "student/";
	
	@RequestMapping(value="/personalData",method=RequestMethod.GET)
	public String personalData(){
		return STUDENT+"personalData";
	}
	
	@RequestMapping(value="/changePassword",method=RequestMethod.GET)
	public String changePassword(){
		return STUDENT+"changePassword";
	}
	
	@RequestMapping(value="/changeEmail",method=RequestMethod.GET)
	public String changeEmail(){
		return STUDENT+"changeEmail";
	}
	/**
	 * 个人选题管理界面
	 * @param httpSession
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/manageSubject",method=RequestMethod.GET)
	public String deleteSubject(HttpSession httpSession,ModelMap modelMap){
		Student stu = (Student) httpSession.getAttribute("user");
		Long studentId = stu.getStudentId();
		//若学生已被确选，则直接返回
		if(stu.getIsConfirm()){
			modelMap.put("message", "你已完成毕设选课，请到'我的毕业设计选题信息'模块中查询选题信息");
			return STUDENT+"subjectManage";
		}
		
		List<GraduationSubject> mySubjects = studentService.findGraduationSubjectByStudentId(studentId);
		
		if(mySubjects != null && mySubjects.size()>0 ){
			modelMap.put("mySubjects", mySubjects);
		}
		
		return STUDENT+"subjectManage";
	}
	/**
	 * 获取所有选题
	 * @param httpSession
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/findSubject",method=RequestMethod.GET)
	public String findSubject(@RequestParam(value="operate",required=false,defaultValue="0")Integer operate,
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
		
		Student stu = (Student) httpSession.getAttribute("user");
		//获取该院系下所有 没有确选的课题
		Long departmentId = stu.getDepartmentId();
		List<GraduationSubject> subjectList = studentService.findGraduationSubjectByDepartmentIdNotConfirm(departmentId);
		//获取该学生已经选择的课程
		List<GraduationSubject> hasChoosen = studentService.findGraduationSubjectByStudentId(stu.getStudentId());
		//将已经选择的课程从所有课程中去除
		for(GraduationSubject graduationSubject : hasChoosen){
			if(subjectList.contains(graduationSubject)){
				subjectList.remove(graduationSubject);
			}
		}
		int countPage =subjectList.size()%PageUtil.PageSize == 0?(subjectList.size()/PageUtil.PageSize):(subjectList.size()/PageUtil.PageSize+1);
		List<GraduationSubject> subjects = new ArrayList<GraduationSubject>();
		if(subjectList != null && subjectList.size() > 0 ){
			for(int index = 0 ; index < PageUtil.PageSize ; index++){
				if(subjectList.size() < (index+firstResult+1) ){
					break;
				}
				subjects.add(subjectList.get(index));
			}
			modelMap.put("subjects", subjects);
		}
		modelMap.put("currentPage", currentPage);
		modelMap.put("countPage", countPage);
		return STUDENT+"findSubject";
	}
	/**
	 * !!!已经作废，合并到findSubject()方法中
	 * 选择课题的上一页，下一页
	 * ！！！！所有操作都是基于session的，并未操作数据库！！！
	 * 从session中获取之前存入的subjectList
	 * @param studentId
	 * @param operate
	 * @param currentPage
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/findSubject",method=RequestMethod.POST)
	public String findSubjectByPage(@RequestParam("studentId")Long studentId,@RequestParam("operate")Integer operate,
			@RequestParam(value="currentPage",required=false,defaultValue="1")Integer currentPage,ModelMap modelMap,HttpSession session){
		//从session中获取subjectList
		@SuppressWarnings("unchecked")
		List<GraduationSubject> subjectList = (List<GraduationSubject>) session.getAttribute("subjectList");
		//分页
		if(operate == 1){
			currentPage ++;
		}else if(operate == -1){
			currentPage --;
		}else{
			currentPage = 1;
		}
		int firstResult  = (currentPage-1) * PageUtil.PageSize;
		int countPage =subjectList.size()%PageUtil.PageSize == 0?(subjectList.size()/PageUtil.PageSize):(subjectList.size()/PageUtil.PageSize+1);
		
		List<GraduationSubject> subjects = new ArrayList<GraduationSubject>(PageUtil.PageSize);
		for(int index = 0 ; index < PageUtil.PageSize ; index++){
			if(subjectList.size()<(index+firstResult+1)){
				break;
			}else{
				subjects.add(subjectList.get(index+firstResult));
			}
		}
		modelMap.put("subjects", subjects);
		modelMap.put("currentPage", currentPage);
		modelMap.put("countPage", countPage);
		return STUDENT+"findSubject";
	}
	
	@RequestMapping(value="/mySubjectResult",method=RequestMethod.GET)
	public String mySubjectResult(HttpSession httpSession,ModelMap modelMap){
		Student stu = (Student) httpSession.getAttribute("user");
		SubjectResult subjectResult = this.studentService.findSubjectResultByStudentId(stu.getStudentId());
		if(subjectResult != null && subjectResult.getSubjectResultId() != null){
			modelMap.put("mySubjectResult", subjectResult);
		}
		return STUDENT+"mySubjectResult";
	}
}
