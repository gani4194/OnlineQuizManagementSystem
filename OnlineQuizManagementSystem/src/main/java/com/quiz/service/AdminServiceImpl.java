package com.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.IAdminRepository;
import com.quiz.exception.AdminIdNotFoundException;
import com.quiz.exception.AdminNotFoundException;
import com.quiz.model.Admin;

@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	IAdminRepository adminRepo;

	// method implementing to add the Admins
	@Override
	public Admin addAdmin(Admin admin) {
		Admin adminSaved = adminRepo.save(admin);
		return adminSaved;
	}

	// method implementing to update admin by Id
	@Override
	public String updateAdmin(Admin admin, int id) {
		Admin updateAdmin = adminRepo.findById(id).get();
		if (updateAdmin == null) {
			return "Admin not found";
		}
		updateAdmin.setAdminName(admin.getAdminName());
		updateAdmin.setAdminPassword(admin.getAdminPassword());
		adminRepo.save(updateAdmin);
		return " Admin Role Updated";
	}

	// method implementing to delete admin by Id
	public List<Admin> deleteAdmin(Integer adminId) throws AdminIdNotFoundException {
		try {
			adminRepo.deleteById(adminId);
			return adminRepo.findAll();
		} catch (Exception e) {
			System.out.println("Inside Implementation");
			throw new AdminIdNotFoundException("Admin is not present in Database");
		}
	}

	@Override
	public Admin loginAdmin(int adminId) throws AdminIdNotFoundException {
		try {
			Admin findById = adminRepo.findById(adminId).get();
			return findById;
		} catch (Exception e) {

			throw new AdminIdNotFoundException("admin not found");
		}
	}

	// method implementing to get all the Admins
	@Override
	public List<Admin> getAllAdmins() {
		return adminRepo.findAll();
	}
	
	@Override
	public String checkAdmin(Admin admin) throws AdminNotFoundException {
		try {
			String checkAdmin = adminRepo.getAdmin(admin.getAdminName(), admin.getAdminPassword());
			System.out.println(checkAdmin);
			return checkAdmin;
		} catch (Exception e) {
			throw new AdminNotFoundException("Admin not found");
		}
	}
	
	public Admin findAdmin(Integer adminId) {
		Optional<Admin>adm=adminRepo.findById(adminId);
		return adm.get();
		}
	
	

}