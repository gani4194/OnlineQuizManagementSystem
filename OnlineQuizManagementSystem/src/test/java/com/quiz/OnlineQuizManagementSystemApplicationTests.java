package com.quiz;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.quiz.dao.IAdminRepository;
import com.quiz.model.Admin;
import com.quiz.service.AdminServiceImpl;
import com.quiz.service.IAdminService;

@SpringBootTest(classes=OnlineQuizManagementSystemApplication.class)
class OnlineQuizManagementSystemApplicationTests {
	
	@Mock
	private IAdminRepository adminRepository;
    @InjectMocks
    private IAdminService adminService= new AdminServiceImpl();
    
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testViewAdmin() {
		List<Admin> list= adminRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void testUpdateAdmin() {
		Admin admin=adminRepository.findById(1).get();
		admin.setAdminName("rakesh");
		adminRepository.save(admin);
		assertNotEquals("Suraj B", adminRepository.findById(1).get().getAdminName());
	}
}
