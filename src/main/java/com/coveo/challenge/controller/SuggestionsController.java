package com.coveo.challenge.controller;

import com.coveo.challenge.model.Suggestions;
import com.coveo.challenge.service.SuggestionsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@Validated
public class SuggestionsController {

    @Autowired
    private SuggestionsService suggestionsService;

    @ApiOperation(
            value = "Provides suggestions for large cities"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "q", required = true, value = "Partial (or complete) search term"),
            @ApiImplicitParam(name = "latitude", value = "Latitude of caller's location"),
            @ApiImplicitParam(name = "longitude", value = "Longitude of caller's location")
    })
    @RequestMapping(value = "/suggestions", method = RequestMethod.GET)
    public ResponseEntity<Suggestions> getSuggestions(@RequestParam(value = "q") String query,
                                                      @RequestParam(value = "latitude", required = false) @Min(-90l) @Max(90l) Double latitude,
                                                      @RequestParam(value = "longitude", required =  false) @Min(-180l) @Max(180l) Double longitude) throws Exception {
        return ResponseEntity.ok(suggestionsService.call(query, latitude, longitude));
    }
}
