package com.quiz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quiz.model.Participant;

@Service
public interface IParticipantService {
	public List<Participant> getAllParticipates();
	
	public List<Participant> deleteParticipates(Integer participatesId);

	public List<Participant> updateParticipates(Participant participates);
	
	public Participant saveParticipates(Participant participates);
	
	
}