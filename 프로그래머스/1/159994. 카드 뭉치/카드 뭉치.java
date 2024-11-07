import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        
        for (String card : cards1) {
            queue1.offer(card);
        }
        
        for (String card : cards2) {
            queue2.offer(card);
        }
        
        for (String word : goal) {
            
            if (!queue1.isEmpty() && word.equals(queue1.peek())) {
                queue1.poll();
            } else if (!queue2.isEmpty() && word.equals(queue2.peek())) {
                queue2.poll();
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}