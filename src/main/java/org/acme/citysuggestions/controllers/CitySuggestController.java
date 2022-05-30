package org.acme.citysuggestions.controllers;

import org.acme.citysuggestions.StringSimilarity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitySuggestController {

    /**
     * @param query     the query to search for a city
     * @param latitude  the latitude of the city
     * @param longitude the longitude of the city
     * @return the city name
     */
    @GetMapping("/suggestions")
    public double suggestions(@RequestParam(name = "q") String query,
                              @RequestParam(required = false) String latitude,
                              @RequestParam(required = false) String longitude) {




        return StringSimilarity.score("43.70011", latitude);
    }

}
