package com.example.conferencedemo.mappers;

import com.example.conferencedemo.models.Speaker;
import com.example.conferencedemo.models.SpeakerJson;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper
public interface SpeakerMapper {

    Speaker speakerJsonToSpeaker(SpeakerJson speakerJson,  @Context AvoidCyclicMapping context);

    SpeakerJson speakerToSpeakerJson(Speaker speaker,  @Context AvoidCyclicMapping context);
}
