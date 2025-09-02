// TestCase1Steps.java
package com.at.gz.test;

import com.at.gz.DatabaseService;
import com.at.gz.DemoApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@CucumberContextConfiguration
@ContextConfiguration(classes = {DemoApplication.class})
public class TestCase1Steps {
    
    @Autowired
    private DatabaseService databaseService;
    
    private String userId;
    private String actualUserName;
    
    @Given("a user with ID {string}")
    public void a_user_with_id(String userId) {
        this.userId = userId;
    }
    
    @When("I request the user's name")
    public void i_request_the_user_s_name() {
        this.actualUserName = databaseService.getUserName(userId);
    }
    
    @Then("the response should be {string}")
    public void the_response_should_be(String expectedUserName) {
        assertEquals(expectedUserName, actualUserName);
    }
}