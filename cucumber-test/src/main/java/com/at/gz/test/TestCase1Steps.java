package com.at.gz.test;

import com.at.gz.DatabaseService;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase1Steps implements En {

    @Autowired
    private DatabaseService databaseService;

    private String userId;
    private String actualUserName;
    private Scenario scenario;
    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    public TestCase1Steps() {

        Given("a user with ID {string}", (String id) -> {
            scenario.log("user id is " + id);
            this.userId = id;
        });

        When("I request the user's name", () -> {
            scenario.log("I request the user's name ");
            this.actualUserName = databaseService.getUserName(userId);
        });

        Then("the response should be {string}", (String expectedUserName) -> {
            scenario.log("the response should be: "+expectedUserName);
            assertEquals(expectedUserName, actualUserName);
        });
    }
}
