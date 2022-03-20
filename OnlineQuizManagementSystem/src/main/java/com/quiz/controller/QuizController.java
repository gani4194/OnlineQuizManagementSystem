package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Quiz;
import com.quiz.service.IQuizService;

@RestController
@RequestMapping("/Quiz")
public class QuizController {
	@Autowired
	private IQuizService partServices;
	
	@GetMapping("/Details")
	public ResponseEntity<List<Quiz>> getAllQuiz(){
		
		List<Quiz> quiz= partServices.getAllQuiz();
		if(quiz.isEmpty()) {
		return new ResponseEntity("Sorry! Quiz not available!",
		HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Quiz>>(quiz, HttpStatus.OK);
		}
	
	@PostMapping("save/Quiz")
	public ResponseEntity<Quiz> saveQuiz(@RequestBody Quiz quiz) {
		quiz = partServices.saveQuiz(quiz);
		if (quiz == null) {
			return new ResponseEntity("Sorry! Quiz not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Quiz>(quiz, HttpStatus.OK);
	}
	
}
