package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.exception.CategoryIdNotFoundException;
import com.quiz.model.Categories;
import com.quiz.service.ICategoriesService;

@CrossOrigin
@RestController
@RequestMapping("/Category")
public class CategoriesController {
	@Autowired
	private ICategoriesService categoriesService;

	// requests the controller to get the list of Categories
	// http://localhost:8082/OnlineQuiz/Category/Categories
	@GetMapping("/Categories")
	public ResponseEntity<List<Categories>> getAllCategories() {
		List<Categories> categories = categoriesService.getAllCategories();
		if (categories.isEmpty()) {
			return new ResponseEntity("Sorry! Categories not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	// requests the controller to save the Categories
	// http://localhost:8082/OnlineQuiz/Category/addCategory
	@PostMapping("/addCategory")
	public ResponseEntity<Categories> saveCategories(@RequestBody Categories categories) {
		categories = categoriesService.saveCategories(categories);
		if (categories == null) {
			return new ResponseEntity("Sorry! Categories not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	// request the controller to Delete the Caregories by category Id
	// http://localhost:8082/OnlineQuiz/Category/deleteCategory/
	@DeleteMapping("/deleteCategory/{categoriesId}")
	public ResponseEntity<List<Categories>> deleteCategories(@PathVariable("categoriesId") Integer categoriesId)
			throws CategoryIdNotFoundException {
		List<Categories> existingCategories = categoriesService.getAllCategories();
		for (Categories i : existingCategories) {
			if (i.getCategoriesId() == categoriesId) {
				List<Categories> category = categoriesService.deleteCategories(categoriesId);
				return new ResponseEntity<>(category, HttpStatus.OK);
			}
		}
		throw new CategoryIdNotFoundException("Category not Present in database");
	}

	@PutMapping("/updateCategory/{categoriesId}")
	public ResponseEntity<List<Categories>> updateCategory(@RequestBody Categories categories) {
		List<Categories> category = categoriesService.updateCategory(categories);
		if (category.isEmpty()) {
			return new ResponseEntity("Sorry! Categories is not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Categories>>(category, HttpStatus.OK);
	}

	@GetMapping("/category/{categoriesId}")
	public ResponseEntity<Categories> findCategory(@PathVariable("categoriesId") Integer categoriesId) {
		Categories categories = categoriesService.findCategory(categoriesId);
		if (categories == null) {
			return new ResponseEntity("Sorry! Category not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Categories>(categories, HttpStatus.OK);
	}
}
