package com.quiz.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/* @ControllerAdvice class to handle the exceptions globally */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(AdminIdNotFoundException.class)
	public ResponseEntity<Object> handleAdminIdNotFoundException(){
		LOG.error("handleAdminIdNotFoundException");
		return new ResponseEntity<Object>("This Admin is not present in the database.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CategoryIdNotFoundException.class)
	public ResponseEntity<Object> handleCategoryIdNotFoundException(){
		LOG.error("handleCategoryIdNotFoundException");
		return new ResponseEntity<Object>("This Category is not present in the database.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ParticipantIdNotFoundException.class)
	public ResponseEntity<Object> handleParticipantIdNotFoundException(){
		LOG.error("handleParticipantIdNotFoundException");
		return new ResponseEntity<Object>("This Participant is not present in the database.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(QuestionNoNotFoundException.class)
	public ResponseEntity<Object> handleQuestionNoNotFoundException() {
		LOG.error("handleQuestionNoNotFoundException");
		return new ResponseEntity<Object>("This Question Number Not Available Database..!", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(QuizIdNotFoundException.class)
	public ResponseEntity<Object> handleQuizIdNotFoundException() {
		LOG.error("handleQuizIdNotFoundException");
		return new ResponseEntity<Object>("This Quiz ID Not Available Database..!", HttpStatus.NOT_FOUND);
	}
	
}
