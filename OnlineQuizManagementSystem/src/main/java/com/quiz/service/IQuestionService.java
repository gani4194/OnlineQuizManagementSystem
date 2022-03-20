package com.quiz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quiz.exception.QuestionNoNotFoundException;
import com.quiz.model.Questions;

@Service
public interface IQuestionService {

	public List<Questions> getAllQuestion(); // get Q

	public Questions findQuestion(Integer questionNo) throws QuestionNoNotFoundException; // find q by no

	public Questions saveQuestion(Questions question); // post Mapping

	public List<Questions> deleteQuestion(Integer questionNo);

}
