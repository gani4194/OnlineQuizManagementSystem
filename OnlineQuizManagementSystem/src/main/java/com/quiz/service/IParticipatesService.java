package com.quiz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quiz.model.Participates;

@Service
public interface IParticipatesService {
	public List<Participates> getAllParticipates();
}
