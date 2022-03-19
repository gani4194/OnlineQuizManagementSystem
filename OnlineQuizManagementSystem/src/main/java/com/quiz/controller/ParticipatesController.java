package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Participates;
import com.quiz.service.IParticipatesService;

@RestController
@RequestMapping("/api")
public class ParticipatesController {
	@Autowired
	private IParticipatesService services;
	
	@GetMapping("/getbyname")
	public ResponseEntity<List<Participates>> getAllParticipates(){
	System.out.println("inside participates");
	
	List<Participates> participate= services.getAllParticipates();
	if(participate.isEmpty()) {
	return new ResponseEntity("Sorry! Participate not available!",
	HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity<List<Participates>>(participate, HttpStatus.OK);
	}
}
