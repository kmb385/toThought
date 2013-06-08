package org.tothought.web.stackoverflow.result;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.tothought.data.entities.StackOverflowAnswer;

public class AnswerResult extends AbstractResult {

	@JsonProperty("items")
	List<StackOverflowAnswer> answers = new ArrayList<StackOverflowAnswer>();

	public List<StackOverflowAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<StackOverflowAnswer> answers) {
		this.answers = answers;
	}
	
	
}
