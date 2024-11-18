import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> caches = new ArrayList<>();
        
        // cacheSize == 0, 모두 캐시미스
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String city : cities) {
            
            city = city.toLowerCase();
            
            // cache miss
            if (!caches.contains(city)) {
                answer += 5;
                
                if (caches.size() >= cacheSize) {
                    caches.remove(0);
                }
                
                caches.add(city);
                continue;
            }
            
            // cache hit
            if (caches.contains(city)) {
                answer += 1;
                caches.remove(city);
                caches.add(city);
            }
        }
        
        return answer;
    }
}