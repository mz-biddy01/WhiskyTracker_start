package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distillery")
    public ResponseEntity<List<Distillery>> getAllDistilleries(){
        return  new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distillery/region")
    public ResponseEntity<List<Distillery>> getAllDistilleriesByRegion(
        @RequestParam(name = "region") String region
    ) {
            return  new ResponseEntity<List<Distillery>>(distilleryRepository.findDistilleryByRegion(region), HttpStatus.OK);
        }

    @GetMapping(value = "/distillery/whisky/age")
    public ResponseEntity<List<Distillery>> findDistilleriesByWhiskiesAge(
            @RequestParam(name = "age") int age
    ) {
        return new ResponseEntity<List<Distillery>>(distilleryRepository.findDistilleriesByWhiskiesAge(age), HttpStatus.OK);
    }
    }



