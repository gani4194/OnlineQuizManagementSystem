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
@RequestMapping("/Admin")
public class AdminController {
	@Autowired
	IAdminService adminService;

	// requests the controller to get all the Admin
	// http://localhost:8082/OnlineQuiz/Admin/getAllAdmins
	@GetMapping("/getAllAdmins")
	public ResponseEntity<List<Admin>> getAllAdmins() {

		List<Admin> admin = adminService.getAllAdmins();
		if (admin.isEmpty()) {
			return new ResponseEntity("Sorry! Admin not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
	}

	// requests the controller to add the Admin
	// http://localhost:8082/OnlineQuiz/Admin/addAdmin
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {

		return adminService.addAdmin(admin);
	}

	// requests the controller to update the Admin by Id
	// http://localhost:8082/OnlineQuiz/Admin/updateAdmin
	@PutMapping("/updateAdmin/{id}")
	public String updateUser(@RequestBody Admin admin, @PathVariable int id) {
		return adminService.updateAdmin(admin, id);
	}

	// requests the controller to delete the Admin by Id
	// http://localhost:8082/OnlineQuiz/Admin/deleteAdmin
	@DeleteMapping("/deleteAdmin/{adminId}")
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

	// requests the controller to log in Admin by Id
	// http://localhost:8082/OnlineQuiz/Admin/checklogin
	@GetMapping("/checklogin/{adminId}")
	public ResponseEntity<Admin> checkLogin(@PathVariable("adminId") int admin) throws AdminIdNotFoundException {
		Admin checklogin = adminService.loginAdmin(admin);
		if (checklogin == null) {
			return new ResponseEntity("Login Failed!", HttpStatus.NOT_FOUND);
		} else if (checklogin.getAdminId() == admin) {
			return new ResponseEntity("Login Successful!", HttpStatus.OK);
		} else {
			return new ResponseEntity("user is not an admin", HttpStatus.NOT_FOUND);
		}
	}
}