package com.quiz.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quizes")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "quiz_id")
	private int quizId;
	@Column(name = "quiz_date")
	private Date quizDate;
	@Column(name = "start_time")
	private Time quizStartTime;
	@Column(name = "end_time")
	private Time quizEndTime;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id") // foriegn key
	private Categories categoryid;

	@Column(name = "participates_id")
	private int quizParticipateId; // (f k)
	@Column(name = "score")
	private int score;

	public Quiz() {

	}

	public Quiz(int quizId, Date quizDate, Time quizStartTime, Time quizEndTime, Categories categoryid,
			int quizParticipateId, int score) {
		super();
		this.quizId = quizId;
		this.quizDate = quizDate;
		this.quizStartTime = quizStartTime;
		this.quizEndTime = quizEndTime;
		this.categoryid = categoryid;
		this.quizParticipateId = quizParticipateId;
		this.score = score;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public Date getQuizDate() {
		return quizDate;
	}

	public void setQuizDate(Date quizDate) {
		this.quizDate = quizDate;
	}

	public Time getQuizStartTime() {
		return quizStartTime;
	}

	public void setQuizStartTime(Time quizStartTime) {
		this.quizStartTime = quizStartTime;
	}

	public Time getQuizEndTime() {
		return quizEndTime;
	}

	public void setQuizEndTime(Time quizEndTime) {
		this.quizEndTime = quizEndTime;
	}

	public Categories getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Categories categoryid) {
		this.categoryid = categoryid;
	}

	public int getQuizParticipateId() {
		return quizParticipateId;
	}

	public void setQuizParticipateId(int quizParticipateId) {
		this.quizParticipateId = quizParticipateId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", quizDate=" + quizDate + ", quizStartTime=" + quizStartTime
				+ ", quizEndTime=" + quizEndTime + ", categoryid=" + categoryid + ", quizParticipateId="
				+ quizParticipateId + ", score=" + score + "]";
	}

}
