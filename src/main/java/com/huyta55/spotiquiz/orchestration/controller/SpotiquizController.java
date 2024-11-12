package com.huyta55.spotiquiz.orchestration.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("api/")
public class SpotiquizController {

    private static final Logger logger = LoggerFactory.getLogger(SpotiquizController.class);

    @GetMapping("api/health/")
    public ResponseEntity<Void> getAPIHealth() {
        logger.debug("API Health = OK.");
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
