import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        // Queue 초기화
        for (int priority : priorities) {
            queue.offer(priority);
        }
        
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            boolean isBiggest = true;
            
            // 남아있는 Queue에서 비교
            for (int priority : queue) {
                if (current < priority) {
                    isBiggest = false;
                }
            }
            
            if (isBiggest) {
                answer++;
                
                // Queue의 맨 앞인 경우
                if (location == 0) {
                    break;
                }
            } else {
                queue.offer(current);
            }
            
            // location의 위치를 앞으로 이동 (맨 앞인 경우 맨 뒤로)
            location = (location == 0) ? queue.size() - 1 : location - 1;
        }
    
        return answer;
    }
}