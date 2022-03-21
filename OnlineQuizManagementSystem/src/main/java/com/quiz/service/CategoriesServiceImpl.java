package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.dao.ICategoriesJpaRepository;
import com.quiz.exception.CategoryIdNotFoundException;
import com.quiz.model.Categories;

@Service
public class CategoriesServiceImpl implements ICategoriesService {

	@Autowired
	private ICategoriesJpaRepository categoriesRepo;

	// method implementing to get all the Categories
	public List<Categories> getAllCategories() {
		return categoriesRepo.findAll();
	}

	// method implementing to save all the Categories
	public Categories saveCategories(Categories categories) {
		return categoriesRepo.save(categories);
	}

	// method implementing to delete Categories by category Id
	public List<Categories> deleteCategories(Integer categoriesId) throws CategoryIdNotFoundException {
		try {
			categoriesRepo.deleteById(categoriesId);
			return categoriesRepo.findAll();
		} catch (Exception e) {
			System.out.println("Inside Implementation");
			throw new CategoryIdNotFoundException("Category is not present in Database");
		}
	}

}
