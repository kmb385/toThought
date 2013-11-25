package org.tothought.data.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THOUGHT")
public class Thought {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "THOUGHT_ID")
	private Integer thoughtId;

	@Column(name = "TEXT")
	private String text;

	@Column(name = "CREATED_DT")
	private Date createdDt;

	public Integer getThoughtId() {
		return thoughtId;
	}

	public void setThoughtId(Integer thoughtId) {
		this.thoughtId = thoughtId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

}
