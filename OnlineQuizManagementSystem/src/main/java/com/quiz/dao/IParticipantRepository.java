package com.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.model.Participant;

@Repository
public interface IParticipantRepository extends JpaRepository<Participant, Integer > {
	/*public List<Participates> addParticipates(Integer participatesId);
	
	@Query("SELECT part FROM Participates part  WHERE part.participates_id>=:pri ")
	public List<Participates> getById(@Param("pri") int participates_id);*///used when @PostMapping({participatesId})

}
