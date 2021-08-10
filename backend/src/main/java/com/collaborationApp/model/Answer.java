package com.collaborationApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 
 * @author kabilsingh.balan
 *
 */
@Entity
@Table(name = "ANSWER")
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int answerId;

	private String text;

	@ManyToOne
	@JsonIgnore
	private Question question;

	@Column(name = "answer_order")
	private Integer order;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
}
