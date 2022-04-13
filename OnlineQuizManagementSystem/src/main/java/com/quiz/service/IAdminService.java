package com.quiz.service;

import java.util.List;

import com.quiz.exception.AdminIdNotFoundException;
import com.quiz.exception.AdminNotFoundException;
import com.quiz.model.Admin;

public interface IAdminService {

	public List<Admin> getAllAdmins();

	Admin addAdmin(Admin admin);

	String updateAdmin(Admin admin, int id);

	public List<Admin> deleteAdmin(Integer adminId) throws AdminIdNotFoundException;

	public Admin loginAdmin(int adminId) throws AdminIdNotFoundException;
	
	public String checkAdmin(Admin admin) throws AdminNotFoundException;
	
	public Admin findAdmin(Integer adminId);
}