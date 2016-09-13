package com.xtu.graduation.teacher.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.xtu.graduation.common.util.MailTemplate;
import com.xtu.graduation.common.util.PropertiesReaderHelper;
import com.xtu.graduation.department.dao.IDepartmentDao;
import com.xtu.graduation.department.entity.Department;
import com.xtu.graduation.student.dao.IStudentDao;
import com.xtu.graduation.student.entity.Student;
import com.xtu.graduation.subject.dao.IGraduationSubjectDao;
import com.xtu.graduation.subject.dao.ISubjectIdealDao;
import com.xtu.graduation.subject.dao.ISubjectResultDao;
import com.xtu.graduation.subject.entity.GraduationSubject;
import com.xtu.graduation.subject.entity.SubjectIdeal;
import com.xtu.graduation.subject.entity.SubjectIdealVO;
import com.xtu.graduation.subject.entity.SubjectResult;
import com.xtu.graduation.teacher.dao.ITeacherDao;
import com.xtu.graduation.teacher.entity.Teacher;
import com.xtu.graduation.teacher.service.ITeacherService;
@Service
public class TeacherService implements ITeacherService{
	
	@Resource
	private ITeacherDao 			teacherDao;
	
	@Resource
	private IGraduationSubjectDao 	graduationSubjectDao;
	
	@Resource
	private ISubjectIdealDao 		subjectIdealDao;
	
	@Resource
	private IStudentDao 			studentDao;
	
	@Resource
	private MailTemplate			mailTemplate;
	
	@Resource
	private ISubjectResultDao		subjectResultDao;
	
	@Resource
	private IDepartmentDao			departmentDao;
	
