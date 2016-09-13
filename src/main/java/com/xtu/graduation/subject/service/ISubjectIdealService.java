package com.xtu.graduation.subject.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xtu.graduation.subject.entity.SubjectIdeal;

@Transactional
public interface ISubjectIdealService {
	
	public void addSubjectIdeal(SubjectIdeal subject);
	public void updateSubjectIdeal(SubjectIdeal subject);
	public void deleteSubjectIdeal(SubjectIdeal subject);
	
	/**
	 * 通过学生id查询该学生所有的选题志愿
	 * @param studentId
	 * @return
	 */
	public List<SubjectIdeal> findAllSubjectIdealByStudentId(Long studentId);
	
	/**
	 * 通过教师id查询该教师的课题下所有的选题志愿	
	 * @param studentId
	 * @return
	 */
	public List<SubjectIdeal> findAllSubjectIdealByTeacherId(Long teacherId);
	
	
	/**
	 * 通过选题id查询该选题下的所有志愿	
	 * @param studentId
	 * @return
	 */
	public List<SubjectIdeal> findAllSubjectIdealByGraduationSubjectId(Long graduationSubjectId);
	
	/**
	 * 通过选题志愿的id查询选题志愿
	 * @param subjectIdealId
	 * @return
	 */
	public SubjectIdeal findSubjectIdealBySubjectIdealId(Long subjectIdealId);
	
	/**
	 * 通过学生id和选题id查找选题志愿
	 * @param graduationSubjectId
	 * @param studentId
	 * @return
	 */
	public SubjectIdeal findSubjectIdeal(Long graduationSubjectId,Long studentId);
}
