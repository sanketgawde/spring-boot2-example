package com.example.conferencedemo.controllers;

import com.example.conferencedemo.services.SpeakerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.conferencedemo.models.SpeakerJson;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakerController {

    private SpeakerService speakerService;

    SpeakerController(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    @GetMapping
    public List<SpeakerJson> list() {
        return speakerService.getSpeakerList();
    }

    @GetMapping
    @RequestMapping("{id}")
    public SpeakerJson getSpeaker(@PathVariable Long id) {
        return speakerService.getSpeaker(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SpeakerJson create(@RequestBody final SpeakerJson speakerJson) {
        return speakerService.addSpeaker(speakerJson);
    }

    /*@RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        speakerService.deleteById(id);
    }*/

    /*@RequestMapping(value="{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody SpeakerJson speaker) {
        SpeakerJson existingSpeaker=speakerService.(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerService.saveAndFlush(existingSpeaker);
    }*/
}
