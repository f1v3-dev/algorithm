import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Map<String, Integer>> table = new HashMap<>();
        Map<String, Integer> point = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        
        // Map 초기화
        for (String friend : friends) {
            table.put(friend, new HashMap<>());
            point.put(friend, 0);
            result.put(friend, 0);
        }
        
        for (int i = 0; i < friends.length; i++) {
            
            Map<String, Integer> hm = table.get(friends[i]);
            
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                hm.put(friends[j], 0);
            }
        }
        
        // Gifts를 통해 선물 지수 파악
        for (String gift : gifts) {
            String[] input = gift.split(" ");
            
            String giver = input[0];
            String receiver = input[1];
            
            point.put(giver, point.getOrDefault(giver, 0) + 1);
            point.put(receiver, point.getOrDefault(receiver, 0) - 1);
            
            // 준 사람 기준에서 선물 받은 사람 카운트 세기
            Map<String, Integer> giverMap = table.get(giver);
            giverMap.put(receiver, giverMap.getOrDefault(receiver, 0) + 1);
        }
        
        // 자신을 기준으로 선물을 주고 받은걸 계산
        for (int i = 0; i < friends.length; i++) {
            String giver = friends[i];
            Map<String, Integer> giverMap = table.get(giver);
            
            for (int j = i + 1; j < friends.length; j++) {
                String receiver = friends[j];
                Map<String, Integer> receiverMap = table.get(receiver);
                
                // 선물 준 사람 -> 받은 사람 count
                // 받은 사람 -> 준 사람 count
                int giverGiftCount = giverMap.get(receiver);
                int receiverGiftCount = receiverMap.get(giver);
                
                // 더 많이 선물을 준 사람이 result + 1
                if (giverGiftCount > receiverGiftCount) {
                    result.put(giver, result.getOrDefault(giver, 0) + 1);
                } else if (giverGiftCount < receiverGiftCount) {
                    result.put(receiver, result.getOrDefault(receiver, 0) + 1);
                } else {
                    // 둘의 기록이 같다면 선물 지수를 기준으로
                    int giverPoint = point.get(giver);
                    int receiverPoint = point.get(receiver);
                    
                    if (giverPoint > receiverPoint) {
                        result.put(giver, result.getOrDefault(giver, 0) + 1);
                    } else if (giverPoint < receiverPoint) {
                        result.put(receiver, result.getOrDefault(receiver, 0) + 1);
                    }
                    
                    // 선물 지수도 같다면 처리 X
                }
            }
        }
        
        
        // 가장 많은 선물을 받는 친구 찾기
        int max = 0;
        for (int value : result.values()) {
            max = Math.max(max, value);
        }
        
        return max;
    }
}