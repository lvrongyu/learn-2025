// RunCucumberTest.java
package com.at.gz.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/resources/features",
    glue = "com.example.demo.steps",
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunCucumberTest {
}