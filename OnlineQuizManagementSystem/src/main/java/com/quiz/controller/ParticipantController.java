package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.exception.ParticipantIdNotFoundException;
import com.quiz.exception.ParticipantNotFoundException;
import com.quiz.model.Participant;
import com.quiz.service.IParticipantService;

@CrossOrigin
@RestController
@RequestMapping("/Participant")
public class ParticipantController {
	@Autowired
	private IParticipantService partServices;

	// requests the controller to get all the Participants
	// http://localhost:8082/OnlineQuiz/Participant/Participants
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/Participants")
	public ResponseEntity<List<Participant>> getAllParticipant() {
		List<Participant> participant = partServices.getAllParticipant();
		if (participant.isEmpty()) {
			return new ResponseEntity("Sorry! Participant not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Participant>>(participant, HttpStatus.OK);
	}

	// requests the controller to delete Participant by Participant Id
	// http://localhost:8082/OnlineQuiz/Participant/updateParticipant
	@DeleteMapping("/deleteParticipant/{participantId}")
	public ResponseEntity<List<Participant>> deleteParticipant(@PathVariable("participantId") Integer participantId)
			throws ParticipantIdNotFoundException {
		List<Participant> existingParticipant = partServices.getAllParticipant(); // deleteParticipates(participatesId);
		for (Participant i : existingParticipant) {
			if (i.getParticipantId() == participantId) {
				List<Participant> participant = partServices.deleteParticipant(participantId);
				return new ResponseEntity<List<Participant>>(participant, HttpStatus.OK);
			}
		}
		throw new ParticipantIdNotFoundException("Participant not Present in database");
	}

	// requests the controller to update Participant
	// http://localhost:8082/OnlineQuiz/Participant/updateParticipant
	@PutMapping("/updateParticipant/{participantId}")
	public ResponseEntity<List<Participant>> updateParticipant(@RequestBody Participant participant) {
		List<Participant> participants = partServices.updateParticipant(participant);
		if (participants.isEmpty()) {
			return new ResponseEntity("Sorry! Participant not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Participant>>(participants, HttpStatus.OK);
	}

	// requests the controller to add Participant
	// http://localhost:8082/OnlineQuiz/Participant/addParticipant
	@PostMapping("/addParticipant")
	public ResponseEntity<Participant> saveParticipant(@RequestBody Participant participant) {
		Participant participants = partServices.saveParticipant(participant);
		if (participants == null) {
			return new ResponseEntity("Sorry! Participant not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Participant>(participants, HttpStatus.OK);
	}

	// requests the controller to log in Participant by Participant Id
	// http://localhost:8082/OnlineQuiz/Participant/checklogin
	@GetMapping("/checklogin/{participantId}")
	public ResponseEntity<Participant> checkLogin(@PathVariable("participantId") int participant)
			throws ParticipantIdNotFoundException {
		Participant checklogin = partServices.loginParticipant(participant);
		if (checklogin == null) {
			return new ResponseEntity("Login Failed!", HttpStatus.NOT_FOUND);
		} else if (checklogin.getParticipantId() == participant) {
			return new ResponseEntity("Login Successful!", HttpStatus.OK);
		} else {
			return new ResponseEntity("user is not a Participant", HttpStatus.NOT_FOUND);
		}
	}

	// http://localhost:8082/OnlineQuiz/Participant/participantlogin
	@PostMapping("/participantlogin")
	public ResponseEntity checkLogin(@RequestBody Participant participant) throws ParticipantNotFoundException {
		String checklogin = partServices.checkParticipant(participant);
		if (checklogin == null) {
			return new ResponseEntity("Login Failed!", HttpStatus.NOT_FOUND);
		} else if (checklogin.equals(participant.getParticipantName())) {
			return new ResponseEntity("Login Successful!", HttpStatus.OK);
		} else {
			return new ResponseEntity("Login Failed!", HttpStatus.NOT_FOUND);
		}
	}

	// http://localhost:8082/OnlineQuiz/Participant/ParticipantId/
	@GetMapping("ParticipantId/{participantId}") // newly added
	public ResponseEntity<Participant> findParticipant(@PathVariable("participantId") Integer participantId) {
		Participant participant = partServices.findParticipant(participantId);
		if (participant == null) {
			return new ResponseEntity("Sorry! Participant not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Participant>(participant, HttpStatus.OK);
	}

}
