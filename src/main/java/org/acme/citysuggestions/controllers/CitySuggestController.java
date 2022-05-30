package org.acme.citysuggestions.controllers;

import org.acme.citysuggestions.models.City;
import org.acme.citysuggestions.repositories.CityRepository;
import org.acme.citysuggestions.services.StringSimilarity;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CitySuggestController {

    private static final Logger LOGGER = Logger.getLogger(CitySuggestController.class);

    @Autowired
    CityRepository repository;

    /**
     * @param query     the query to search for a city
     * @param latitude  the latitude of the city
     * @param longitude the longitude of the city
     * @return the city name
     */
    @GetMapping("/suggestions")
    public List<City> suggestions(@RequestParam(name = "q") String query,
                                  @RequestParam(required = false) String latitude,
                                  @RequestParam(required = false) String longitude) {

        List<City> cities = repository.findAll();

        cities = cities.stream().map(city -> {
                    List<Double> scores = new ArrayList<>();

                    scores.add(StringSimilarity.score(city.getName(), query));

                    if (latitude != null && !latitude.isBlank())
                        scores.add(StringSimilarity.score(city.getLatitude(), latitude));

                    if (longitude != null && !longitude.isBlank())
                        scores.add(StringSimilarity.score(city.getLongitude(), longitude));

                    var total_score = scores.stream().mapToDouble(Double::doubleValue).sum() / scores.size();

                    city.setScore(total_score);

                    return city;
                }).sorted(Comparator.comparingDouble(City::getScore).reversed())
                .limit(10).collect(Collectors.toList());

        return cities;
    }

}
