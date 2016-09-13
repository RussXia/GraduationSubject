package com.xtu.graduation.subject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class SubjectResult {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long subjectResultId;
	
	/** 课题id */
	private Long graduationSubjectId;
	
	/** 教师id */
	private Long teacherId;
	
	/** 院系id */
	private Long departmentId;
	
	/** 教师工号 */
	private String teacherSno;
	
	/** 教师姓名 */
	private String teacherName;
	
	/** 学生id */
	private Long studentId;
	
	/** 学生学号 */
	private String studentSno;
	
	/** 学生姓名*/
	private String studentName;
	
	/** 课题名称 */
	private String subjectName;
	
	/** 院系名称 */
	private String departName;
	
	/** 课题方向 */
	private String subjectOrientation;
	
 	/** 课题难度 */
	private String level;
	
	/** 课题类型 */
	private String subjectType;
	
	/** 教师手机号 */
	private String teacherCellPhone;
	
	/** 教师邮箱 */
	@Size(max=30)
	private String teacherEmail;
	
	/** 学生手机号 */
	private String studentCellPhone;
	
	/** 学生邮箱 */
	@Size(max=30)
	private String studentEmail;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubjectResult [subjectResultId=" + subjectResultId + ", graduationSubjectId=" + graduationSubjectId
				+ ", teacherId=" + teacherId + ", departmentId=" + departmentId + ", teacherSno=" + teacherSno
				+ ", teacherName=" + teacherName + ", studentId=" + studentId + ", studentSno=" + studentSno
				+ ", studentName=" + studentName + ", subjectName=" + subjectName + ", departName=" + departName
				+ ", subjectOrientation=" + subjectOrientation + ", level=" + level + ", subjectType=" + subjectType
				+ ", teacherCellPhone=" + teacherCellPhone + ", teacherEmail=" + teacherEmail + ", studentCellPhone="
				+ studentCellPhone + ", studentEmail=" + studentEmail + "]";
	}

	/**
	 * @return the teacherCellPhone
	 */
	public String getTeacherCellPhone() {
		return teacherCellPhone;
	}



	/**
	 * @param teacherCellPhone the teacherCellPhone to set
	 */
	public void setTeacherCellPhone(String teacherCellPhone) {
		this.teacherCellPhone = teacherCellPhone;
	}



	/**
	 * @return the teacherEmail
	 */
	public String getTeacherEmail() {
		return teacherEmail;
	}



	/**
	 * @param teacherEmail the teacherEmail to set
	 */
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}



	/**
	 * @return the studentCellPhone
	 */
	public String getStudentCellPhone() {
		return studentCellPhone;
	}



	/**
	 * @param studentCellPhone the studentCellPhone to set
	 */
	public void setStudentCellPhone(String studentCellPhone) {
		this.studentCellPhone = studentCellPhone;
	}



	/**
	 * @return the studentEmail
	 */
	public String getStudentEmail() {
		return studentEmail;
	}



	/**
	 * @param studentEmail the studentEmail to set
	 */
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}



	/**
	 * @return the subjectType
	 */
	public String getSubjectType() {
		return subjectType;
	}

	/**
	 * @param subjectType the subjectType to set
	 */
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	/**
	 * @return the teacherName
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * @param teacherName the teacherName to set
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * @return the subjectResultId
	 */
	public Long getSubjectResultId() {
		return subjectResultId;
	}

	/**
	 * @param subjectResultId the subjectResultId to set
	 */
	public void setSubjectResultId(Long subjectResultId) {
		this.subjectResultId = subjectResultId;
	}

	/**
	 * @return the graduationSubjectId
	 */
	public Long getGraduationSubjectId() {
		return graduationSubjectId;
	}

	/**
	 * @param graduationSubjectId the graduationSubjectId to set
	 */
	public void setGraduationSubjectId(Long graduationSubjectId) {
		this.graduationSubjectId = graduationSubjectId;
	}

	/**
	 * @return the teacherId
	 */
	public Long getTeacherId() {
		return teacherId;
	}

	/**
	 * @param teacherId the teacherId to set
	 */
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * @return the teacherSno
	 */
	public String getTeacherSno() {
		return teacherSno;
	}

	/**
	 * @param teacherSno the teacherSno to set
	 */
	public void setTeacherSno(String teacherSno) {
		this.teacherSno = teacherSno;
	}

	/**
	 * @return the studentId
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentSno
	 */
	public String getStudentSno() {
		return studentSno;
	}

	/**
	 * @param studentSno the studentSno to set
	 */
	public void setStudentSno(String studentSno) {
		this.studentSno = studentSno;
	}

	/**
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * @param subjectName the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * @return the departName
	 */
	public String getDepartName() {
		return departName;
	}

	/**
	 * @param departName the departName to set
	 */
	public void setDepartName(String departName) {
		this.departName = departName;
	}

	/**
	 * @return the subjectOrientation
	 */
	public String getSubjectOrientation() {
		return subjectOrientation;
	}

	/**
	 * @param subjectOrientation the subjectOrientation to set
	 */
	public void setSubjectOrientation(String subjectOrientation) {
		this.subjectOrientation = subjectOrientation;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
}
