package com.xtu.graduation.teacher.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.xtu.graduation.department.entity.Department;
/**
 * Entity:教师
 * @author Xia
 */
@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long teacherId;
	
	/** 工号 */
	@Column(unique=true)
	private String teacherSno;
	
	/** 密码 */
	private String password;
	
	/** 院系ID */
	private Long departmentId;
	
	/** 教师姓名 */
	private String teacherName;
	
	/** 手机号 */
	private String cellPhone;
	
	/** 邮箱 */
	@Size(max=30)
	private String email;
	
	/** 简介 */
	private String introduction;
	
	/** 出生日期 */
	@Temporal(TemporalType.DATE)
	private Date birth;
	
	@Transient
	private Department department;
	
	/**
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherSno() {
		return teacherSno;
	}

	public void setTeacherSno(String teacherSno) {
		this.teacherSno = teacherSno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherSno=" + teacherSno + ", password=" + password
				+ ", departmentId=" + departmentId + ", teacherName=" + teacherName + ", cellPhone=" + cellPhone
				+ ", email=" + email + ", introduction=" + introduction + ", birth=" + birth + "]";
	}

}	
