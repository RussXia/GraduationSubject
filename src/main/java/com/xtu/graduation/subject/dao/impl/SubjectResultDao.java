package com.xtu.graduation.subject.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xtu.graduation.common.dao.jpa.JpaDaoTemplate;
import com.xtu.graduation.subject.dao.ISubjectResultDao;
import com.xtu.graduation.subject.entity.SubjectResult;

/**
 * SubjectResultDao 选题结果dao
 * @author Xia
 * @since SubjectResultDao.java 2016年3月29日
 */
@Repository("subjectResultDao")
public class SubjectResultDao extends JpaDaoTemplate implements ISubjectResultDao {

	@Override
	public SubjectResult findSubjectResultByStudentId(Long studentId) {
		String query = "Select Entity From SubjectResult Entity Where Entity.studentId = ?";
		return this.find(SubjectResult.class, query, studentId);
	}
	
	@Override
	public List<SubjectResult> findAllSubjectResultByTeacherId(Long teacherId) {
		String query = "Select Entity From SubjectResult Entity Where Entity.teacherId = ?";
		return this.list(SubjectResult.class, query, teacherId);
	}
	
	@Override
	public List<SubjectResult> findAllSubjectResultByGraduationSubjectId(Long graduationSubjectId) {
		String query = "Select Entity From SubjectResult Entity Where Entity.graduationSubjectId = ?";
		return this.list(SubjectResult.class, query, graduationSubjectId);
	}

	@Override
	public SubjectResult findSubjectResultById(Long subjectResultId) {
		return this.find(SubjectResult.class, subjectResultId);
	}

	@Override
	public List<SubjectResult> findAllSubjectResult() {
		String query = "Select Entity From SubjectResult Entity Where 1=1";
		return this.list(SubjectResult.class, query);
	}

	@Override
	public List<SubjectResult> findAllSubjectResultByDepartment(Long departmentId) {
		String query = "Select Entity From SubjectResult Entity Where Entity.departmentId = ?";
		return this.list(SubjectResult.class, query, departmentId);
	}
}
