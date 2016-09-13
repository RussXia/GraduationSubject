package com.xtu.graduation.subject.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xtu.graduation.subject.dao.ISubjectResultDao;
import com.xtu.graduation.subject.entity.SubjectResult;
import com.xtu.graduation.subject.service.ISubjectResultService;

@Service
public class SubjectResultService implements ISubjectResultService{

	@Resource
	private ISubjectResultDao subjectResultDao;
	
	@Override
	public void addSubjectResult(SubjectResult subjectResult) {
		this.subjectResultDao.save(subjectResult);
	}

	@Override
	public void updateSubjectResult(SubjectResult subjectResult) {
		this.subjectResultDao.update(subjectResult);
	}

	@Override
	public void deleteSubjectResult(SubjectResult subjectResult) {
		this.subjectResultDao.delete(subjectResult);
		
	}

	@Override
	public SubjectResult findSubjectResultById(Long subjectResultId) {
		return this.subjectResultDao.findSubjectResultById(subjectResultId);
	}

	@Override
	public List<SubjectResult> findAllSubjectResult() {
		return this.subjectResultDao.findAllSubjectResult();
	}

	@Override
	public List<SubjectResult> findAllSubjectResultByDepartment(Long departmentId) {
		return this.subjectResultDao.findAllSubjectResultByDepartment(departmentId);
	}

	@Override
	public SubjectResult findSubjectResultByStudentId(Long studentId) {
		return this.subjectResultDao.findSubjectResultByStudentId(studentId);
	}

	@Override
	public List<SubjectResult> findAllSubjectResultByTeacherId(Long teacherId) {
		return this.subjectResultDao.findAllSubjectResultByTeacherId(teacherId);
	}

	@Override
	public List<SubjectResult> findAllSubjectResultByGraduationSubjectId(Long graduationSubjectId) {
		return this.subjectResultDao.findAllSubjectResultByGraduationSubjectId(graduationSubjectId);
	}

}
