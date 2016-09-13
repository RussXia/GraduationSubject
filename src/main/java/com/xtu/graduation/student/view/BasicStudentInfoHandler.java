package com.xtu.graduation.student.view;

import java.text.ParseException;
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
import com.xtu.graduation.student.entity.Student;
import com.xtu.graduation.student.service.IStudentService;

@RequestMapping("/studentInfo")
@SessionAttributes(value={"user"})
@Controller
public class BasicStudentInfoHandler {
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@ResponseBody
	@RequestMapping(value="/updateStudentInfo",method=RequestMethod.POST)
	public String updateStudentInfo(@ModelAttribute("user")Student student){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date birth = null;
		try {
			birth = formatter.parse(formatter.format(student.getBirth()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		student.setBirth(birth);
		studentService.updateStudent(student);
		Department department = departmentService.findDepartmentById(student.getDepartmentId());
		student.setDepartment(department);
		return "修改个人信息成功!";
	}
	
	@ResponseBody
	@RequestMapping(value="/changePassword",method=RequestMethod.POST)
	public String changePassword(@RequestParam("studentId")Long studentId,@RequestParam("oldPassword")String oldPassword,
			@RequestParam("newPassword")String newPassword){
		Student student =  studentService.findStudentById(studentId);
		if(student.getPassword().equals(oldPassword)){
			student.setPassword(newPassword);
			studentService.updateStudent(student);
			return "修改密码成功";
		}
		return "修改密码失败，原密码输入错误";
	}
	
	@ResponseBody
	@RequestMapping(value="/changeEmail",method=RequestMethod.POST)
	public String changeEmail(@RequestParam("studentId")Long studentId,@RequestParam("newEmail")String newEmail,
			ModelMap modelMap){
		Student student =  studentService.findStudentById(studentId);
		student.setDepartment(departmentService.findDepartmentById(student.getDepartmentId()));
		student.setEmail(newEmail);
		studentService.updateStudent(student);
		modelMap.put("user",student);
		return "修改邮箱成功!";
	}
	
	@ModelAttribute
	public void getStudentById(@RequestParam(value="studentId",required=false) Long studentId, 
			Map<String, Object> map){
		if(studentId != null){
			Student student = studentService.findStudentById(studentId);
			map.put("user", student);
		}
	}
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));  
	}
}
