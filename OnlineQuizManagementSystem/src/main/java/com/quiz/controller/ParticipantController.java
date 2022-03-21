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
@RequestMapping("/api")
public class ParticipantController {
	@Autowired
	private IParticipantService partServices;

	@GetMapping("/AllParticipates")
	public ResponseEntity<List<Participant>> getAllParticipates() {
		List<Participant> participate = partServices.getAllParticipates();
		if (participate.isEmpty()) {
			return new ResponseEntity("Sorry! Participate not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Participant>>(participate, HttpStatus.OK);
	}

	@DeleteMapping("/Participate/{participatesId}")
	public ResponseEntity<List<Participant>> deleteParticipates(@PathVariable("participatesId") Integer participatesId) throws ParticipantIdNotFoundException {
		List<Participant> existingParticipate = partServices.getAllParticipates();       //deleteParticipates(participatesId);
		for(Participant i : existingParticipate) {
			if(i.getParticipatesId()==participatesId) {
				List<Participant> participate= partServices.deleteParticipates(participatesId);
				return new ResponseEntity<List<Participant>>(participate, HttpStatus.OK);
			}
		}
		throw new ParticipantIdNotFoundException("Participate not Present in database");
	}

	@PutMapping("/Participate")
	public ResponseEntity<List<Participant>> updateParticipates(@RequestBody Participant participates) {
		List<Participant> participate = partServices.updateParticipates(participates);
		if (participate.isEmpty()) {
			return new ResponseEntity("Sorry! Participates not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Participant>>(participate, HttpStatus.OK);
	}
    
	@PostMapping("save/Participate")
	public ResponseEntity<Participant> saveParticipates(@RequestBody Participant participates)  {
		Participant participate = partServices.saveParticipates(participates);
		if (participate == null) {
			
			return new ResponseEntity("Sorry! Participates not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Participant>(participate, HttpStatus.OK);
	}
	
	
}
