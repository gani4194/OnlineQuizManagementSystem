package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.model.Participant;

@Repository
public interface IParticipantRepository extends JpaRepository<Participant, Integer> {
	
	@Query("SELECT p.participantName FROM Participant p WHERE p.participantName=:participant_name AND p.participantPass=:participant_pass")
	public String getParticipant(@Param("participant_name") String participant_name, @Param("participant_pass") String participant_pass);

}
