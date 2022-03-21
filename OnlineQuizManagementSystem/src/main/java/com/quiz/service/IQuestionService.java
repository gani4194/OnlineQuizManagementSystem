package com.quiz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quiz.exception.QuestionNoNotFoundException;
import com.quiz.model.Question;

@Service
public interface IQuestionService {

	public List<Question> getAllQuestion();

	public Question findQuestion(Integer questionNo) throws QuestionNoNotFoundException;

	public Question saveQuestion(Question question);

	public List<Question> deleteQuestion(Integer questionNo);

}
