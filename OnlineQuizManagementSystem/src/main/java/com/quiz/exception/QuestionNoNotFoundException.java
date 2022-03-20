package com.quiz.exception;

public class QuestionNoNotFoundException extends Exception{
	
	public QuestionNoNotFoundException(String NoNotFound) {
		super(NoNotFound);
	}
	
}
