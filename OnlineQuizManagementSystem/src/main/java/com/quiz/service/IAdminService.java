package com.quiz.service;

import java.util.List;

import com.quiz.model.Admin;

public interface IAdminService {

	public List<Admin> getAllAdmins();

	Admin addAdmin(Admin admin);

	String updateAdmin(Admin admin, int id);

	String deleteAdmin(int id);
}