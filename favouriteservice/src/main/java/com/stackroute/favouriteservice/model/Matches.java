package com.stackroute.favouriteservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matches")
public class Matches {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "matchId")
	private Integer matchId;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "score_id")
	private MatchScore matchScore;

	public Matches() {
		super();
	}

	public Matches(Integer matchId, String title, String description, MatchScore score) {
		super();
		this.matchId = matchId;
		this.title = title;
		this.description = description;
		this.matchScore = score;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public MatchScore getMatchScore() {
		return matchScore;
	}

	public void setMatchScore(MatchScore matchScore) {
		this.matchScore = matchScore;
	}

	@Override
	public String toString() {
		return "Matches [matchId=" + matchId + ", title=" + title + ", description=" + description + ", score=" + matchScore
				+ "]";
	}

}
