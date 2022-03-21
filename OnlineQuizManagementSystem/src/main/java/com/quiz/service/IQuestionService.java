package com.quiz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quiz.exception.QuestionNoNotFoundException;
import com.quiz.model.Question;

@Service
public interface IQuestionService {

	public List<Question> getAllQuestion(); // get Q

	public Question findQuestion(Integer questionNo) throws QuestionNoNotFoundException; // find q by no

	public Question saveQuestion(Question question); // post Mapping

	public List<Question> deleteQuestion(Integer questionNo);

}
