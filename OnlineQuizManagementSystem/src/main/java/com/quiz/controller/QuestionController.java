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
import com.quiz.model.Categories;
import com.quiz.model.Question;
import com.quiz.service.IQuestionService;

@RestController
@RequestMapping("/Question") // question
public class QuestionController {

	@Autowired
	private IQuestionService questionServices;

	// requests the controller to get the list of Questions
	// http://localhost:8082/OnlineQuiz/Question/getAllQuestion
	@GetMapping("/getAllQuestion")
	public ResponseEntity<List<Question>> getAllQuestion() {

		List<Question> question = questionServices.getAllQuestion();
		if (question.isEmpty()) {
			return new ResponseEntity("Sorry! Question not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Question>>(question, HttpStatus.OK);
	}

	// requests the controller to get the Question by Question Number
	// http://localhost:8082/OnlineQuiz/Question/getQuestion/
	@GetMapping("/getQuestion/{questionNo}")
	public ResponseEntity<Question> findQuestion(@PathVariable("questionNo") Integer questionNo)
			throws QuestionNoNotFoundException {
		List<Question> existingQuestion = questionServices.getAllQuestion();
		for (Question i : existingQuestion) {
			if (i.getQuestionNo() == questionNo) {
				Question question = questionServices.findQuestion(questionNo);
				return new ResponseEntity<Question>(question, HttpStatus.OK);
			}
		}
		throw new QuestionNoNotFoundException(
				"Question with question no. " + questionNo + " mentioned not present in database");
	}

	// requests the controller to add the Question
	// http://localhost:8082/OnlineQuiz/Question/addQuestion
	@PostMapping("/addQuestion")
	public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
		question = questionServices.saveQuestion(question);
		if (question == null) {
			return new ResponseEntity("Sorry! Question not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}

	// requests the controller to delete the Question by Question Number
	// http://localhost:8082/OnlineQuiz/Question/deleteQuestion
	@DeleteMapping("/deleteQuestion/{questionNo}")
	public ResponseEntity<List<Question>> deleteQuestion(@PathVariable("questionNo") Integer questionNo) {
		List<Question> question = questionServices.deleteQuestion(questionNo);
		if (question.isEmpty() || question == null) {
			return new ResponseEntity("Sorry! QuestionNo not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Question>>(question, HttpStatus.OK);
	}

}
