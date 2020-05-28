package com.example.conferencedemo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.conferencedemo.models.SessionJson;
import com.example.conferencedemo.services.SessionService;

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
