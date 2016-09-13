package com.xtu.graduation.subject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Entity:课题
 * @author Xia
 */
@Entity
public class GraduationSubject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long graduationSubjectId;
	
	/** 课题教师ID */
	private Long teacherId;
	
	/** 课题教师姓名 */
	private String teacherName;
	
	/** 课题名称 */
	private String subjectName;
	
	/** 课题难度 */
	private String level;
	
	/** 院系ID */
	private Long departmentId;
	
	/** 课题方向 */
	private String subjectOrientation;
	
	/** 限选人数 */
	private Integer maxStuNum;
	
	/** 已确定人数 */
	private Integer presentConfirmNum = 0;
	
	/** 报名人数 */
	private Integer presentStuNum = 0;
	
	/** 是否已确选 */
	private Boolean isChoosen = false;
	
	/** 课题类型 */
	private String subjectType;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
		result = prime * result + ((graduationSubjectId == null) ? 0 : graduationSubjectId.hashCode());
		result = prime * result + ((isChoosen == null) ? 0 : isChoosen.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((maxStuNum == null) ? 0 : maxStuNum.hashCode());
		result = prime * result + ((presentConfirmNum == null) ? 0 : presentConfirmNum.hashCode());
		result = prime * result + ((presentStuNum == null) ? 0 : presentStuNum.hashCode());
		result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
		result = prime * result + ((subjectOrientation == null) ? 0 : subjectOrientation.hashCode());
		result = prime * result + ((subjectType == null) ? 0 : subjectType.hashCode());
		result = prime * result + ((teacherId == null) ? 0 : teacherId.hashCode());
		result = prime * result + ((teacherName == null) ? 0 : teacherName.hashCode());
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
		GraduationSubject other = (GraduationSubject) obj;
		if (departmentId == null) {
			if (other.departmentId != null)
				return false;
		} else if (!departmentId.equals(other.departmentId))
			return false;
		if (graduationSubjectId == null) {
			if (other.graduationSubjectId != null)
				return false;
		} else if (!graduationSubjectId.equals(other.graduationSubjectId))
			return false;
		if (isChoosen == null) {
			if (other.isChoosen != null)
				return false;
		} else if (!isChoosen.equals(other.isChoosen))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (maxStuNum == null) {
			if (other.maxStuNum != null)
				return false;
		} else if (!maxStuNum.equals(other.maxStuNum))
			return false;
		if (presentConfirmNum == null) {
			if (other.presentConfirmNum != null)
				return false;
		} else if (!presentConfirmNum.equals(other.presentConfirmNum))
			return false;
		if (presentStuNum == null) {
			if (other.presentStuNum != null)
				return false;
		} else if (!presentStuNum.equals(other.presentStuNum))
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		if (subjectOrientation == null) {
			if (other.subjectOrientation != null)
				return false;
		} else if (!subjectOrientation.equals(other.subjectOrientation))
			return false;
		if (subjectType == null) {
			if (other.subjectType != null)
				return false;
		} else if (!subjectType.equals(other.subjectType))
			return false;
		if (teacherId == null) {
			if (other.teacherId != null)
				return false;
		} else if (!teacherId.equals(other.teacherId))
			return false;
		if (teacherName == null) {
			if (other.teacherName != null)
				return false;
		} else if (!teacherName.equals(other.teacherName))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GraduationSubject [graduationSubjectId=" + graduationSubjectId + ", teacherId=" + teacherId
				+ ", teacherName=" + teacherName + ", subjectName=" + subjectName + ", level=" + level
				+ ", departmentId=" + departmentId + ", subjectOrientation=" + subjectOrientation + ", maxStuNum="
				+ maxStuNum + ", presentConfirmNum=" + presentConfirmNum + ", presentStuNum=" + presentStuNum
				+ ", isChoosen=" + isChoosen + ", subjectType=" + subjectType + "]";
	}

	/**
	 * @return the presentConfirmNum
	 */
	public Integer getPresentConfirmNum() {
		return presentConfirmNum;
	}

	/**
	 * @param presentConfirmNum the presentConfirmNum to set
	 */
	public void setPresentConfirmNum(Integer presentConfirmNum) {
		this.presentConfirmNum = presentConfirmNum;
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
	 * @return the maxStuNum
	 */
	public Integer getMaxStuNum() {
		return maxStuNum;
	}

	/**
	 * @param maxStuNum the maxStuNum to set
	 */
	public void setMaxStuNum(Integer maxStuNum) {
		this.maxStuNum = maxStuNum;
	}

	/**
	 * @return the presentStuNum
	 */
	public Integer getPresentStuNum() {
		return presentStuNum;
	}

	/**
	 * @param presentStuNum the presentStuNum to set
	 */
	public void setPresentStuNum(Integer presentStuNum) {
		this.presentStuNum = presentStuNum;
	}

	/**
	 * @return the isChoosen
	 */
	public Boolean getIsChoosen() {
		return isChoosen;
	}

	/**
	 * @param isChoosen the isChoosen to set
	 */
	public void setIsChoosen(Boolean isChoosen) {
		this.isChoosen = isChoosen;
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
	
}
