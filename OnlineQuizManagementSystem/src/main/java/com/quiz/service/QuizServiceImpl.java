package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.IQuizRepository;
import com.quiz.model.Quiz;

@Service
public class QuizServiceImpl implements IQuizService{
	@Autowired
	private IQuizRepository quizRepo;
	
	public Quiz saveQuiz(Quiz quiz){
		System.out.println("inside save");
		return quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> getAllQuiz() {
		// TODO Auto-generated method stub
		return quizRepo.findAll() ;
	}
}
