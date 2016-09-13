package com.xtu.graduation.common.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xtu.graduation.admin.entity.Admin;
import com.xtu.graduation.common.service.ICommonService;
import com.xtu.graduation.student.entity.Student;
import com.xtu.graduation.teacher.entity.Teacher;

@SessionAttributes(value={"user","userType"})
@Controller
public class LoginHandler {
	 /** logger */
    @Autowired
    private ICommonService commonService;
    
    @RequestMapping(method = RequestMethod.POST,value="/login")
    public String login(@RequestParam(value="userType",required=false)Integer userType,
    		@RequestParam(value="username",required=false)String userName, 
    		@RequestParam(value="password",required=false)String password, ModelMap modelMap) {
    	if(userName!=null && password!=null && userType!=null){
        	//根据账号、密码、用户类型 获取用户，并判断用户是否为空(既不存在) 
	       	 Object obj = commonService.loginConfirm(userName, password, userType);
	       	 if(obj == null){
	       			modelMap.put("message", "error");
	       		 return "common/login";
	       	 }
	    	 //根据用户类型，存放相应的对象到请求域中
	     	if(userType == 1){
	     		modelMap.put("user", (Student)obj);
	     		modelMap.put("userType","学生");
	     		return "student/index";
	     	} else if(userType == 2){
	     		modelMap.put("user", (Teacher)obj);
	     		modelMap.put("userType","教师");
	     		return "teacher/index";
	     	} else if(userType == 3){
	     		modelMap.put("user", (Admin)obj);
	     		modelMap.put("userType","系统管理员");
	     		return "admin/index";
	     	}
    	}
       return "common/login";
    }
    
    
    @RequestMapping(method = RequestMethod.GET,value="/login")
    public String login2(@RequestParam(value="userType",required=false)Integer userType,
    		@RequestParam(value="username",required=false)String userName, 
    		@RequestParam(value="password",required=false)String password, ModelMap modelMap) {
    	if(userName!=null && password!=null && userType!=null){
        	//根据账号、密码、用户类型 获取用户，并判断用户是否为空(既不存在) 
	       	 Object obj = commonService.loginConfirm(userName, password, userType);
	       	 if(obj == null){
	       			modelMap.put("message", "error");
	       		 return "common/login";
	       	 }
	    	 //根据用户类型，存放相应的对象到请求域中
	     	if(userType == 1){
	     		modelMap.put("user", (Student)obj);
	     		modelMap.put("userType","学生");
	     		return "student/index";
	     	} else if(userType == 2){
	     		modelMap.put("user", (Teacher)obj);
	     		modelMap.put("userType","教师");
	     		return "teacher/index";
	     	} else if(userType == 3){
	     		modelMap.put("user", (Admin)obj);
	     		modelMap.put("userType","系统管理员");
	     		return "admin/index";
	     	}
    	}
       return "common/login";
    }
    
}
