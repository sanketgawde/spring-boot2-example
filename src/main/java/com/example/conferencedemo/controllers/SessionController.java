package com.example.conferencedemo.controllers;

import com.example.conferencedemo.models.Session;
import com.example.conferencedemo.models.SessionJson;
import com.example.conferencedemo.repositories.SessionRepository;
import com.example.conferencedemo.services.SessionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions")
public class SessionController {
    private SessionService sessionService;

    SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public List<SessionJson> list() {
        return sessionService.getSessionList();
    }

    @GetMapping
    @RequestMapping("{id}")
    public SessionJson getSession(@PathVariable Long id) {
        return sessionService.getSession(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SessionJson create(@RequestBody final SessionJson sessionJson) {
        return sessionService.addSession(sessionJson);
    }
}

