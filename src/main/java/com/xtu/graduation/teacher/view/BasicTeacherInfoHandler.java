package com.xtu.graduation.teacher.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xtu.graduation.department.entity.Department;
import com.xtu.graduation.department.service.IDepartmentService;
import com.xtu.graduation.teacher.entity.Teacher;
import com.xtu.graduation.teacher.service.ITeacherService;

@RequestMapping("/teacherInfo")
@SessionAttributes(value={"user"})
@Controller
public class BasicTeacherInfoHandler {
	
	@Autowired
	private ITeacherService teacherService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@ResponseBody
	@RequestMapping(value="/updateTeacherInfo",method=RequestMethod.POST)
	public String updateTeacherInfo(@ModelAttribute("user")Teacher teacher){
		teacherService.updateTeacher(teacher);
		Department department = departmentService.findDepartmentById(teacher.getDepartmentId());
		teacher.setDepartment(department);
		return "修改个人信息成功!";
	}
	
	@ResponseBody
	@RequestMapping(value="/changePassword",method=RequestMethod.POST)
	public String changePassword(@RequestParam("teacherId")Long teacherId,@RequestParam("oldPassword")String oldPassword,
			@RequestParam("newPassword")String newPassword){
		Teacher teacher =  teacherService.findTeacherById(teacherId);
		if(teacher.getPassword().equals(oldPassword)){
			teacher.setPassword(newPassword);
			teacherService.updateTeacher(teacher);
			return "修改密码成功";
		}
		return "修改密码失败，原密码输入错误";
	}
	
	@ResponseBody
	@RequestMapping(value="/changeEmail",method=RequestMethod.POST)
	public String changeEmail(@RequestParam("teacherId")Long teacherId,@RequestParam("newEmail")String newEmail,
			ModelMap modelMap){
		Teacher teacher =  teacherService.findTeacherById(teacherId);
		teacher.setDepartment(departmentService.findDepartmentById(teacher.getDepartmentId()));
		teacher.setEmail(newEmail);
		teacherService.updateTeacher(teacher);
		modelMap.put("user",teacher);
		return "修改邮箱成功!";
	}
	
	@ModelAttribute
	public void getTeacherById(@RequestParam(value="teacherId",required=false) Long teacherId, 
			Map<String, Object> map){
		if(teacherId != null){
			Teacher Teacher = teacherService.findTeacherById(teacherId);
			map.put("user", Teacher);
		}
	}
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));  
	}
}
