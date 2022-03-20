package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.dao.ICategoriesJpaRepository;
import com.quiz.model.Categories;


@Service
public class CategoriesServiceImpl implements ICategoriesService{
	
	@Autowired
	private ICategoriesJpaRepository categoriesRepo;

	public List<Categories> getAllCategories() {
		return categoriesRepo.findAll();
	}
	public Categories saveCategories(Categories categories) {
			return categoriesRepo.save(categories);
		}
	
	public List<Categories> deleteCategories(Integer categoriesId) {
		categoriesRepo.deleteById(categoriesId);
		return  categoriesRepo.findAll();
	}

}


    
	

	
	

	

