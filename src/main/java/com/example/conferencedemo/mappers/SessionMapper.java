package com.example.conferencedemo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.conferencedemo.models.Session;
import com.example.conferencedemo.models.SessionJson;

@Mapper(componentModel = "spring")
public interface SessionMapper {
	
	SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

	public abstract Session sessionJsonToSession(SessionJson sessionJson);

	public abstract SessionJson sessionToSessionJson(Session session);

}
