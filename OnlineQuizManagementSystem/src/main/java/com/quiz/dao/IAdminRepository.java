package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.model.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

	@Query("SELECT a.adminName FROM Admin a WHERE a.adminName=:admin_name AND a.adminPassword=:admin_password")
	public String getAdmin(@Param("admin_name") String admin_name, @Param("admin_password") String admin_password);
}
