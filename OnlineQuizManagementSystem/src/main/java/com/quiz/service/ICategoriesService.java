package com.quiz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quiz.exception.CategoryIdNotFoundException;
import com.quiz.model.Categories;

@Service

public interface ICategoriesService {

	public List<Categories> deleteCategories(Integer categoriesId) throws CategoryIdNotFoundException;

	public List<Categories> getAllCategories();

	public Categories saveCategories(Categories categories);

	public List<Categories> updateCategory(Categories categories);

	public Categories findCategory(Integer categoriesId);
}
