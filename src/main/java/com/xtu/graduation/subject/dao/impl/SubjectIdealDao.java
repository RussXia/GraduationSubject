package com.xtu.graduation.subject.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xtu.graduation.common.dao.jpa.JpaDaoTemplate;
import com.xtu.graduation.subject.dao.ISubjectIdealDao;
import com.xtu.graduation.subject.entity.SubjectIdeal;

/**
 * SubjectIdealDao  选题志愿dao
 * @author Xia
 * @since SubjectIdealDao.java 2016年3月29日
 */
@Repository("subjectIdealDao")
public class SubjectIdealDao extends JpaDaoTemplate implements ISubjectIdealDao {

	@Override
	public List<SubjectIdeal> findAllSubjectIdealNotConfirmByStudentId(Long studentId) {
		String query = "Select Entity From SubjectIdeal Entity Where Entity.studentId = ? and Entity.isConfirm = false ";
		return this.list(SubjectIdeal.class, query, studentId);
	}

	@Override
	public List<SubjectIdeal> findAllSubjectIdealByTeacherId(Long teacherId) {
		String query = "Select Entity From SubjectIdeal Entity Where Entity.teacherId = ?";
		return this.list(SubjectIdeal.class, query, teacherId);
	}

	@Override
	public List<SubjectIdeal> findAllSubjectIdealByGraduationSubjectId(Long graduationSubjectId) {
		String query = "Select Entity From SubjectIdeal Entity Where Entity.graduationSubjectId = ?";
		return this.list(SubjectIdeal.class, query, graduationSubjectId);
	}

	@Override
	public SubjectIdeal findSubjectIdealBySubjectIdealId(Long subjectIdealId) {
		return this.find(SubjectIdeal.class, subjectIdealId);
	}

	@Override
	public SubjectIdeal findSubjectIdeal(Long graduationSubjectId, Long studentId) {
		String query = "Select Entity From SubjectIdeal Entity Where Entity.graduationSubjectId = ? and Entity.studentId = ?";
		SubjectIdeal subjectIdeal = this.find(SubjectIdeal.class, query, graduationSubjectId,studentId);
		return subjectIdeal;
	}
	
	@Override
	public SubjectIdeal findSubjectIdealNotConfirm(Long graduationSubjectId, Long studentId) {
		String query = "Select Entity From SubjectIdeal Entity Where Entity.graduationSubjectId = ? and Entity.studentId = ? and Entity.isConfirm = false";
		SubjectIdeal subjectIdeal = this.find(SubjectIdeal.class, query, graduationSubjectId,studentId);
		return subjectIdeal;
	}

	@Override
	public List<SubjectIdeal> findAllSubjectIdealByStudentId(Long studentId) {
		String query = "Select Entity From SubjectIdeal Entity Where Entity.studentId = ?";
		return this.list(SubjectIdeal.class, query, studentId);
	}

	@Override
	public List<SubjectIdeal> findSubjectIdealNotChoosenByTeacherId(Long teacherId) {
		String query = "Select Entity From SubjectIdeal Entity Where Entity.teacherId = ? and Entity.isConfirm = false";
		return this.list(SubjectIdeal.class, query, teacherId);
	}

	@Override
	public List<SubjectIdeal> findAllSubjectIdealNotConfirmByGraduationSubjectId(Long graduationSubjectId) {
		String query = "Select Entity From SubjectIdeal Entity Where Entity.graduationSubjectId = ? and Entity.isConfirm = false ";
		return this.list(SubjectIdeal.class, query, graduationSubjectId);
	}

}
