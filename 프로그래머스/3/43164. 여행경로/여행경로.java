import java.util.*;

class Solution {

    boolean[] visited;
    List<String> answer = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }
    
    private void dfs(String begin, String target, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            answer.add(target);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(begin)) {
                visited[i] = true;
                dfs(tickets[i][1], target + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    
}