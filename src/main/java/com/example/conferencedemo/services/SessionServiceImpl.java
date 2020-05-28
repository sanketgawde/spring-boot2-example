package com.example.conferencedemo.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.conferencedemo.models.Session;
import com.example.conferencedemo.models.SessionJson;
import com.example.conferencedemo.repositories.SessionRepository;

@Service
public class SessionServiceImpl implements SessionService {

	private SessionRepository sessionRepository;

	private ModelMapper mapper = new ModelMapper();  

	SessionServiceImpl(SessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
	}

	@Override
	public SessionJson getSession(Long sessionId) {
		Session session = null;
		SessionJson sessionJson = null;
		if (sessionRepository.findById(sessionId).isPresent()) {
			session = sessionRepository.findById(sessionId).get();
		}
		if (session != null) {
			sessionJson = mapper.map(session, SessionJson.class);
		}
		return sessionJson;
	}

	@Override
	public List<SessionJson> getSessionList() {
		List<SessionJson> sessionList = new ArrayList<>();
		sessionRepository.findAll().forEach(
				session -> sessionList.add(mapper.map(session, SessionJson.class)));
		return sessionList;
	}

	@Override
	public SessionJson addSession(SessionJson sessionJson) {
		Session session = sessionRepository.save(mapper.map(sessionJson, Session.class));
		return mapper.map(session, SessionJson.class);
	}
}
