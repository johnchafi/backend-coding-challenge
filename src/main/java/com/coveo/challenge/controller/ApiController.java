package com.coveo.challenge.controller;

import com.coveo.challenge.model.Suggestions;
import com.coveo.challenge.service.SuggestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class ApiController {

    @Autowired
    private SuggestionsService suggestionsService;

    @RequestMapping(value = "/suggestions", method = RequestMethod.GET)
    public Suggestions getSuggestions(@RequestParam(value = "q") String query,
                                                      @RequestParam(value = "latitude", required = false) Double latitude,
                                                      @RequestParam(value = "longitude", required =  false) Double longitude) {
      return suggestionsService.search(query, latitude, longitude);
    }
}
