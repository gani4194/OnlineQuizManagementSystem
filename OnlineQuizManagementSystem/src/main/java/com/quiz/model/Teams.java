package com.quiz.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teams_table")
public class Teams {
	private String teamsTitle;
	@Id
	private int teamsId;
	public Teams(String teamsTitle, int teamsId) {
		super();
		this.teamsTitle = teamsTitle;
		this.teamsId = teamsId;
	}
	public String getTeamsTitle() {
		return teamsTitle;
	}
	public void setTeamsTitle(String teamsTitle) {
		this.teamsTitle = teamsTitle;
	}
	public int getTeamsId() {
		return teamsId;
	}
	public void setTeamsId(int teamsId) {
		this.teamsId = teamsId;
	}
	@Override
	public String toString() {
		return "Teams [teamsTitle=" + teamsTitle + ", teamsId=" + teamsId + "]";
	}
	
	
}
