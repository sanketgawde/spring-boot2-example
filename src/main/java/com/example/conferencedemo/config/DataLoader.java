package com.example.conferencedemo.config;

import com.example.conferencedemo.models.Session;
import com.example.conferencedemo.models.Speaker;
import com.example.conferencedemo.repositories.SessionRepository;
import com.example.conferencedemo.repositories.SpeakerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final SpeakerRepository speakerRepository;
    private final SessionRepository sessionRepository;

    public DataLoader(SpeakerRepository speakerRepository, SessionRepository sessionRepository) {
        this.speakerRepository = speakerRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Session session = new Session();

        session.setSesssion_name("Asession");
        session.setSession_description("this is a session");
        session.setSession_length(5);

        Speaker speaker = new Speaker();
        List<Session> sessionList = new ArrayList<>();
        List<Speaker> speakerList = new ArrayList<>();
        speaker.setFirst_name("test 1");
        speaker.setLast_name("test 2");
        speaker.setCompany("test3");
        sessionList.add(session);
        speaker.setSessions(sessionList);

        speakerRepository.save(speaker);
        speakerList.add(speaker);
        session.setSpeakers(speakerList);
        sessionRepository.save(session);

    }
}
