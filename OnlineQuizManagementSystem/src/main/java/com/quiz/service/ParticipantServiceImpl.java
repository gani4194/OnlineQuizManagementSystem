package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.IParticipantRepository;
import com.quiz.exception.ParticipantIdNotFoundException;
import com.quiz.model.Participant;

@Service
public class ParticipantServiceImpl implements IParticipantService {
	@Autowired
	private IParticipantRepository participateRepo;

	// method implementing to delete Participant by Participant Id
	public List<Participant> deleteParticipates(Integer participatesId) throws ParticipantIdNotFoundException {
		try {
			participateRepo.deleteById(participatesId);
			return participateRepo.findAll();
		} catch (Exception e) {
			System.out.println("Inside Implementation");
			throw new ParticipantIdNotFoundException("Participate is not present in Database");
		}
	}

	// method implementing to update Participant.
	public List<Participant> updateParticipates(Participant participates) {
		participateRepo.saveAndFlush(participates);
		return participateRepo.findAll();
	}

	// method implementing to add Participant
	public Participant saveParticipates(Participant participates) {
		return participateRepo.save(participates);
	}

	// method implementing to get all the Participants
	@Override
	public List<Participant> getAllParticipates() {
		// TODO Auto-generated method stub
		return participateRepo.findAll();
	}

}
