// TestController.java
package com.at.gz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.at.gz.test.TestExecutorService;
import java.util.Map;

@RestController
public class TestController {
    
    @Autowired
    private TestExecutorService testExecutorService;
    
    @PostMapping("/execute-test")
    public String executeTest(@RequestBody Map<String, String> request) {
        String featureName = request.get("feature");
        String tags = request.get("tags");
        
        return testExecutorService.executeTest(featureName, tags);
    }
}