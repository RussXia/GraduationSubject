/**
 * 
 */
package com.xtu.graduation.subject.entity;

/**
 * 课题志愿查询VO类
 * @author Xia
 * @since SubjectIdealVO.java 2016年4月29日 
 */
public class SubjectIdealVO {

	/** 选题志愿id */
	private Long subjectIdealId;
	
	/** 课题名称 */
	private String subjectName;
	
	/** 学号 */
	private String studentSno;
	
	/** 学生姓名 */
	private String studentName;
	
	/** 手机号 */
	private String cellPhone;
	
	/** 邮箱 */
	private String email;
	
	/** 课题难度 */
	private String level;
	
	/** 课题方向 */
	private String subjectOrientation;
	
	/** 课题类型 */
	private String subjectType;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubjectIdealVO [subjectIdealId=" + subjectIdealId + ", subjectName=" + subjectName + ", studentSno="
				+ studentSno + ", studentName=" + studentName + ", cellPhone=" + cellPhone + ", email=" + email
				+ ", level=" + level + ", subjectOrientation=" + subjectOrientation + ", subjectType=" + subjectType
				+ "]";
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
	 * @return the subjectIdealId
	 */
	public Long getSubjectIdealId() {
		return subjectIdealId;
	}

	/**
	 * @param subjectIdealId the subjectIdealId to set
	 */
	public void setSubjectIdealId(Long subjectIdealId) {
		this.subjectIdealId = subjectIdealId;
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
	 * @return the cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @param cellPhone the cellPhone to set
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	
}
