package com.xtu.graduation.subject.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xtu.graduation.subject.dao.IGraduationSubjectDao;
import com.xtu.graduation.subject.entity.GraduationSubject;
import org.springframework.stereotype.Service;

import com.xtu.graduation.subject.service.IGraduationSubjectService;

@Service
public class GraduationSubjectService implements IGraduationSubjectService {

	@Resource
	private IGraduationSubjectDao graduationSubjectDao;
	
	@Override
	public void addGraduationSubject(GraduationSubject subject) {
		this.graduationSubjectDao.save(subject);
	}

	@Override
	public void updateGraduationSubject(GraduationSubject subject) {
		this.graduationSubjectDao.update(subject);
	}

	@Override
	public void deleteGraduationSubject(GraduationSubject subject) {
		this.graduationSubjectDao.delete(subject);
	}

	@Override
	public void deleteGraduationSubjectById(Long graduationSubjectId) {
		this.graduationSubjectDao.delete(GraduationSubject.class, graduationSubjectId);
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectByTeacherId(Long teacherId) {
		return this.graduationSubjectDao.findGraduationSubjectByTeacherId(teacherId);
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectByTeacherName(
			String teacherName) {
		return this.graduationSubjectDao.findGraduationSubjectByTeacherName(teacherName);
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectIsChoosen() {
		return this.graduationSubjectDao.findGraduationSubjectIsChoosen();
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectBySubjectName(
			String subjectName) {
		return this.graduationSubjectDao.findGraduationSubjectBySubjectName(subjectName);
	}

	@Override
	public GraduationSubject findGraduationSubjectBySubjectId(Long subjectId) {
		return this.graduationSubjectDao.find(GraduationSubject.class, subjectId);
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectByDepartmentId(Long departmentId) {
		return this.graduationSubjectDao.findGraduationSubjectByDepartmentId(departmentId);
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectBySearchParam(String subjectName,String teacherName,
			String subjectOrientation,String level,String subjectType,Long departmentId) {
		return this.graduationSubjectDao.findGraduationSubjectBySearchParam( subjectName, teacherName,
				 subjectOrientation, level, subjectType,departmentId);
	}

}
