package com.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.IParticipantRepository;
import com.quiz.exception.ParticipantIdNotFoundException;
import com.quiz.exception.ParticipantNotFoundException;
import com.quiz.model.Participant;

@Service
public class ParticipantServiceImpl implements IParticipantService {
	@Autowired
	private IParticipantRepository participantRepo;

	// method implementing to delete Participant by Participant Id
	public List<Participant> deleteParticipant(Integer participantId) throws ParticipantIdNotFoundException {
		try {
			participantRepo.deleteById(participantId);
			return participantRepo.findAll();
		} catch (Exception e) {
			throw new ParticipantIdNotFoundException("Participant is not present in Database");
		}
	}

	// method implementing to update Participant.
	public List<Participant> updateParticipant(Participant participant) {
		participantRepo.saveAndFlush(participant);
		return participantRepo.findAll();
	}

	// method implementing to add Participant
	public Participant saveParticipant(Participant participant) {
		return participantRepo.save(participant);
	}

	// method implementing to get all the Participants
	@Override
	public List<Participant> getAllParticipant() {
		return participantRepo.findAll();
	}

	@Override
	public Participant loginParticipant(int participantId) throws ParticipantIdNotFoundException {
		try {
			Participant findById = participantRepo.findById(participantId).get();
			return findById;
		} catch (Exception e) {
			throw new ParticipantIdNotFoundException("Participant not found");
		}
	}

	@Override
	public String checkParticipant(Participant participant) throws ParticipantNotFoundException {
		try {
			String checkParticipant = participantRepo.getParticipant(participant.getParticipantName(),
					participant.getParticipantPass());
			System.out.println(checkParticipant);
			return checkParticipant;
		} catch (Exception e) {
			throw new ParticipantNotFoundException("participant not found");
		}
	}

	public Participant findParticipant(Integer participantId) {// newlyAdded
		Optional<Participant> part = participantRepo.findById(participantId);
		return part.get();
	}

}
