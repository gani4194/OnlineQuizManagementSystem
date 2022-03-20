package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.quiz.dao.IParticipatesRepository;
import com.quiz.model.Participates;


@Service
public class ParticipatesServiceImpl implements IParticipatesService{
	@Autowired
	private IParticipatesRepository participateRepo;
	
	public List<Participates> deleteParticipates(Integer participatesId) {
		participateRepo.deleteById(participatesId);
		return  participateRepo.findAll();
	}
	
	public List<Participates> updateParticipates(Participates participates) {
		participateRepo.saveAndFlush(participates);
		return  participateRepo.findAll();
	}
	
	public Participates saveParticipates(Participates participates) {
		return participateRepo.save(participates);
	}
	
	
	@Override
	public List<Participates> getAllParticipates() {
		// TODO Auto-generated method stub
		return participateRepo.findAll();
	}

}
