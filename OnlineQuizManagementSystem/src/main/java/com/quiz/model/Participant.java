package com.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Participant is the Entity representing participates in database
 * 
 * @author Akash
 *
 */

@Entity
@Table(name = "participates")
public class Participant {
	@Id
	@Column(name = "participate_id")
	private int participatesId;

	@Column(name = "participate_name")
	private String participatesName;
    
	/**
	 * Participant default Constructor
	 */
	
	public Participant() {

	}

	/**
	 * Participant Constructor with fields as parameters
	 * 
	 * @param participateId   the participant Id
	 * @param participateName the name of participant
	 */

	public Participant(int participatesId, String participatesName) {
		super();
		this.participatesId = participatesId;
		this.participatesName = participatesName;
	}

	public int getParticipatesId() {
		return participatesId;
	}

	public void setParticipatesId(int participatesId) {
		this.participatesId = participatesId;
	}

	public String getParticipatesName() {
		return participatesName;
	}

	public void setParticipatesName(String participatesName) {
		this.participatesName = participatesName;
	}

	@Override
	public String toString() {
		return "Participates [participatesId=" + participatesId + ", participatesName=" + participatesName + "]";
	}

}
