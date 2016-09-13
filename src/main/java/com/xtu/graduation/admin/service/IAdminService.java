package com.xtu.graduation.admin.service;

import java.util.List;

import com.xtu.graduation.admin.entity.Admin;

public interface IAdminService {
	
	public void addAdmin(Admin admin); 
	public void updateAdmin(Admin admin);
	public void deleteAdmin(Admin admin);
	/**
	 * 通过id查找管理员用户
	 * @param id
	 * @return Admin
	 */
	public Admin findAdminById(Long id);
	/**
	 * 查询所有的管理员
	 * @return
	 */
	public List<Admin> findAllAdmin();
}
