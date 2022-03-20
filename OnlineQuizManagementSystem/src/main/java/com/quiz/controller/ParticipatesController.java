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

import com.quiz.model.Participates;
import com.quiz.service.IParticipatesService;

@RestController
@RequestMapping("/api")
public class ParticipatesController {
	@Autowired
	private IParticipatesService partServices;

	@GetMapping("/AllParticipates")
	public ResponseEntity<List<Participates>> getAllParticipates() {
		List<Participates> participate = partServices.getAllParticipates();
		if (participate.isEmpty()) {
			return new ResponseEntity("Sorry! Participate not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Participates>>(participate, HttpStatus.OK);
	}

	@DeleteMapping("/Participate/{participatesId}")
	public ResponseEntity<List<Participates>> deleteProduct(@PathVariable("participatesId") Integer participatesId) {
		List<Participates> participates = partServices.deleteParticipates(participatesId);
		if (participates.isEmpty() || participates == null) {
			return new ResponseEntity("Sorry! ParticipatesId not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Participates>>(participates, HttpStatus.OK);
	}

	@PutMapping("/Participate")
	public ResponseEntity<List<Participates>> updateParticipates(@RequestBody Participates participates) {
		List<Participates> participate = partServices.updateParticipates(participates);
		if (participate.isEmpty()) {
			return new ResponseEntity("Sorry! Participates not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Participates>>(participate, HttpStatus.OK);
	}
    
	@PostMapping("save/Participate")
	public ResponseEntity<Participates> saveParticipates(@RequestBody Participates participates) {
		Participates participate = partServices.saveParticipates(participates);
		if (participate == null) {
			return new ResponseEntity("Sorry! Participates not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Participates>(participate, HttpStatus.OK);
	}
}
