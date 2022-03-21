package com.quiz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.quiz.exception.QuizIdNotFoundException;
import com.quiz.model.Quiz;

@Service
public interface IQuizService {
	public List<Quiz> getAllQuiz();

	public Quiz findQuiz(Integer quizId) throws QuizIdNotFoundException;

	public Quiz saveQuiz(Quiz quiz);

}
