package com.example.conferencedemo.services;

import com.example.conferencedemo.models.SpeakerJson;
import java.util.List;


public interface SpeakerService {

    SpeakerJson getSpeaker(Long speakerId);

    List<SpeakerJson> getSpeakerList();

    SpeakerJson addSpeaker(SpeakerJson speakerJson);
}
