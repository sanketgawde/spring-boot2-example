package com.example.conferencedemo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "sessions")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long session_id;
	private String session_name;
	private String session_description;
	private Integer session_length;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "session_speakers", joinColumns = @JoinColumn(name = "session_id"), inverseJoinColumns = @JoinColumn(name = "speaker_id"))
	private List<Speaker> speakers;

	public Session() {
	}

	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}

	public Long getSession_id() {
		return session_id;
	}

	public String getSesssion_name() {
		return session_name;
	}

	public String getSession_description() {
		return session_description;
	}

	public Integer getSession_length() {
		return session_length;
	}

	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}

	public void setSesssion_name(String sesssion_name) {
		this.session_name = sesssion_name;
	}

	public void setSession_description(String session_description) {
		this.session_description = session_description;
	}

	public void setSession_length(Integer session_length) {
		this.session_length = session_length;
	}
}
