package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.model.Question;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Integer> {


}
