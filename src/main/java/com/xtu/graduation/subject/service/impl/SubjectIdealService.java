package com.xtu.graduation.subject.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xtu.graduation.subject.dao.ISubjectIdealDao;
import com.xtu.graduation.subject.entity.SubjectIdeal;
import com.xtu.graduation.subject.service.ISubjectIdealService;

@Service
public class SubjectIdealService implements ISubjectIdealService {
	
	@Resource
	private ISubjectIdealDao subjectIdealDao;
	
	@Override
	public void addSubjectIdeal(SubjectIdeal subject) {
		this.subjectIdealDao.save(subject);
	}

	@Override
	public void updateSubjectIdeal(SubjectIdeal subject) {
		this.subjectIdealDao.update(subject);
	}

	@Override
	public void deleteSubjectIdeal(SubjectIdeal subject) {
		this.subjectIdealDao.delete(subject);
	}

	@Override
	public List<SubjectIdeal> findAllSubjectIdealByStudentId(Long studentId) {
		return this.subjectIdealDao.findAllSubjectIdealByStudentId(studentId);
	}

	@Override
	public List<SubjectIdeal> findAllSubjectIdealByTeacherId(Long teacherId) {
		return this.subjectIdealDao.findAllSubjectIdealByTeacherId(teacherId);
	}

	@Override
	public List<SubjectIdeal> findAllSubjectIdealByGraduationSubjectId(Long graduationSubjectId) {
		return this.findAllSubjectIdealByGraduationSubjectId(graduationSubjectId);
	}

	@Override
	public SubjectIdeal findSubjectIdealBySubjectIdealId(Long subjectIdealId) {
		return this.findSubjectIdealBySubjectIdealId(subjectIdealId);
	}

	@Override
	public SubjectIdeal findSubjectIdeal(Long graduationSubjectId, Long studentId) {
		return this.findSubjectIdeal(graduationSubjectId, studentId);
	}

}
