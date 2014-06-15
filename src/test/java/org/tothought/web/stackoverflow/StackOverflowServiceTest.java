package org.tothought.web.stackoverflow;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.tothought.data.entities.StackOverflowAnswer;

public class StackOverflowServiceTest {

	@Test
	public void findAllAnswersTest() {
		StackOverflowService service = new StackOverflowService();
		List<StackOverflowAnswer> answers = service.findAllAnswers();
		
		assertNotNull(answers);
		assertTrue(answers.size() > 0);
	}
	
	@Test
	public void findAllAnswersByDateTest(){
		StackOverflowService service = new StackOverflowService();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, -1);
		Date startDate = calendar.getTime();
		List<StackOverflowAnswer> answers = service.findAllAnswers(startDate, new Date());
		
		assertNotNull(answers);
		assertTrue(answers.size() > 0);
	}
	
	@Test
	public void findAllAnswersByTag(){
		StackOverflowService service = new StackOverflowService();
		
		List<StackOverflowAnswer> answers = service.findAnswersByTag("Java");

		assertNotNull(answers);
		assertTrue(answers.size() > 0);
	}

}
