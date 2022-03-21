package com.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.IQuizRepository;
import com.quiz.exception.QuizIdNotFoundException;
import com.quiz.model.Quiz;

@Service
public class QuizServiceImpl implements IQuizService {
	@Autowired
	private IQuizRepository quizRepo;

	public Quiz saveQuiz(Quiz quiz) {
		System.out.println("inside save");
		return quizRepo.save(quiz);
	}

	// method implementing to get all the Quiz
	@Override
	public List<Quiz> getAllQuiz() {
		return quizRepo.findAll();
	}

	// method implementing to get quiz by Quiz Id
	@Override
	public Quiz findQuiz(Integer quizId) throws QuizIdNotFoundException {
		try {
			Optional<Quiz> quizCollect = quizRepo.findById(quizId);
			return quizCollect.get();
		} catch (Exception e) {
			throw new QuizIdNotFoundException("Quiz is not Present in Database");
		}
	}
}
