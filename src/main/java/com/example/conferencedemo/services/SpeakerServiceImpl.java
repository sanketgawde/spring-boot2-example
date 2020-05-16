package com.example.conferencedemo.services;

import com.example.conferencedemo.mappers.SpeakerMapper;
import com.example.conferencedemo.models.Speaker;
import com.example.conferencedemo.models.SpeakerJson;
import com.example.conferencedemo.repositories.SpeakerRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository speakerRepository;

    private SpeakerMapper  speakerMapper= Mappers.getMapper(SpeakerMapper.class);

    SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @Override
    public SpeakerJson getSpeaker(Long speakerId) {
        Speaker speaker = null;
        SpeakerJson speakerJson = null;
        if(speakerRepository.findById(speakerId).isPresent()) {
            speaker = speakerRepository.findById(speakerId).get();
        }
        if(speaker != null) {
            speakerJson = speakerMapper.speakerToSpeakerJson(speaker);
        }
        return speakerJson;
    }

    @Override
    public List<SpeakerJson> getSpeakerList() {
        List<SpeakerJson> speakerList = new ArrayList<>();
        speakerRepository.findAll().forEach(speaker -> speakerList.add(speakerMapper.speakerToSpeakerJson(speaker)));
        return speakerList;
    }

    @Override
    public SpeakerJson addSpeaker(SpeakerJson speakerJson) {
        Speaker speaker = speakerRepository.save(speakerMapper.speakerJsonToSpeaker(speakerJson));
        return speakerMapper.speakerToSpeakerJson(speaker);
    }
}
