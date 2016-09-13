package com.xtu.graduation.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xtu.graduation.common.util.MailTemplate;
import com.xtu.graduation.common.util.PropertiesReaderHelper;
import com.xtu.graduation.student.dao.IStudentDao;
import com.xtu.graduation.student.entity.Student;
import com.xtu.graduation.student.service.IStudentService;
import com.xtu.graduation.subject.dao.IGraduationSubjectDao;
import com.xtu.graduation.subject.dao.ISubjectIdealDao;
import com.xtu.graduation.subject.dao.ISubjectResultDao;
import com.xtu.graduation.subject.entity.GraduationSubject;
import com.xtu.graduation.subject.entity.SubjectIdeal;
import com.xtu.graduation.subject.entity.SubjectResult;
import com.xtu.graduation.teacher.dao.ITeacherDao;
import com.xtu.graduation.teacher.entity.Teacher;

@Service
public class StudentService implements IStudentService {
	
	@Resource
	private IStudentDao studentDao;
	
	@Resource
	private  MailTemplate mailTemplate ;
	
	@Resource
	private  ITeacherDao teacherDao ;
	
	@Resource
	private IGraduationSubjectDao graduationSubjectDao;
	
	@Resource
	private ISubjectIdealDao subjectIdealDao;
	
	@Resource
	private ISubjectResultDao subjectResultDao;
	
	@Override
	public void addStudent(Student stu) {
		this.studentDao.save(stu);
		return ;
	}

	@Override
	public void updateStudent(Student stu) {
		this.studentDao.update(stu);
		return ;
	}

	@Override
	public void deleteStudent(Student stu) {
		this.studentDao.delete(Student.class, stu.getStudentId());
		return ;
	}

	@Override
	public void deleteStudentById(Long id) {
		this.studentDao.delete(this.studentDao.find(Student.class, id));
		return ;
	}
	
	@Override
	public Student findStudentById(Long id) {
		return this.studentDao.find(Student.class, id);
	}

	@Override
	public Student findStudentBySno(String sno) {
		return this.studentDao.findStudentBySno(sno);
	}

	@Override
	public List<Student> findStudentByName(String name) {
		return this.studentDao.findStudentsByName(name);
	}

	@Override
	public List<Student> findStudentByDepartmentName(String departmentName) {
		return studentDao.findStudentByDepartmentName(departmentName);
	}

