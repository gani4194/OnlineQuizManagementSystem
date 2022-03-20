package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.exception.QuestionNoNotFoundException;
import com.quiz.model.Questions;
import com.quiz.service.IQuestionService;

@RestController
@RequestMapping("/get")   //question
public class QuestionController {

	@Autowired
	private IQuestionService questionServices;

	@GetMapping("/AllQuestion")
	public ResponseEntity<List<Questions>> getAllQuestion() {

		List<Questions> question = questionServices.getAllQuestion();
		if (question.isEmpty()) {
			return new ResponseEntity("Sorry! Question not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Questions>>(question, HttpStatus.OK);
	}

	@GetMapping("/Questions/{questionNo}")
	public ResponseEntity<Questions> findQuestion(@PathVariable("questionNo") Integer questionNo) throws QuestionNoNotFoundException {
		Questions question = questionServices.findQuestion(questionNo);
		if (question == null) {
			return new ResponseEntity("Sorry! Question not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Questions>(question, HttpStatus.OK);
	}

	@PostMapping("save/Question")
	public ResponseEntity<Questions> saveQuestion(@RequestBody Questions question) {
		question = questionServices.saveQuestion(question);
		if (question == null) {
			return new ResponseEntity("Sorry! Question not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Questions>(question, HttpStatus.OK);
	}

	@DeleteMapping("/Delete/{questionNo}")
	public ResponseEntity<List<Questions>> deleteQuestion(@PathVariable("questionNo") Integer questionNo) {
		List<Questions> question = questionServices.deleteQuestion(questionNo);
		if (question.isEmpty() || question == null) {
			return new ResponseEntity("Sorry! QuestionNo not available!", HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<List<Questions>>(question, HttpStatus.OK);
	}

}
