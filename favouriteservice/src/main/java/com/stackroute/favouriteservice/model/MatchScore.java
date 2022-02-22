package com.stackroute.favouriteservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class MatchScore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "scoreId")
	private Integer scoreId;
	@Column(name = "score")
	private String score;

	public MatchScore(Integer scoreId, String score) {
		super();
		this.scoreId = scoreId;
		this.score = score;
	}

	public MatchScore() {
		super();
	}

	public Integer getScoreId() {
		return scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}
