package com.xtu.graduation.subject.dao;

import java.util.List;

import com.xtu.graduation.common.dao.IDaoSupport;
import com.xtu.graduation.subject.entity.GraduationSubject;

public interface IGraduationSubjectDao extends IDaoSupport{
	/**
	 * 通过id查询课题志愿信息
	 * @param id
	 */
	public GraduationSubject findGraduationSubjectById(Long graduationSubjectId);
	/**
	 * 通过id删除课题志愿信息
	 * @param id
	 */
	public void deleteGraduationSubjectById(Long graduationSubjectId);
	
	/**
	 * 通过教师id查询该教师的所有毕业设计题目
	 * @param teacherId
	 * @return
	 */
	public List<GraduationSubject> findGraduationSubjectByTeacherId(Long teacherId);
	
	/**
	 * 查询所有教师名称为 teacherName 的毕业设计题目
	 * @param teacherName
	 * @return
	 */
	public List<GraduationSubject> findGraduationSubjectByTeacherName(String teacherName);
	
	/**
	 * 查询所有已经确选的课题
	 * @return
	 */
	public List<GraduationSubject> findGraduationSubjectIsChoosen();
	
	/**
	 * 通过确切的课题名称查询课题
	 * @param subjectName
	 * @return
	 */
	public List<GraduationSubject> findGraduationSubjectBySubjectName(String subjectName);
	
	/**
	 * 通过院系id查询毕业设计题目
	 * @param departmentId
	 * @return
	 */
	public List<GraduationSubject> findGraduationSubjectByDepartmentId(Long departmentId);
	
	/**
	 * 通过院系id查询没有确选的毕业设计题目
	 * @param departmentId
	 * @return
	 */
	public List<GraduationSubject> findGraduationSubjectByDepartmentIdNotConfrim(Long departmentId);
	
	/**
	 * 通过所给的条件查询毕业设计题目
	 * @param params
	 * @return
	 */
	public List<GraduationSubject> findGraduationSubjectBySearchParam(String subjectName,String teacherName,
			String subjectOrientation,String level,String subjectType,Long departmentId);
}
