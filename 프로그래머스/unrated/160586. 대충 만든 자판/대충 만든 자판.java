import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        // HashMap에 각 알파벳 별 최솟값을 넣기
        HashMap<Character, Integer> hashMap = new HashMap<>();
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                if (!hashMap.containsKey(ch) || i < hashMap.get(ch)){
                    hashMap.put(ch, i + 1);
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++){
            int count = 0;
            for (int j = 0; j < targets[i].length(); j++){
                char ch = targets[i].charAt(j);
                if (hashMap.containsKey(ch)) {
                    count += hashMap.get(ch);
                } else {
                    count = 0;
                    break;  
                } 
            }
            if (count != 0) {
                answer[i] = count;
            } else {
                answer[i] = -1;
            }
        }
        
        
        return answer;
    }
}