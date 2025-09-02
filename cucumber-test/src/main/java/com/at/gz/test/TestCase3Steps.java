// TestCase2Steps.java
package com.at.gz.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import com.at.gz.DatabaseService;

import static org.junit.jupiter.api.Assertions.*;

public class TestCase3Steps {
    
    @Autowired
    private DatabaseService databaseService;
    
    private String userId;
    private String userName;
    private boolean saveResult;
    
    @Given("I want to save a user with ID {string} and name {string}")
    public void i_want_to_save_a_user_with_id_and_name(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
    
    @When("I save the user to the database")
    public void i_save_the_user_to_the_database() {
        this.saveResult = databaseService.saveUser(userId, userName);
    }
    
    @Then("the operation should be successful")
    public void the_operation_should_be_successful() {
        assertTrue(saveResult);
        
        // Verify the user was actually saved
        String savedName = databaseService.getUserName(userId);
        assertEquals(userName, savedName);
    }
}