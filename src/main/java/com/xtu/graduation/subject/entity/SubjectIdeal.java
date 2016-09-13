package com.xtu.graduation.subject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity:选题志愿
 * @author Xia
 */
@Entity
public class SubjectIdeal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long subjectIdealId;
	
	/** 课题id */
	private Long graduationSubjectId;
	
	/** 学生id */
	private Long studentId;
	
	/** 教师id */
	private Long teacherId;
	
	/** 课题名称 */
	private String subjectName;
	
	/** 志愿是否已被确定，默认为false */
	private Boolean isConfirm = false;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((graduationSubjectId == null) ? 0 : graduationSubjectId.hashCode());
		result = prime * result + ((isConfirm == null) ? 0 : isConfirm.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((subjectIdealId == null) ? 0 : subjectIdealId.hashCode());
		result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
		result = prime * result + ((teacherId == null) ? 0 : teacherId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectIdeal other = (SubjectIdeal) obj;
		if (graduationSubjectId == null) {
			if (other.graduationSubjectId != null)
				return false;
		} else if (!graduationSubjectId.equals(other.graduationSubjectId))
			return false;
		if (isConfirm == null) {
			if (other.isConfirm != null)
				return false;
		} else if (!isConfirm.equals(other.isConfirm))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (subjectIdealId == null) {
			if (other.subjectIdealId != null)
				return false;
		} else if (!subjectIdealId.equals(other.subjectIdealId))
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		if (teacherId == null) {
			if (other.teacherId != null)
				return false;
		} else if (!teacherId.equals(other.teacherId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubjectIdeal [subjectIdealId=" + subjectIdealId + ", graduationSubjectId=" + graduationSubjectId
				+ ", studentId=" + studentId + ", teacherId=" + teacherId + ", subjectName=" + subjectName
				+ ", isConfirm=" + isConfirm + "]";
	}
	
	/**
	 * @return the isConfirm
	 */
	public Boolean getIsConfirm() {
		return isConfirm;
	}

	/**
	 * @param isConfirm the isConfirm to set
	 */
	public void setIsConfirm(Boolean isConfirm) {
		this.isConfirm = isConfirm;
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
}
