package com.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Participant is the Entity representing participates in database
 * 
 * @author Akash Bagade
 *
 */

@Entity
@Table(name = "participates")
public class Participant {
	@Id
	@Column(name = "participate_id")
	private int participantId;

	@Column(name = "participate_name")
	private String participantName;

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
	public Participant(int participantId, String participantName) {
		super();
		this.participantId = participantId;
		this.participantName = participantName;
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", participantName=" + participantName + "]";
	}
}
