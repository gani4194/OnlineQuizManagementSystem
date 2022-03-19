package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.IParticipatesRepository;
import com.quiz.model.Participates;

@Service
public class ParticipatesServiceImpl implements IParticipatesService {
	@Autowired
	private IParticipatesRepository participatesRepo;
	
	public List<Participates> getAllParticipates(){
		return participatesRepo.findAll();
	}
	
}
