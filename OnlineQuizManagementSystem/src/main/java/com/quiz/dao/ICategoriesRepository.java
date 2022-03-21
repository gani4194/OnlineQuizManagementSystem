package com.quiz.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.quiz.model.Categories;
@Repository

public interface ICategoriesRepository extends JpaRepository<Categories, Integer> {
	
	
	
}