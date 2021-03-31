package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whisky")
    public ResponseEntity<List<Whisky>> getAllWhiskies() {
        return  new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whisky/year")
    public ResponseEntity <List<Whisky>> findWhiskyByYear(
        @RequestParam(name = "year") int year
    ) {
        return  new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whisky/distillery/age")
    public ResponseEntity <List<Whisky>> findWhiskyByAgeAndDistilleryName(
            @RequestParam(name = "age") int age,
            @RequestParam(name = "name") String name
    ){
        return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByAgeAndDistilleryName(age, name), HttpStatus.OK);
    }

    @GetMapping(value ="/whisky/distillery/region")
    public ResponseEntity <List<Whisky>> findWhiskyByDistilleryRegion(
            @RequestParam(name = "region") String region
    ){
        return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
    }





}
