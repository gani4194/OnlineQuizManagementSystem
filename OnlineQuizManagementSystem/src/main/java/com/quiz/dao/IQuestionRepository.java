package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.model.Questions;

@Repository
public interface IQuestionRepository extends JpaRepository<Questions, Integer> {


}
