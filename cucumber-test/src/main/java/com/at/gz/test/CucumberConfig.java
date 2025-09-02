// CucumberConfig.java
package com.at.gz.test;

import com.at.gz.DemoApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = DemoApplication.class
//        ,
//        webEnvironment = SpringBootTest.WebEnvironment.NONE,
//        properties = {
//        "spring.jmx.enabled=false"
//}
)public class CucumberConfig {
}