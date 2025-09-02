// TestExecutorService.java
package com.at.gz.test;

import io.cucumber.core.cli.Main;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@Service
public class TestExecutorService {
    
    public String executeTest(String featureName, String tags) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        
        try {
            System.setOut(printStream);
            
            String[] args = {
                "--glue", "com.at.gz.test",
                "--tags", tags != null ? tags : "",
                "classpath:features/" + featureName + ".feature"
            };
            
            byte exitStatus = Main.run(args, Thread.currentThread().getContextClassLoader());
            
            return "Test execution completed with status: " + exitStatus + 
                   "\nOutput:\n" + outputStream.toString();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return e.getMessage();
        }

        finally {
            System.setOut(originalOut);
        }
    }
}