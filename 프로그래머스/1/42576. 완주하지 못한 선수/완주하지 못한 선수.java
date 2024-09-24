import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        return map.entrySet()
            .stream()
            .filter(e -> e.getValue() > 0)
            .findFirst()
            .map(e -> e.getKey())
            .orElse(null);
            
    }
}