import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        HashMap<Integer, String> name = new HashMap<>();
        HashMap<String, Integer> rank = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            name.put(i, players[i]);
            rank.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {

            // 추월한 선수의 정보
            int currentRank = rank.get(callings[i]);
            String playerName = name.get(currentRank);

            // 추월을 당한 선수의 정보
            String frontPlayer = name.get(currentRank - 1);

            // 둘의 위치를 다시 put (swap)
            rank.put(playerName, currentRank - 1);
            rank.put(frontPlayer, currentRank);
            
            name.put(currentRank - 1, playerName);
            name.put(currentRank, frontPlayer);

        }
        
        for (int i = 0; i < answer.length; i++){
            answer[i] = name.get(i);
        }
        return answer;
    }
}