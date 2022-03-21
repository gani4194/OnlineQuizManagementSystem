package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.model.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

	
}