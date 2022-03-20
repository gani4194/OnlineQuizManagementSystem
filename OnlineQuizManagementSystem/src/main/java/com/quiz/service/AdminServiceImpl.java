package com.quiz.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.IAdminRepository;
import com.quiz.model.Admin;

@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	IAdminRepository adminRepo;

	@Override
	public Admin addAdmin(Admin admin) {
		Admin adminSaved = adminRepo.save(admin);
		return adminSaved;
	}

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

	@Override
	public String deleteAdmin(int id) {
		Admin admin = adminRepo.findById(id).get();
		if (admin == null) {
			return "Admin not found";
		}

		adminRepo.deleteById(id);

		return "Admin deleted";
	}

	@Override
	public List<Admin> getAllAdmins() {
// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

}