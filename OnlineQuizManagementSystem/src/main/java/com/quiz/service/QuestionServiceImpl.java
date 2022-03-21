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
	@Autowired
	private IQuestionRepository questionRepository;

	public List<Question> getAllQuestion() { // get all Q
		return questionRepository.findAll();
	}

	public Question findQuestion(Integer questionNo) throws QuestionNoNotFoundException  { // find Q by No
      try {
    	  Optional<Question> questionCollect=questionRepository.findById(questionNo);
    	  return questionCollect.get();
      }
      catch (Exception e) {
    	  System.out.println("Inside Implementation");
    	  throw new QuestionNoNotFoundException("Question is Not Present in Database..!");
      }
		
		//		Optional<Question> ques = questionRepository.findById(questionNo);
//		return ques.get();
	}

	public List<Question> deleteQuestion(Integer questionNo) {
		questionRepository.deleteById(questionNo);
		return questionRepository.  findAll();
	}

	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}

}
