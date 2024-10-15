import java.util.*;

class Work {
    int progress;
    int speed;
    
    public Work(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> result = new ArrayList<>();
        Queue<Work> queue = new LinkedList<>();
        
        for (int i = 0; i < speeds.length; i++) {
            Work work = new Work(progresses[i], speeds[i]);
            queue.offer(work);
        }
        
        while (!queue.isEmpty()) {
            
            Work cur = queue.poll();
            int count = 1;
            int day = (int) Math.ceil((100 - cur.progress) / (double) cur.speed);
            
            while (!queue.isEmpty() &&
                  queue.peek().progress + (queue.peek().speed * day) >= 100) {
                
                count++;
                queue.poll();
            }
            
            result.add(count);
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}