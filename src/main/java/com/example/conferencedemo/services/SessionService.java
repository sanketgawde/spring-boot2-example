package com.example.conferencedemo.services;

import com.example.conferencedemo.models.SessionJson;

import java.util.List;

public interface SessionService {
    SessionJson getSession(Long sessionId);

    List<SessionJson> getSessionList();

    SessionJson addSession(SessionJson sessionJson);
}
