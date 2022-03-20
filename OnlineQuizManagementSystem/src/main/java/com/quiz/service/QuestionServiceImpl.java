package com.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.IQuestionRepository;
import com.quiz.model.Questions;

@Service
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private IQuestionRepository questionRepository;

	public List<Questions> getAllQuestion() { // get all Q
		return questionRepository.findAll();
	}

	public Questions findQuestion(Integer questionNo) { // find Q by No
		Optional<Questions> ques = questionRepository.findById(questionNo);
		return ques.get();
	}

	public List<Questions> deleteQuestion(Integer questionNo) {
		questionRepository.deleteById(questionNo);
		return questionRepository.  findAll();
	}

	public Questions saveQuestion(Questions question) {
		return questionRepository.save(question);
	}

}
