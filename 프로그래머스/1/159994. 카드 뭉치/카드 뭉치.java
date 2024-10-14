import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> firstQueue = new LinkedList<>();
        Queue<String> secondQueue = new LinkedList<>();
        
        for (String card : cards1) {
            firstQueue.offer(card);
        }
        
        for (String card : cards2) {
            secondQueue.offer(card);
        }
        
        String answer = "Yes";
        
        for (String word : goal) {
            
            if (word.equals(firstQueue.peek())) {
                firstQueue.poll();
                continue;
            } else if (word.equals(secondQueue.peek())) {
                secondQueue.poll();
                continue;
            } else {
                answer = "No";
                break;
            }
        }
    
        return answer;
    }
}