package org.acme.citysuggestions;

import org.acme.citysuggestions.controllers.CitySuggestController;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CitySuggestionsApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(CitySuggestionsApplicationTests.class);

    @Autowired
    private CitySuggestController controller;


    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    /**
     * Test the controller with a query that matches a city name
     */
    @Test
    void getSuggestion() {
        var result = controller.suggestions("L0nd0n", null, null);

        assertThat(result).isNotNull();

        // Result should be 10
        assertThat(result.size()).isEqualTo(10);

        // London should be the first result
        assertThat(result.get(0).getName()).containsIgnoringCase("London");
    }

    @Test
    void getSuggestionWithLocation() {
        // Worst name but exact location params
        var result = controller.suggestions("Laydon", "37.12898", "-84.08326");

        assertThat(result).isNotNull();

        // Result should be 10
        assertThat(result.size()).isEqualTo(10);

        // London should be the first result
        assertThat(result.get(0).getName()).containsIgnoringCase("London");
    }

}
