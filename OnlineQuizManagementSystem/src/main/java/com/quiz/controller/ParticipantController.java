package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.exception.ParticipantIdNotFoundException;
import com.quiz.model.Participant;
import com.quiz.service.IParticipantService;

@RestController
@RequestMapping("/Participant")
public class ParticipantController {
	@Autowired
	private IParticipantService partServices;

    // requests the controller to get all the Participants
	// http://localhost:8082/OnlineQuiz/Participant/getAllParticipates

	@GetMapping("/getAllParticipates")
	public ResponseEntity<List<Participant>> getAllParticipates() {
		List<Participant> participate = partServices.getAllParticipates();
		if (participate.isEmpty()) {
			return new ResponseEntity("Sorry! Participate not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Participant>>(participate, HttpStatus.OK);
	}

	// requests the controller to delete Participant by Participant Id
	// #http://localhost:8082/OnlineQuiz/Participant/updateParticipant
	@DeleteMapping("/deleteParticipant/{participatesId}")
	public ResponseEntity<List<Participant>> deleteParticipates(@PathVariable("participatesId") Integer participatesId)
			throws ParticipantIdNotFoundException {
		List<Participant> existingParticipate = partServices.getAllParticipates(); // deleteParticipates(participatesId);
		for (Participant i : existingParticipate) {
			if (i.getParticipatesId() == participatesId) {
				List<Participant> participate = partServices.deleteParticipates(participatesId);
				return new ResponseEntity<List<Participant>>(participate, HttpStatus.OK);
			}
		}
		throw new ParticipantIdNotFoundException("Participate not Present in database");
	}

    // requests the controller to update Participant
	// #http://localhost:8082/OnlineQuiz/Participant/updateParticipant
	@PutMapping("/updateParticipant")
	public ResponseEntity<List<Participant>> updateParticipates(@RequestBody Participant participates) {
		List<Participant> participate = partServices.updateParticipates(participates);
		if (participate.isEmpty()) {
			return new ResponseEntity("Sorry! Participates not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Participant>>(participate, HttpStatus.OK);
	}

	// requests the controller to add Participant
	// #http://localhost:8082/OnlineQuiz/Participant/addParticipant
	@PostMapping("/addParticipant")
	public ResponseEntity<Participant> saveParticipates(@RequestBody Participant participates) {
		Participant participate = partServices.saveParticipates(participates);
		if (participate == null) {

			return new ResponseEntity("Sorry! Participates not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Participant>(participate, HttpStatus.OK);
	}

}
