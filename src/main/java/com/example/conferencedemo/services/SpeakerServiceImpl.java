package com.example.conferencedemo.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.conferencedemo.models.Speaker;
import com.example.conferencedemo.models.SpeakerJson;
import com.example.conferencedemo.repositories.SpeakerRepository;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository speakerRepository;
    
    private ModelMapper mapper = new ModelMapper();  

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
			speakerJson = mapper.map(speaker, SpeakerJson.class);
        }
        return speakerJson;
    }

    @Override
    public List<SpeakerJson> getSpeakerList() {
        List<SpeakerJson> speakerList = new ArrayList<>();
        speakerRepository.findAll().forEach(speaker -> speakerList.add(mapper.map(speaker, SpeakerJson.class)));
        return speakerList;
    }

    @Override
    public SpeakerJson addSpeaker(SpeakerJson speakerJson) {
        Speaker speaker = speakerRepository.save(mapper.map(speakerJson, Speaker.class));
        return mapper.map(speaker, SpeakerJson.class);
    }
}
