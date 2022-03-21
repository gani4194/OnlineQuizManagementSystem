package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.model.Participant;

@Repository
public interface IParticipantRepository extends JpaRepository<Participant, Integer> {

}
