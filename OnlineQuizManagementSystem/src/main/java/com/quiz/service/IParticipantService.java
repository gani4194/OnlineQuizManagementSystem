package com.quiz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.quiz.exception.ParticipantIdNotFoundException;
import com.quiz.model.Participant;

@Service
public interface IParticipantService {
	public List<Participant> getAllParticipant();

	public List<Participant> deleteParticipant(Integer participantId) throws ParticipantIdNotFoundException;

	public List<Participant> updateParticipant(Participant participant);

	public Participant saveParticipant(Participant participant);

	public Participant loginParticipant(int participantId) throws ParticipantIdNotFoundException;

}
