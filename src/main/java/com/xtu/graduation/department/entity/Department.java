package com.xtu.graduation.department.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity类:院系
 * @author xia
 */
@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long departmentId;
	
	/** 院系名称 */	
	@Column(unique=true)
	private String departmentName;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName="
				+ departmentName + "]";
	}

}
