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
@Table(name = "participants")
public class Participant {
	@Id
	@Column(name = "participant_id")
	private int participantId;

	@Column(name = "participant_name")
	private String participantName;

	@Column(name = "participant_pass")
	private String participantPass;

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
	public Participant(int participantId, String participantName, String participantPass) {
		super();
		this.participantId = participantId;
		this.participantName = participantName;
		this.participantPass = participantPass;
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

	public String getParticipantPass() {
		return participantPass;
	}

	public void setParticipantPass(String participantPass) {
		this.participantPass = participantPass;
	}

	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", participantName=" + participantName
				+ ", participantPass=" + participantPass + "]";
	}

}