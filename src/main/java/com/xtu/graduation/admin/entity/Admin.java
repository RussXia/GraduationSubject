package com.xtu.graduation.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity:管理员
 * @author Xia
 * @since Admin.java 2016年3月29日
 */
@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long adminId;
	
	/** 管理员账号 */
	@Column(unique=true)
	private String account;
	
	/** 密码 */
	private String password;
	
	/** 用户名 */
	private String userName;
	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", account=" + account + ", password=" + password + ", userName="
				+ userName + "]";
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the adminId
	 */
	public Long getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
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
}
