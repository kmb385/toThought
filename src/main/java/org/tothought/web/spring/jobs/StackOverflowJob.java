package org.tothought.web.spring.jobs;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.data.entities.StackOverflowAnswer;
import org.tothought.data.entities.Tag;
import org.tothought.data.repositories.RecentDataLoadLogEntryRepository;
import org.tothought.data.repositories.StackOverflowAnswerRepository;
import org.tothought.data.repositories.TagRepository;
import org.tothought.web.spring.jobs.abstracts.AbstractDataLoadJob;
import org.tothought.web.stackoverflow.StackOverflowService;

@Service
@Transactional
public class StackOverflowJob extends AbstractDataLoadJob {

	private static final String JOB_NAME = "STACKOVERFLOW";

	Logger logger = LoggerFactory.getLogger(StackOverflowJob.class);

	@Autowired
	RecentDataLoadLogEntryRepository recentDataLoadRepo;

	@Autowired
	TagRepository tagRepository;

	@Autowired
	StackOverflowAnswerRepository answerRepository;

	@Scheduled(fixedDelay = 604800000)
	public void perform() {
		super.logJobStarted(JOB_NAME);

		StackOverflowService stackOverflowService = new StackOverflowService();

		Date dataCurrentDate = this.getDataCurrentDate();
		
		logger.info("Data current date for Stack Overflow job  is " + dataCurrentDate.toString());
		super.logRetreivalDate(JOB_NAME, dataCurrentDate);

		List<StackOverflowAnswer> answers = stackOverflowService.findAllAnswers(dataCurrentDate, new Date());
		this.setTags(answers);

		answerRepository.save(answers);

		super.logJobAndNotify(JOB_NAME, answers.size(), this.getMostRecentDate(answers));
	}

	private void setTags(List<StackOverflowAnswer> answers) {
		if (logger.isInfoEnabled()) {
			logger.info("Matching Stackoverflow tags with local tags");
		}

		for (StackOverflowAnswer answer : answers) {
			List<Tag> tags = new ArrayList<Tag>();
			for (Tag tag : answer.getTags()) {
				List<Tag> tmpTags = tagRepository.findByName(tag.getName());
				if (tag != null) {
					tags.addAll(tmpTags);
					logger.info("StackOverflow Tag: " + tag.getName() + " matches " + tmpTags.size()
							+ " local tags.");
				}
			}
			answer.setTags(tags);
		}

		logger.info("Stackoverflow local tag matches complete");
	}

	/**
	 * Returns the most recent answer date
	 * 
	 * @param answers
	 * @return
	 */
	private Date getMostRecentDate(List<StackOverflowAnswer> answers) {
		Collections.sort(answers, new Comparator<StackOverflowAnswer>() {
			public int compare(StackOverflowAnswer answer1, StackOverflowAnswer answer2) {
				return answer1.getCreatedDt().compareTo(answer2.getCreatedDt()) * -1; // descending
																						// sort
			}
		});
		
		return (answers.isEmpty()) ? super.getDataCurrentDate(JOB_NAME):answers.get(0).getCreatedDt();
	}

	/**
	 * Returns the date of the most current StackOverflow Answer in the database
	 * or a date prior to StackOverflows creation if null.
	 * 
	 * @return
	 */
	private Date getDataCurrentDate() {
		Date dataCurrentDate = super.getDataCurrentDate(JOB_NAME);

		// First data load start from the 2000 prior to StackOverflow Creation
		if (dataCurrentDate == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(2011, 0, 1);
			dataCurrentDate = calendar.getTime();
		}

		return dataCurrentDate;
	}

}
