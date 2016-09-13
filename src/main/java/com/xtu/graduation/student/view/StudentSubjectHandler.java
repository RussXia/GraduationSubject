package com.xtu.graduation.student.view;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xtu.graduation.common.util.PageUtil;
import com.xtu.graduation.student.service.IStudentService;
import com.xtu.graduation.subject.entity.GraduationSubject;

@SessionAttributes(value={"subjectList"})
@RequestMapping("/studentSubject")
@Controller
public class StudentSubjectHandler {
	
	@Autowired
	private IStudentService studentService;
	
//	@Autowired
//	private IGraduationSubjectService graduationSubjectService;
	
	/**
	 * 删除选题操作
	 * @param graduationSubjectId
	 * @param studentId
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteSubject",method=RequestMethod.POST)
	public String deleteSubject(@RequestParam("graduationSubjectId")Long graduationSubjectId,
			@RequestParam(value="studentId")Long studentId,
			ModelMap modelMap){
		//删除选课!
		String message = this.studentService.deleteSubjectDeal(graduationSubjectId, studentId);
		return message;
	}
	/**
	 * 选题操作
	 * @param graduationSubjectId
	 * @param studentId
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/chooseSubject",method=RequestMethod.POST)
	public String chooseSubjct(@RequestParam("graduationSubjectId")Long graduationSubjectId,
			@RequestParam(value="studentId")Long studentId,
			ModelMap modelMap){
		//选课!
		String message = studentService.chooseGraduationSubject(graduationSubjectId, studentId);
		return message;
	}
	
	@RequestMapping(value="/searchSubjct",method=RequestMethod.POST)
	public String searchSubjct(@RequestParam("subjectNameSerach")String subjectName,
			@RequestParam(value="teacherNameSerach")String teacherName,
			@RequestParam(value="subjectOrientationSearch")String subjectOrientation,
			@RequestParam(value="levelSearch")String level,
			@RequestParam(value="subjectTypeSearch")String subjectType,
			@RequestParam(value="studentDepartmentId")Long  departmentId,
			@RequestParam(value="studentStudentId")Long  studentId,
			ModelMap modelMap){
		
		System.out.println(subjectName+"==="+teacherName+"==="+subjectOrientation+"==="+level+"==="+subjectType+"==="+departmentId);
		//搜索该学生对应院系下的所有选题，剔除掉正在报名中，且教师还未处理的选题
		List<GraduationSubject> subjectList =  this.studentService.searchSubjct(subjectName, teacherName, subjectOrientation, level, subjectType, departmentId, studentId);
		//分页设置
		int currentPage = 1;
		int countPage =subjectList.size()%PageUtil.PageSize == 0?(subjectList.size()/PageUtil.PageSize):(subjectList.size()/PageUtil.PageSize+1);
		int firstResult  = (currentPage-1) * PageUtil.PageSize;
		List<GraduationSubject> subjects = new ArrayList<GraduationSubject>(PageUtil.PageSize);
		for(int index = 0 ; index < PageUtil.PageSize ; index++){
			if(subjectList.size()<(index+firstResult+1)){
				break;
			}else{
				subjects.add(subjectList.get(index+firstResult));
			}
		}
		modelMap.put("subjects", subjects);
		modelMap.put("currentPage", 1);
		modelMap.put("countPage", countPage);
		//传入到session中
		modelMap.put("subjectList", subjectList);
		return "student/"+"findSubject";
	}

}
