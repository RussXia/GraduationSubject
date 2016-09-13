package com.xtu.graduation.subject.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xtu.graduation.common.dao.jpa.JpaDaoTemplate;
import com.xtu.graduation.subject.dao.IGraduationSubjectDao;
import com.xtu.graduation.subject.entity.GraduationSubject;

/**
 * GraduationSubjectDao 课题dao
 * @author Xia
 * @since GraduationSubjectDao.java 2016年3月29日
 */
@Repository("graduationSubjectDao")
public class GraduationSubjectDao extends JpaDaoTemplate implements IGraduationSubjectDao {

	@Override
	public GraduationSubject findGraduationSubjectById(Long graduationSubjectId) {
		return this.find(GraduationSubject.class, graduationSubjectId);
	}
	@Override
	public void deleteGraduationSubjectById(Long graduationSubjectId) {
		this.delete(GraduationSubject.class, graduationSubjectId);
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectByTeacherId(Long teacherId) {
		String query = "Select Entity From GraduationSubject Entity Where Entity.teacherId = ?";
		return this.list(GraduationSubject.class, query, teacherId);
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectByTeacherName(String teacherName) {
		String query = "Select Entity From GraduationSubject Entity Where Entity.teacherName = ?";
		return this.list(GraduationSubject.class, query, teacherName);
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectIsChoosen() {
		String query = "Select Entity From GraduationSubject Entity Where Entity.isChoosen = ?";
		return this.list(GraduationSubject.class, query, true);
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectBySubjectName(String subjectName) {
		String query = "Select Entity From GraduationSubject Entity Where Entity.subjectName = ?";
		return this.list(GraduationSubject.class, query, subjectName);
	}

	@Override
	public List<GraduationSubject> findGraduationSubjectByDepartmentId(Long departmentId) {
		String query = "Select Entity From GraduationSubject Entity Where Entity.departmentId = ?";
		return this.list(GraduationSubject.class, query, departmentId);
	}
	
	@Override
	public List<GraduationSubject> findGraduationSubjectByDepartmentIdNotConfrim(Long departmentId) {
		String query = "Select Entity From GraduationSubject Entity Where Entity.departmentId = ? and Entity.isChoosen = false";
		return this.list(GraduationSubject.class, query, departmentId);
	}
	
	
	@Override
	public List<GraduationSubject> findGraduationSubjectBySearchParam(String subjectName,String teacherName,
			String subjectOrientation,String level,String subjectType,Long departmentId) {
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer query = new StringBuffer("From GraduationSubject  where departmentId = :departmentId ");
		params.put("departmentId", departmentId);
		if(level != "" && level != null){
			query.append("and level = :level ");
			params.put("level", level);
		}
		if(subjectType != "" && subjectType != null){
			query.append("and subjectType = :subjectType ");
			params.put("subjectType", subjectType);
		}
		if(subjectName != "" && subjectName != null){
			query.append(" and subjectName like :subjectName") ;
			params.put("subjectName", "%"+subjectName+"%");
		}
		if(teacherName != "" && teacherName != null){
			query.append(" and teacherName like :teacherName ");
			params.put("teacherName", "%"+teacherName+"%");
		}
		if(subjectOrientation != "" && subjectOrientation != null){
			query.append(" and subjectOrientation like :subjectOrientation");
			params.put("subjectOrientation", "%"+subjectOrientation+"%");
		}
		
		
		System.out.println(query.toString());
		System.out.println(params);
		
		return this.list(GraduationSubject.class, query.toString(), params);
	}


}
