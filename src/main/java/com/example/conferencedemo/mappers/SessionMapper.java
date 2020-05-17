package com.example.conferencedemo.mappers;

import com.example.conferencedemo.models.Session;
import com.example.conferencedemo.models.SessionJson;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper
public interface SessionMapper  {

    Session sessionJsonToSession(SessionJson sessionJson, @Context AvoidCyclicMapping context);

    SessionJson sessionToSessionJson(Session session, @Context AvoidCyclicMapping context);
}
