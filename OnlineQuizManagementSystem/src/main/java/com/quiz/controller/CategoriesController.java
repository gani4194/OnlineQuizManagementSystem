package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Categories;
import com.quiz.service.ICategoriesService;

@RestController
@RequestMapping("/Categories")
public class CategoriesController {
	@Autowired
	private ICategoriesService categoriesService;

	@GetMapping("/getCategories")
	public ResponseEntity<List<Categories>> getAllCategories() {
		List<Categories> categories = categoriesService.getAllCategories();
		if (categories.isEmpty()) {
			return new ResponseEntity("Sorry! Categories not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Categories>>(categories, HttpStatus.OK);
	}

	@PostMapping("save/categories")
	public ResponseEntity<Categories> saveCategories(@RequestBody Categories categories) {
		categories = categoriesService.saveCategories(categories);
		if (categories == null) {
			return new ResponseEntity("Sorry! Categories not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Categories>(categories, HttpStatus.OK);
	}

	@DeleteMapping("/categories/{categoriesId}")
	public ResponseEntity<List<Categories>> deleteCategories(@PathVariable("categoriesId") Integer categoriesId) {
		List<Categories> categories = categoriesService.deleteCategories(categoriesId);
		if (categories.isEmpty() || categories == null) {
			return new ResponseEntity("Sorry! CategoriesId not available!", HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<List<Categories>>(categories, HttpStatus.OK);
	}
}
