package com.example.conferencedemo.mappers;

import com.example.conferencedemo.models.Session;
import com.example.conferencedemo.models.SessionJson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessionMapper  {
    Session sessionJsonToSession(SessionJson sessionJson);
    SessionJson sessionToSessionJson(Session session);
}
