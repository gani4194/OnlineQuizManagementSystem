package com.quiz;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.quiz.dao.IAdminRepository;

import com.quiz.model.Admin;


@SpringBootTest(classes=OnlineQuizManagementSystemApplication.class)
class OnlineQuizManagementSystemApplicationTests {
	
	@Autowired
	private IAdminRepository adminRepository;
   
    // test case for checking the list of the Admin
	@Test
	public void testViewAdmin() {
		List<Admin> list= adminRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	// test case for checking the updation of Admin 
	@Test
	public void testUpdateAdmin() {
		Admin admin=adminRepository.findById(1).get();
		admin.setAdminName("suraj");
		adminRepository.save(admin);
		assertEquals("suraj", adminRepository.findById(1).get().getAdminName());
	}
}
