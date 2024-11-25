import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {

        long target = 0;
        Deque<Long> q1 = new LinkedList<>();
        Deque<Long> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.offer((long) queue1[i]);
            q2.offer((long) queue2[i]);

            target += queue1[i] + queue2[i];
        }

        if (target % 2 != 0) {
            return -1;
        }

        target /= 2;
        int answer = 0;

        long total = 0;
        for (int i = 0; i < q1.size(); i++) {
            total += q1.peek();
            q1.offer(q1.poll());
        }

        while (answer <= queue1.length * 3 - 3) {

            // 양쪽 큐의 합이 같은 경우
            if (total == target) {
                break;
            } else if (total > target) {
                Long poll = q1.pollFirst();
                q2.offer(poll);
                total -= poll;
                answer++;
            } else {
                Long poll = q2.pollFirst();
                q1.offer(poll);
                total += poll;
                answer++;
            }
        }

        if (total != target) {
            return -1;
        }

        return answer;
    }
}