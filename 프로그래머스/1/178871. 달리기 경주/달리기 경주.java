import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String call : callings) {
            int current = map.get(call);
            
            int front = current - 1;
            String frontPlayer = players[front];
            
            players[front] = call;
            players[current] = frontPlayer;
            
            map.put(call, front);
            map.put(frontPlayer, current);
        }
        
        return players;
    }
}