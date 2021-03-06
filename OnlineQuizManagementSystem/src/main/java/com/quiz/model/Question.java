package com.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Question is the Entity representing categories_table in database
 * 
 * @author Ganesh Pawar
 *
 */
@Entity
@Table(name = "questions_table")
public class Question {
	@Id
	@Column(name = "question_no")
	private int questionNo;

	@Column(name = "category_id")
	private int category;

	@Column(name = "question_title")
	private String questionTitle;

	@Column(name = "option_1")
	private String option1;

	@Column(name = "option_2")
	private String option2;

	@Column(name = "option_3")
	private String option3;

	@Column(name = "option_4")
	private String option4;

	@Column(name = "correct_answer")
	private String correctAnswer;

	@Column(name = "q_marks")
	private int qMarks;

	/**
	 * Question default Constructor
	 */
	public Question() {

	}

	public Question(int questionNo, int category, String questionTitle, String option1, String option2, String option3,
			String option4, String correctAnswer, int qMarks) {
		super();
		this.questionNo = questionNo;
		this.category = category;
		this.questionTitle = questionTitle;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctAnswer = correctAnswer;
		this.qMarks = qMarks;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getqMarks() {
		return qMarks;
	}

	public void setqMarks(int qMarks) {
		this.qMarks = qMarks;
	}

	@Override
	public String toString() {
		return "Question [questionNo=" + questionNo + ", category=" + category + ", questionTitle=" + questionTitle
				+ ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
				+ ", correctAnswer=" + correctAnswer + ", qMarks=" + qMarks + "]";
	}

}