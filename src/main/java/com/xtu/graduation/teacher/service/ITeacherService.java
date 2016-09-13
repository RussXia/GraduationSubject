package com.xtu.graduation.teacher.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xtu.graduation.subject.entity.GraduationSubject;
import com.xtu.graduation.subject.entity.SubjectIdeal;
import com.xtu.graduation.subject.entity.SubjectIdealVO;
import com.xtu.graduation.subject.entity.SubjectResult;
import com.xtu.graduation.teacher.entity.Teacher;

@Transactional
public interface ITeacherService {

	public void addTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher);
	public void deleteTeacher(Teacher teacher);
	
	/**
	 * 通过id删除教师信息
	 * @param id
	 */
	public void deleteTeacherById(Long id);
	
	/**
	 * 通过工号sno删除教师信息
	 * @param sno
	 */
	public void deleteTeacherBySno(String sno);
	
	/**
	 * 通过id查找教师信息
	 * @param id
	 * @return
	 */
	public Teacher findTeacherById(Long id);
	
	/**
	 * 通过学号查找教师
	 * @param sno
	 * @return
	 */
	public Teacher findTeacherBySno(String sno);
	
	/**
	 * 通过姓名查找教师
	 * @param name
	 * @return
	 */
	public List<Teacher> findTeacherByName(String name);
	
	/**
	 * 通过所属院系名称查找教师
	 * @param name
	 * @return
	 */
	public List<Teacher> findTeacherByDepartmentName(String departmentName);
	
	/**
	 * 发布选题
	 * @param subject
	 */
	public void addGraduationSubject(GraduationSubject subject);
	
	/**
	 * 通过教师id查询选题
	 * @param teacherId
	 * @return
	 */
	public List<GraduationSubject> findSubjectByTeacherId(Long teacherId);
	
	/**
	 * 通过选题id删除课题志愿信息
	 * @param id
	 */
	public String deleteGraduationSubjectById(Long graduationSubjectId);
	
	/**
	 * 更新课题信息
	 * @param graduationSubjectId
	 * @param subjectName
	 * @param level
	 * @param subjectOrientation
	 * @param subjectType
	 * @return
	 */
	public String updateGraduationSubject(Long graduationSubjectId,String subjectName,String level,String subjectOrientation,String subjectType);
	
	/**
	 * 获取所有选择该教师的选题志愿
	 * @param teacherId
	 * @return
	 */
	public List<SubjectIdeal> getAllSubjectIdealByTeacherId(Long teacherId);
	
	/**
	 * 获取所有未处理的选题志愿
	 * @param teacherId
	 * @return
	 */
	public List<SubjectIdealVO> getAllSubjectIdealVO(Long teacherId);
	
	/**
	 * 同意志愿操作
	 * @param subjectIdealId
	 * @return
	 */
	public String confirmIdeal(Long subjectIdealId);
	
	/**
	 * 否决志愿操作
	 * @param subjectIdealId
	 * @return
	 */
	public String refuseIdeal(Long subjectIdealId);
	
	/**
	 * 根据教师id查找教师确定的选题结果
	 * @param teacherId
	 * @return
	 */
	public List<SubjectResult> findAllSubjectResultByTeacherId(Long teacherId);
	
	/**
	 * 根据选题结果id删除该教师所带的学生
	 * @param subjectResultId
	 * @return
	 */
	public String deleteMyStudent(Long subjectResultId);
}
