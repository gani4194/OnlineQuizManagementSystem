package com.quiz;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.quiz.dao.IAdminRepository;
import com.quiz.dao.ICategoriesRepository;
import com.quiz.dao.IParticipantRepository;
import com.quiz.dao.IQuestionRepository;
import com.quiz.dao.IQuizRepository;
import com.quiz.model.Admin;
import com.quiz.model.Categories;
import com.quiz.model.Participant;
import com.quiz.model.Question;
import com.quiz.model.Quiz;


@SpringBootTest(classes=OnlineQuizManagementSystemApplication.class)
class OnlineQuizManagementSystemApplicationTests {
	
	@Autowired
	private IAdminRepository adminRepository;
	
	@Autowired
	private IQuestionRepository questionRepository;
   
    // test case for checking the list of the Admin
	@Test
	public void testViewAdmin() {
		List<Admin> list= adminRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	// test case for checking the updation of Admin 
	@Test
	public void testUpdateAdmin() {
		Admin admin=adminRepository.findById(1).get();
		admin.setAdminName("suraj");
		adminRepository.save(admin);
		assertEquals("suraj", adminRepository.findById(1).get().getAdminName());
	}
	
	// test case for checking the list of the Question
	@Test
	public void testViewQuestion() {
		List<Question> list=questionRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	// test case for checking the updation of Question
	@Test
	public void testUpdateQuestion() {
	Question question=questionRepository.findById(20).get();
	question.setQuestionTitle("A Key which uniquely identifies each row in the table is known as?");
	questionRepository.save(question);
	assertNotEquals("A Key which uniquely identifies", questionRepository.findById(20).get().getQuestionTitle());
	}
	
	@Autowired
	private IParticipantRepository participantRepository;

	// test case for checking the list of the Participants
	@Test
	public void testViewParticipants() {
	List<Participant> list= participantRepository.findAll();
	assertThat(list).size().isGreaterThan(0);
	}

	// test case for checking the updation of Participant
	@Test
	public void testUpdateParticioant() {
	Participant participant=participantRepository.findById(2).get();
	participant.setParticipantName("jack");
	participantRepository.save(participant);
	assertEquals("jack", participantRepository.findById(2).get().getParticipantName());
	}
	
	@Autowired
	private IQuizRepository quizRepository;

	// test case for checking the list of the Quiz
	@Test
	public void testViewQuiz() {
	List<Quiz> list = quizRepository.findAll();
	assertThat(list).size().isGreaterThan(0);
	}
	
	@Autowired
	private ICategoriesRepository categoriesRepository;
	
	// test case for checking the list of the Categories
	@Test
	public void testViewCategories() {
	List<Categories> list= categoriesRepository.findAll();
	assertThat(list).size().isGreaterThan(0);
    }
}
