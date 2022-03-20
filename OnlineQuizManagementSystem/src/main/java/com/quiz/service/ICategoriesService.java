package com.quiz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quiz.model.Categories;
@Service

public interface ICategoriesService {
	
	public List<Categories> deleteCategories(Integer categoriesId);
	
	public List<Categories> getAllCategories();
	
	public Categories saveCategories(Categories categories);
}
 