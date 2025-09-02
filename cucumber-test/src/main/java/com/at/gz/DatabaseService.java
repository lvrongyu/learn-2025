// DatabaseService.java
package com.at.gz;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class DatabaseService {
    
    private Map<String, String> mockDatabase = new HashMap<>();
    
    public DatabaseService() {
        // 初始化模拟数据
        mockDatabase.put("user1", "John Doe");
        mockDatabase.put("user2", "Jane Smith");
    }
    
    public String getUserName(String userId) {
        return mockDatabase.getOrDefault(userId, "Unknown User");
    }
    
    public boolean saveUser(String userId, String userName) {
        mockDatabase.put(userId, userName);
        return true;
    }
}