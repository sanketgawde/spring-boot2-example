package com.example.conferencedemo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.conferencedemo.models.Speaker;
import com.example.conferencedemo.models.SpeakerJson;

@Mapper(componentModel = "spring")
public interface SpeakerMapper {
	
	SpeakerMapper INSTANCE = Mappers.getMapper(SpeakerMapper.class);
	
	abstract Speaker speakerJsonToSpeaker(SpeakerJson speakerJson);

	SpeakerJson speakerToSpeakerJson(Speaker speaker);
}
