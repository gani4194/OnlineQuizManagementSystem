package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.exception.AdminIdNotFoundException;
import com.quiz.model.Admin;
import com.quiz.service.IAdminService;

@RestController
@RequestMapping("/quiz")
public class AdminController {
	@Autowired
	IAdminService adminService;

	@GetMapping("/getAllAdmins")
	public ResponseEntity<List<Admin>> getAllAdmins() {

		List<Admin> admin = adminService.getAllAdmins();
		if (admin.isEmpty()) {
			return new ResponseEntity("Sorry! Admin not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
	}

	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {

		Admin addAdmin = adminService.addAdmin(admin);
		return addAdmin;
	}

	@PutMapping("/update/{id}")
	public String updateUser(@RequestBody Admin admin, @PathVariable int id) {
		String updateAdmin = adminService.updateAdmin(admin, id);
		return updateAdmin;
	}

//	@DeleteMapping("/delete/{id}")
//	public String deleteUser(@PathVariable int id) throws AdminIdNotFoundException{
//		String deleteAdmin = adminService.deleteAdmin(id);
//		return deleteAdmin;
//	}
	@DeleteMapping("/Admin/{adminId}")
	public ResponseEntity<List<Admin>> deleteAdmin(@PathVariable("adminId") Integer adminId)
			throws AdminIdNotFoundException {
		List<Admin> existingAdmin = adminService.getAllAdmins();
		for (Admin i : existingAdmin) {
			if (i.getAdminId() == adminId) {
				List<Admin> admin = adminService.deleteAdmin(adminId);
				return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
			}
		}
		throw new AdminIdNotFoundException("Admin not Present in database");
	}
}