	@Override
	public void addTeacher(Teacher teacher) {
		this.teacherDao.save(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		this.teacherDao.update(teacher);
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		this.teacherDao.delete(teacher);
	}

	@Override
	public void deleteTeacherById(Long id) {
		this.teacherDao.delete(Teacher.class, id);
	}

	@Override
	public void deleteTeacherBySno(String sno) {
		this.teacherDao.deleteTeacherBySno(sno);
	}

	@Override
	public Teacher findTeacherById(Long id) {
		return this.teacherDao.findTeacherById(id);
	}

	@Override
	public Teacher findTeacherBySno(String sno) {
		return this.teacherDao.findTeacherBySno(sno);
	}

	@Override
	public List<Teacher> findTeacherByName(String name) {
		return this.teacherDao.findTeacherByName(name);
	}

	@Override
	public List<Teacher> findTeacherByDepartmentName(String departmentName) {
		return this.teacherDao.findTeacherByDepartmentName(departmentName);
	}

	@Override
	public void addGraduationSubject(GraduationSubject subject) {
		this.graduationSubjectDao.save(subject);
	}

	@Override
	public List<GraduationSubject> findSubjectByTeacherId(Long teacherId) {
		return this.graduationSubjectDao.findGraduationSubjectByTeacherId(teacherId);
	}

	@Override
	public String deleteGraduationSubjectById(Long graduationSubjectId) {
		//获取选题
		GraduationSubject graduationSubject = this.graduationSubjectDao.findGraduationSubjectById(graduationSubjectId);
		//该选题的指导教师
		Teacher teacher = this.teacherDao.findTeacherById(graduationSubject.getTeacherId());
		//邮箱集合
		List<String> emailAddress = new ArrayList<String>();
		//若选题已经被确选，那么只需要改动subjectResult表中的内容
		if(graduationSubject.getIsChoosen()){
			List<SubjectResult> subjectResults = this.subjectResultDao.findAllSubjectResultByGraduationSubjectId(graduationSubjectId);
			if(subjectResults != null && subjectResults.size() >0 ){
				for(SubjectResult subjectResult : subjectResults){
					//删除选题结果的表记录
					this.subjectResultDao.delete(SubjectResult.class, subjectResult.getSubjectResultId());
					//将学生重新设置为为确选状态
					Student stu = this.studentDao.findStudentById(subjectResult.getStudentId());
					stu.setIsConfirm(false);
					this.studentDao.update(stu);
					emailAddress.add(stu.getEmail());
				}
			}
		} 
		//若选题未被确选，则需将其分为确选学生，已处理学生，未处理学生三类进行分别处理
		else {
			//对于已确选学生，操作subjectResult表，操作同上
			List<SubjectResult> subjectResults = this.subjectResultDao.findAllSubjectResultByGraduationSubjectId(graduationSubjectId);
			if(subjectResults != null && subjectResults.size() >0 ){
				for(SubjectResult subjectResult : subjectResults){
					//删除选题结果记录
					this.subjectResultDao.delete(SubjectResult.class, subjectResult.getSubjectResultId());
					//更改学生信息
					Student stu = this.studentDao.findStudentById(subjectResult.getStudentId());
					stu.setIsConfirm(false);
					this.studentDao.update(stu);
				}
			}
			//查询该选题的所有 未被处理的选题志愿
			List<SubjectIdeal> subjectIdeals = this.subjectIdealDao.findAllSubjectIdealNotConfirmByGraduationSubjectId(graduationSubjectId); 
			//对于subjectIdeals表
			if(subjectIdeals != null && subjectIdeals.size()>0){
				for(SubjectIdeal subject : subjectIdeals){
					Student stu = this.studentDao.findStudentById(subject.getStudentId());
					//当前学生的志愿数-1
					stu.setPresentIdealNum(stu.getPresentIdealNum()-1);
					//更新学生信息
					this.studentDao.update(stu);
					//删除选题志愿相关记录
					this.subjectIdealDao.delete(SubjectIdeal.class, subject.getSubjectIdealId());
					//获取学生的邮箱
					emailAddress.add(stu.getEmail());
				}
			}
		}
		
		//删除选题
		this.graduationSubjectDao.deleteGraduationSubjectById(graduationSubjectId);
		
		//发送邮件!
		String [] toAddress=emailAddress.toArray(new String[emailAddress.size()]);
		String title = "湘潭大学毕业设计选题管理系统";
		String url = PropertiesReaderHelper.getEmailProperties().getProperty("XTUGraduation_URL");
		String content = "您所选择的毕设选题:"+graduationSubject.getSubjectName()+",指导教师 "+teacher.getTeacherName()+
				" 已删除课程,\n请尽快登陆湘潭大学毕业设计选题管理系统重新选题。url链接为:"+url;
		mailTemplate.send(toAddress, null, null, title, content, false);
		return "success";
	}

	@Override
	public String updateGraduationSubject(Long graduationSubjectId, String subjectName, String level,
			String subjectOrientation, String subjectType) {
		//获取选题
		GraduationSubject graduationSubject = this.graduationSubjectDao.findGraduationSubjectById(graduationSubjectId);
		//更新课题信息
		graduationSubject.setSubjectName(subjectName);
		graduationSubject.setLevel(level);
		graduationSubject.setSubjectOrientation(subjectOrientation);
		graduationSubject.setSubjectType(subjectType);
		this.graduationSubjectDao.update(graduationSubject);
		//该选题的所有 未被处理的选题志愿
		List<SubjectIdeal> subjectIdeals = this.subjectIdealDao.findAllSubjectIdealNotConfirmByGraduationSubjectId(graduationSubjectId); 
		List<String> emailAddress = new ArrayList<String>();
		//如果该课题已经有人选择
		if(subjectIdeals != null && subjectIdeals.size()>0){
			for(SubjectIdeal subject : subjectIdeals){
				Student stu = this.studentDao.findStudentById(subject.getStudentId());
				//获取学生的邮箱
				emailAddress.add(stu.getEmail());
			}
			
		}
		//获取该课题所有的选题结果
		List<SubjectResult> subjectResults = this.subjectResultDao.findAllSubjectResultByGraduationSubjectId(graduationSubjectId);
		if(subjectResults != null && subjectResults.size()>0){
			for(SubjectResult subjectResult :subjectResults ){
				//获取学生的邮箱
				emailAddress.add(subjectResult.getStudentEmail());
			}
		}
		//发送邮件!
		String [] toAddress=emailAddress.toArray(new String[emailAddress.size()]);
		String title = "湘潭大学毕业设计选题管理系统";
		String url = PropertiesReaderHelper.getEmailProperties().getProperty("XTUGraduation_URL");
		String content = "您所选择的毕设选题:"+graduationSubject.getSubjectName()+",指导教师 "+graduationSubject.getTeacherName()+
				" 已修改课程,\n详情可登陆湘潭大学毕业设计选题管理系统查看。url链接为:"+url;
		mailTemplate.send(toAddress, null, null, title, content, false);
		return "success";
	}

	@Override
	public List<SubjectIdeal> getAllSubjectIdealByTeacherId(Long teacherId) {
		 List<SubjectIdeal> list =  this.subjectIdealDao.findAllSubjectIdealByTeacherId(teacherId);
		 for(SubjectIdeal subjectIdeal : list){
			 if(subjectIdeal.getIsConfirm() == true){
				 list.remove(subjectIdeal);
			 }
		 }
		 return list;
	}

	@Override
	public List<SubjectIdealVO> getAllSubjectIdealVO(Long teacherId) {
		//获得所有未处理的 学生志愿
		List<SubjectIdeal> list = this.subjectIdealDao.findSubjectIdealNotChoosenByTeacherId(teacherId);
		List<SubjectIdealVO> subjectIdealVOs = new ArrayList<SubjectIdealVO>();
		//添加属性
		if(list != null && list.size() > 0){
			for(SubjectIdeal subjectIdeal : list){
				SubjectIdealVO subjectIdealVO = new SubjectIdealVO();
				GraduationSubject subject = this.graduationSubjectDao.findGraduationSubjectById(subjectIdeal.getGraduationSubjectId());
				BeanUtils.copyProperties(subject, subjectIdealVO);
				Student stu = this.studentDao.findStudentById(subjectIdeal.getStudentId());
				BeanUtils.copyProperties(stu, subjectIdealVO);
				BeanUtils.copyProperties(subjectIdeal, subjectIdealVO);
				subjectIdealVOs.add(subjectIdealVO);
			}
		}
		return subjectIdealVOs;
	}

	@Override
	public String confirmIdeal(Long subjectIdealId) {
		SubjectIdeal subjectIdeal = this.subjectIdealDao.findSubjectIdealBySubjectIdealId(subjectIdealId);
		GraduationSubject subject = this.graduationSubjectDao.findGraduationSubjectById(subjectIdeal.getGraduationSubjectId());
		SubjectResult  result = new SubjectResult();
	
		//获得该学生的其他志愿
		List<SubjectIdeal> subjectIdeals = this.subjectIdealDao.findAllSubjectIdealByStudentId(subjectIdeal.getStudentId());
		subjectIdeals.remove(subjectIdeal);
		//删除掉这些志愿，并发送邮件通知这些志愿对应的教师
		if(subjectIdeals !=null && subjectIdeals.size()>0){
			for(SubjectIdeal subjectIdeal2 : subjectIdeals)
				try {
					this.deleteSubjectDeal(subjectIdeal2.getGraduationSubjectId(), subjectIdeal2.getStudentId(),subjectIdeal2.getSubjectIdealId());
				} catch (Exception e) {
					e.printStackTrace();
					return "fail";
				}
		}
		
		//更新学生信息并发送邮件通知
		Student student = this.studentDao.findStudentById(subjectIdeal.getStudentId());
		if(student.getPresentIdealNum() != 1 ){
			throw new RuntimeException("学生当前志愿数不为为1,无法完成同意志愿操作!");
		}
		student.setPresentIdealNum(0);
		student.setIsConfirm(true);
		this.studentDao.update(student);
		String[] toAddress = {student.getEmail()};
		String title = "湘潭大学毕业设计选题管理系统";
		String url = PropertiesReaderHelper.getEmailProperties().getProperty("XTUGraduation_URL");
		String content = "您所选择的毕设选题:"+subject.getSubjectName()+",指导教师 "+subject.getTeacherName()+
				" 已确认通过了您的选课,\n详情可登陆湘潭大学毕业设计选题管理系统查看。url链接为:"+url;
		mailTemplate.send(toAddress, null, null, title, content, false);
		//设置课题信息并更新
		subject.setPresentConfirmNum(subject.getPresentConfirmNum()+1);
		if(subject.getPresentConfirmNum() == subject.getMaxStuNum()){
			//将课题设置为 已确选
			subject.setIsChoosen(true);
			subject.setPresentStuNum(subject.getMaxStuNum());
			//找到所有未处理的学生志愿，并删除这些学生志愿，并更新学生信息,并发送邮件通知
			List<SubjectIdeal> list = this.subjectIdealDao.findAllSubjectIdealByTeacherId(subjectIdeal.getTeacherId());
			if(list != null && list.size()>0){
				List<String> emailAddress = new ArrayList<String>();
				for(SubjectIdeal ideal :list){
					//若为该学生的选题志愿，则跳过
					if(ideal.getStudentId() == student.getStudentId()){
						continue ;
					}
					//更新学生信息
					Student stu = this.studentDao.findStudentById(ideal.getStudentId());
					stu.setPresentIdealNum(stu.getPresentIdealNum()-1);
					this.studentDao.update(stu);
					this.subjectIdealDao.delete(SubjectIdeal.class,ideal.getSubjectIdealId());
					emailAddress.add(stu.getEmail());
				}
				if(emailAddress != null && emailAddress.size()>0){
					//发送邮件!
					String [] address=emailAddress.toArray(new String[emailAddress.size()]);
					String title2 = "湘潭大学毕业设计选题管理系统";
					String url2 = PropertiesReaderHelper.getEmailProperties().getProperty("XTUGraduation_URL");
					String content2 = "您所选择的毕设选题:"+subject.getSubjectName()+",指导教师 "+subject.getTeacherName()+
							" 已否决了您的选课,\n详情可登陆湘潭大学毕业设计选题管理系统查看。url链接为:"+url2;
					mailTemplate.send(address, null, null, title2, content2, false);
				}
			}
		}else if(subject.getPresentConfirmNum() > subject.getMaxStuNum()){
			throw new RuntimeException("课题当前志愿数确认数大于最大确认数,无法完成同意志愿操作!");
		}
		this.graduationSubjectDao.update(subject);
		
		//删除选题志愿
		this.subjectIdealDao.delete(SubjectIdeal.class,subjectIdeal.getSubjectIdealId());
		Teacher teacher = this.teacherDao.findTeacherById(subjectIdeal.getTeacherId());
		Department department = this.departmentDao.findDepartmentById(student.getDepartmentId());
		//设置选题结果的信息，并保存到数据库中
		BeanUtils.copyProperties(teacher, result);
		BeanUtils.copyProperties(student, result);
		BeanUtils.copyProperties(subject, result);
		BeanUtils.copyProperties(department, result);
		result.setTeacherCellPhone(teacher.getCellPhone());
		result.setTeacherEmail(teacher.getEmail());
		result.setStudentCellPhone(student.getCellPhone());
		result.setStudentEmail(student.getEmail());
		result.setDepartName(this.departmentDao.findDepartmentById(student.getDepartmentId()).getDepartmentName());
		this.subjectResultDao.save(result);
		return "success";
	}
	
	/**
	 * 删除其他志愿
	 * @param graduationSubjectId
	 * @param studentId
	 * @return
	 * @throws Exception 
	 */
	private String deleteSubjectDeal(Long graduationSubjectId, Long studentId,Long subjectIdealId) throws Exception {
		GraduationSubject subject = this.graduationSubjectDao.findGraduationSubjectById(graduationSubjectId);
		Student stu = this.studentDao.findStudentById(studentId);
		SubjectIdeal subjectIdeal = this.subjectIdealDao.findSubjectIdealBySubjectIdealId(subjectIdealId);
		if(stu == null || subject == null ){
			throw new Exception("操作失败,学生/选题 不存在");
		}
		if(subjectIdeal == null){
			throw new Exception("该志愿已被处理!");
		}
		if(stu.getIsConfirm()){
			throw new Exception("该学生已被确选!");
		}
		//删除志愿
		this.subjectIdealDao.delete(subjectIdeal);
		
		//学生当前志愿-1
		stu.setPresentIdealNum(stu.getPresentIdealNum()-1);
		this.studentDao.update(stu);
		//将该选题的当前选题人数-1
		subject.setPresentStuNum(subject.getPresentStuNum()-1);
		this.graduationSubjectDao.update(subject);
		//发送邮件通知教师
		Teacher teacher = teacherDao.findTeacherById(subject.getTeacherId());
		String [] toAddress={teacher.getEmail()};
		String title = "湘潭大学毕业设计选题管理系统";
		String url = PropertiesReaderHelper.getEmailProperties().getProperty("XTUGraduation_URL");
		String content = "您所发布的毕设选题:"+subject.getSubjectName()+"选择了您课题的 学号:"+stu.getStudentSno()+" , 姓名:"+stu.getStudentName()+
				" 的学生已被其他老师确定,\n我们已经删除了该生对您 "+subject.getSubjectName()+" 的选题记录,详情请登录湘潭大学毕业设计选题系统查看。url链接为:"+url;
		mailTemplate.send(toAddress, null, null, title, content, false);
		return "success";
	}
	
	@Override
	public String deleteMyStudent(Long subjectResultId) {
		SubjectResult result = this.subjectResultDao.findSubjectResultById(subjectResultId);
		Student student = this.studentDao.findStudentById(result.getStudentId());
		GraduationSubject subject = this.graduationSubjectDao.findGraduationSubjectById(result.getGraduationSubjectId());
//		SubjectIdeal subjectIdeal = this.subjectIdealDao.findSubjectIdeal(subject.getGraduationSubjectId(), student.getStudentId());
		//删除对应的选题志愿
//		this.subjectIdealDao.delete(SubjectIdeal.class, subjectIdeal.getSubjectIdealId());
		//更新学生信息
		student.setIsConfirm(false);
		this.studentDao.update(student);
		//发送邮件
		String [] toAddress={result.getStudentEmail()};
		String title = "湘潭大学毕业设计选题管理系统";
		String url = PropertiesReaderHelper.getEmailProperties().getProperty("XTUGraduation_URL");
		String content = "您所选择的毕设选题:"+subject.getSubjectName()+","+result.getTeacherName()+" 老师已经删除了您的选题,请登录湘潭大学毕业设计选题管理重新选择您的选题!\n"+
			"详情请登录湘潭大学毕业设计选题系统查看。url链接为:"+url;
		mailTemplate.send(toAddress, null, null, title, content, false);
		//更新课题信息
		if(subject.getIsChoosen()){
			subject.setIsChoosen(false);
			subject.setPresentConfirmNum(subject.getPresentConfirmNum()-1);
			subject.setPresentStuNum(subject.getPresentStuNum()-1);
		}else{
			subject.setPresentConfirmNum(subject.getPresentConfirmNum()-1);
			subject.setPresentStuNum(subject.getPresentStuNum()-1);
		}
		this.graduationSubjectDao.update(subject);
		this.subjectResultDao.delete(SubjectResult.class, result.getSubjectResultId());
		return "删除学生成功!";
	}
	
	@Override
	public String refuseIdeal(Long subjectIdealId) {
		SubjectIdeal subjectIdeal = this.subjectIdealDao.findSubjectIdealBySubjectIdealId(subjectIdealId);
//		//将志愿设置为 已处理
//		subjectIdeal.setIsConfirm(true);
		//更新学生信息
		Student student = this.studentDao.findStudentById(subjectIdeal.getStudentId());
		if(student.getPresentIdealNum() == 0 ){
			throw new RuntimeException("学生当前志愿数为0！无法完成否决志愿操作com.xtu.graduation.teacher.service.impl.TeacherService.refuseIdeal(Long subjectIdealId)");
		}
		student.setPresentIdealNum(student.getPresentIdealNum()-1);
		this.studentDao.update(student);
		//删除志愿信息
		this.subjectIdealDao.delete(SubjectIdeal.class, subjectIdeal.getSubjectIdealId());
		//更新选题信息
		GraduationSubject subject = this.graduationSubjectDao.findGraduationSubjectById(subjectIdeal.getGraduationSubjectId());
		subject.setPresentStuNum(subject.getPresentStuNum()-1);
		this.graduationSubjectDao.update(subject);
		//发送邮件!
		String [] toAddress={student.getEmail()};
		String title = "湘潭大学毕业设计选题管理系统";
		String url = PropertiesReaderHelper.getEmailProperties().getProperty("XTUGraduation_URL");
		String content = "您所选择的毕设选题:"+subjectIdeal.getSubjectName()+"  "+this.teacherDao.findTeacherById(subjectIdeal.getTeacherId()).getTeacherName()
				+"老师已否决了您的选题,\n请登陆湘潭大学毕业设计选题管理系统重新选择课题。url链接为:"+url;
		mailTemplate.send(toAddress, null, null, title, content, false);
		return "success";
	}

	@Override
	public List<SubjectResult> findAllSubjectResultByTeacherId(Long teacherId) {
		return this.subjectResultDao.findAllSubjectResultByTeacherId(teacherId);
	}

}
