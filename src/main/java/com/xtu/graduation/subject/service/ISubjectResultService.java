package com.xtu.graduation.subject.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xtu.graduation.subject.entity.SubjectResult;

@Transactional
public interface ISubjectResultService {

	public void addSubjectResult(SubjectResult subject);
	public void updateSubjectResult(SubjectResult subject);
	public void deleteSubjectResult(SubjectResult subject);
	
	/**
	 * 根据选题结果id查询选题结果
	 * @param subjectResultId
	 * @return
	 */
	public SubjectResult findSubjectResultById(Long subjectResultId);
	
	/**
	 * 获取所有的选题结果
	 * @return
	 */
	public List<SubjectResult> findAllSubjectResult();
	
	/**
	 * 根据院系id获取选题结果
	 * @param departmentId
	 * @return
	 */
	public List<SubjectResult> findAllSubjectResultByDepartment(Long departmentId);

	/**
	 * 根据学生id查找选题结果
	 * @param studentId
	 * @return
	 */
	public SubjectResult findSubjectResultByStudentId(Long studentId);
	
	/**
	 * 根据教师id查找教师确定的选题结果
	 * @param teacherId
	 * @return
	 */
	public List<SubjectResult> findAllSubjectResultByTeacherId(Long teacherId);
	
	/**
	 * 根据选题id查询选题结果
	 * @param graduationSubjectId
	 * @return
	 */
	public List<SubjectResult> findAllSubjectResultByGraduationSubjectId(Long graduationSubjectId);
}
