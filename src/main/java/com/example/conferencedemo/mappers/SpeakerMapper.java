package com.example.conferencedemo.mappers;

import com.example.conferencedemo.models.Speaker;
import com.example.conferencedemo.models.SpeakerJson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpeakerMapper {
    Speaker speakerJsonToSpeaker(SpeakerJson speakerJson);
    SpeakerJson speakerToSpeakerJson(Speaker speaker);
}
