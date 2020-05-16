package com.example.conferencedemo.services;

import com.example.conferencedemo.mappers.SessionMapper;
import com.example.conferencedemo.models.Session;
import com.example.conferencedemo.models.SessionJson;
import com.example.conferencedemo.repositories.SessionRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private SessionRepository sessionRepository;

    private SessionMapper  sessionMapper= Mappers.getMapper(SessionMapper.class);

    SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public SessionJson getSession(Long sessionId) {
        Session session = null;
        SessionJson sessionJson = null;
        if(sessionRepository.findById(sessionId).isPresent()) {
            session = sessionRepository.findById(sessionId).get();
        }
        if(session != null) {
            sessionJson = sessionMapper.sessionToSessionJson(session);
        }
        return sessionJson;
    }

    @Override
    public List<SessionJson> getSessionList() {
        List<SessionJson> sessionList = new ArrayList<>();
        sessionRepository.findAll().forEach(session -> sessionList.add(sessionMapper.sessionToSessionJson(session)));
        return sessionList;
    }

    @Override
    public SessionJson addSession(SessionJson sessionJson) {
        Session session = sessionRepository.save(sessionMapper.sessionJsonToSession(sessionJson));
        return sessionMapper.sessionToSessionJson(session);
    }
}
