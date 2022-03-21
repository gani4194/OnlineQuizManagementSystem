package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.exception.QuizIdNotFoundException;
import com.quiz.model.Quiz;
import com.quiz.service.IQuizService;

@RestController
@RequestMapping("/Quiz")
public class QuizController {
	@Autowired
	private IQuizService partServices;

	@GetMapping("/Details")
	public ResponseEntity<List<Quiz>> getAllQuiz() {

		List<Quiz> quiz = partServices.getAllQuiz();
		if (quiz.isEmpty()) {
			return new ResponseEntity("Sorry! Quiz not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Quiz>>(quiz, HttpStatus.OK);
	}
	
	@GetMapping("/Quiz/{quizId}")
	public ResponseEntity<Quiz> findQuizById(@PathVariable("quizId") Integer quizId)
			throws QuizIdNotFoundException {
		List<Quiz> existingQuiz = partServices.getAllQuiz();
		for (Quiz i : existingQuiz) {
			if (i.getQuizId() == quizId) {
				Quiz quiz = partServices.findQuiz(quizId);
				return new ResponseEntity<Quiz>(quiz, HttpStatus.OK);
			}
		}
		throw new QuizIdNotFoundException("Quiz with "+ quizId + " mentioned not Present in database");
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
