package com.xtu.graduation.student.entity;

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
 * Entity:学生
 * @author Xia
 * @since Student.java 2016年3月29日
 */
@Entity
public class Student {
	/** 最大个人志愿数:3个 */
	public static final Integer MAX_PERSONAL_IDEAL = 3;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long studentId;
	
	/** 学号 */
	@Column(unique=true)
	private String studentSno;
	
	/** 密码 */
	private String password;
	
	/** 学生姓名 */
	private String studentName;
	
	/** 性别 :男,女*/
	@Size(max=1)
	private String sex = "男"; 
	
	/** 院系ID */
	private Long departmentId;
	
	/** 出生日期 */
	@Temporal(TemporalType.DATE)
	private Date birth;
	
	/** 手机号 */
	private String cellPhone;
	
	/** 邮箱 */
	@Size(max=30)
	private String email;
	
	/** 当前所选择的志愿数  */
	private Integer presentIdealNum = 0;
	
	/** 是否已被确认 */
	private Boolean isConfirm = false;
	
	@Transient
	private Department department;
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentSno=" + studentSno + ", password=" + password
				+ ", studentName=" + studentName + ", sex=" + sex + ", departmentId=" + departmentId + ", birth="
				+ birth + ", cellPhone=" + cellPhone + ", email=" + email + ", presentIdealNum=" + presentIdealNum
				+ ", isConfirm=" + isConfirm  + "]";
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
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
	 * @return the presentIdealNum
	 */
	public Integer getPresentIdealNum() {
		return presentIdealNum;
	}

	/**
	 * @param presentIdealNum the presentIdealNum to set
	 */
	public void setPresentIdealNum(Integer presentIdealNum) {
		this.presentIdealNum = presentIdealNum;
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
}
