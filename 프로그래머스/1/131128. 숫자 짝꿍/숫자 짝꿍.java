import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();
        
        for (char ch : X.toCharArray()) {
            xMap.put(ch, xMap.getOrDefault(ch, 0) + 1);
        }
        
        for (char ch : Y.toCharArray()) {
            yMap.put(ch, yMap.getOrDefault(ch, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character ch : xMap.keySet()) {
            if (yMap.containsKey(ch)) {
                int count = Math.min(xMap.get(ch), yMap.get(ch));
                sb.append(ch.toString().repeat(count));
            }
        }
        
        if (sb.length() == 0) {
            return "-1";
        }
        
        String[] split = sb.toString().split("");
        Arrays.sort(split, Comparator.reverseOrder());
        
        if (split[0].equals("0")) {
            return "0";
        }
        
        return String.join("", split);
    }
}