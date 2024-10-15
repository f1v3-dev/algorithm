import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        
        for (String comp : completion) {
            Integer count = map.get(comp);
            
            if (count == 1) {
                map.remove(comp);
            } else {
                map.put(comp, map.get(comp) - 1);
            }
        }
        
        return map.keySet()
            .stream()
            .findFirst()
            .orElse("");
    }
}