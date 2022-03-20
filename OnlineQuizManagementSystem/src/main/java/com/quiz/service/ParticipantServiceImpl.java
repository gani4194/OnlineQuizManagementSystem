package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.quiz.dao.IParticipantRepository;
import com.quiz.model.Participant;


@Service
public class ParticipantServiceImpl implements IParticipantService{
	@Autowired
	private IParticipantRepository participateRepo;
	
	public List<Participant> deleteParticipates(Integer participatesId) {
		participateRepo.deleteById(participatesId);
		return  participateRepo.findAll();
	}
	
	public List<Participant> updateParticipates(Participant participates) {
		participateRepo.saveAndFlush(participates);
		return  participateRepo.findAll();
	}
	
	public Participant saveParticipates(Participant participates) {
		return participateRepo.save(participates);
	}
	
	
	@Override
	public List<Participant> getAllParticipates() {
		// TODO Auto-generated method stub
		return participateRepo.findAll();
	}

}