	@Override
	public void deleteStudentBySno(String sno) {
		this.studentDao.deleteStudentBySno(sno);
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectByDepartmentId(Long departmentId) {
		return this.graduationSubjectDao.findGraduationSubjectByDepartmentId(departmentId);
	}
	
	@Override
	public List<GraduationSubject> findGraduationSubjectByDepartmentIdNotConfirm(Long departmentId) {
		return this.graduationSubjectDao.findGraduationSubjectByDepartmentIdNotConfrim(departmentId);
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectByStudentId(Long studentId) {
		//获取该学生的未被处理的所有选题志愿
		List<SubjectIdeal> subjectIdeals = this.subjectIdealDao.findAllSubjectIdealNotConfirmByStudentId(studentId);
		List<GraduationSubject> graduationSubjects = new ArrayList<GraduationSubject>();
		for(SubjectIdeal subjectIdeal : subjectIdeals ){
			//根据选题志愿找到该选题
			graduationSubjects.add(this.graduationSubjectDao.findGraduationSubjectById(subjectIdeal.getGraduationSubjectId()));
		}
		return graduationSubjects;
	}

	@Override
	public String chooseGraduationSubject(Long graduationSubjectId, Long studentId) {
		GraduationSubject subject = this.graduationSubjectDao.findGraduationSubjectById(graduationSubjectId);
		Student stu = this.studentDao.findStudentById(studentId);
		
		if(subject.getIsChoosen()){
			return "该选题已被确选,请重新选择其他毕设选题!";
		}if(stu.getIsConfirm() == true){
			return "您已经完成毕设选题,如要更换选题，请与毕设老师商议!";
		}
		if(stu.getPresentIdealNum()==Student.MAX_PERSONAL_IDEAL){
			return "您所能选择的课题已经达到最大数!";
		}
		SubjectIdeal ideal = this.subjectIdealDao.findSubjectIdeal(graduationSubjectId, studentId);
		if(ideal != null ){
			return "您已经选择该选题，请勿重复选择!";
		}
		//设置生成的选题志愿信息
		SubjectIdeal subjectIdeal = new SubjectIdeal();
		subjectIdeal.setGraduationSubjectId(graduationSubjectId);
		subjectIdeal.setStudentId(studentId);
		subjectIdeal.setTeacherId(subject.getTeacherId());
		subjectIdeal.setSubjectName(subject.getSubjectName());
		//将 subjectIdeal 保存到数据库中
		this.subjectIdealDao.save(subjectIdeal);
		//将学生的当前志愿数+1
		Integer presentIdealNum = stu.getPresentIdealNum() + 1;
		stu.setPresentIdealNum(presentIdealNum);
		//更新学生信息
		this.studentDao.update(stu);
		//将课题的当前选题人数(presentStuNum)+1
		Integer presentStuNum = subject.getPresentStuNum()+1;
		subject.setPresentStuNum(presentStuNum);
		this.graduationSubjectDao.update(subject);
		//发送邮件到教师的邮箱中
		Teacher teacher = teacherDao.findTeacherById(subject.getTeacherId());
		String [] toAddress={teacher.getEmail()};
		String title = "湘潭大学毕业设计选题管理系统";
		String url = PropertiesReaderHelper.getEmailProperties().getProperty("XTUGraduation_URL");
		String content = "您所发布的毕设选题:"+subject.getSubjectName()+",已有学生选择，选择的学生是：学号:"+stu.getStudentSno()+",姓名:"+stu.getStudentName()+
				",\n请尽快登陆湘潭大学毕业设计选题管理系统进行处理。url链接为:"+url;
		mailTemplate.send(toAddress, null, null, title, content, false);
		return "success";
	}

	@Override
	public String deleteSubjectDeal(Long graduationSubjectId, Long studentId) {
		GraduationSubject subject = this.graduationSubjectDao.findGraduationSubjectById(graduationSubjectId);
		Student stu = this.studentDao.findStudentById(studentId);
		if(stu == null || subject == null ){
			throw new RuntimeException("操作失败,学生/选题 不存在");
//			return "操作失败,学生/选题/选题志愿 不存在";
		}
		SubjectIdeal sub = this.subjectIdealDao.findSubjectIdealNotConfirm(graduationSubjectId, studentId);
		if(sub == null){
			return "该课题已被处理，处理结果请查看邮箱的通知";
		}
		if(stu.getIsConfirm()){
		  return "您已经被毕设老师确定，无法删除该选课，若要继续删除，请与毕设老师联系！";
		}
		//删除志愿
		this.subjectIdealDao.delete(SubjectIdeal.class, sub.getSubjectIdealId());
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
		String content = "您所发布的毕设选题:"+subject.getSubjectName()+",有学生删除了他的选课，该学生是：学号:"+stu.getStudentSno()+",姓名:"+stu.getStudentName()+
				",\n详情请登录湘潭大学毕业设计选题系统查看。url链接为:"+url;
		mailTemplate.send(toAddress, null, null, title, content, false);
		return "success";
	}

	@Override
	public List<GraduationSubject> searchSubjct(String subjectName, String teacherName, String subjectOrientation,
			String level, String subjectType, Long departmentId,Long studentId) {
		// TODO Auto-generated method stub
		List<GraduationSubject> subjectList =  this.graduationSubjectDao.findGraduationSubjectBySearchParam(subjectName, teacherName, subjectOrientation, level, subjectType, departmentId);
		List<GraduationSubject> hasChoosen = this.findGraduationSubjectByStudentId(studentId);
		for(GraduationSubject graduationSubject : hasChoosen){
			if(subjectList.contains(graduationSubject)){
				subjectList.remove(graduationSubject);
			}
		}
		return subjectList;
	}

	@Override
	public SubjectResult findSubjectResultByStudentId(Long studentId) {
		return this.subjectResultDao.findSubjectResultByStudentId(studentId);
	}
	
	
}
