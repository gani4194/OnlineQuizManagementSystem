package com.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.IQuestionRepository;
import com.quiz.exception.QuestionNoNotFoundException;
import com.quiz.model.Question;

@Service
public class QuestionServiceImpl implements IQuestionService {

	// connecting the service implementation with the Question repository
	@Autowired
	private IQuestionRepository questionRepository;

	// method implementing to get all the Questions
	public List<Question> getAllQuestion() { // get all Q
		return questionRepository.findAll();
	}

	// method implementing to get Question by Question No
	public Question findQuestion(Integer questionNo) throws QuestionNoNotFoundException {
		try {
			Optional<Question> questionCollect = questionRepository.findById(questionNo);
			return questionCollect.get();
		} catch (Exception e) {
			throw new QuestionNoNotFoundException("Question is Not Present in Database..!");
		}
	}

	// method implementing to delete Question by Question No
	public List<Question> deleteQuestion(Integer questionNo) {
		questionRepository.deleteById(questionNo);
		return questionRepository.findAll();
	}

	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}

}
