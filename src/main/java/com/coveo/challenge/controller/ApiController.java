package com.coveo.challenge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class ApiController {

    @RequestMapping(value = "/g", method = RequestMethod.GET)
    public ResponseEntity<String> getSuggestions(@RequestParam(value = "q") String query,
                                                 @RequestParam(value = "longitude", required =  false) Double longitude,
                                                 @RequestParam(value = "latitude", required = false) Double latitude) {
        return ResponseEntity.ok("test");
    }
}
