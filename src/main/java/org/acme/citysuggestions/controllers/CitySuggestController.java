package org.acme.citysuggestions.controllers;

import org.acme.citysuggestions.models.City;
import org.acme.citysuggestions.repositories.CityRepository;
import org.acme.citysuggestions.services.StringSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CitySuggestController {

    @Autowired
    CityRepository repository;

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
