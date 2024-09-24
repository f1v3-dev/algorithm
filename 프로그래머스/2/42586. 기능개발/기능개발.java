import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> counts = new ArrayList<>();


        Queue<Integer> queue = new LinkedList<>();
        for (int progress : progresses) {
            queue.offer(progress);
        }

        int index = 0;
        while (!queue.isEmpty()) {

            Integer current = queue.poll();
            int count = 1;
            int day = 0;
            int speed = speeds[index];

            while (current < 100) {
                day++;
                current += speed;
            }

            // 다음 인덱스로 이동
            index++;

            while (!queue.isEmpty()) {
                Integer peek = queue.peek();
                int nextProgress = peek + (day * speeds[index]);
                if (nextProgress >= 100) {
                    queue.poll();
                    index++;
                    count++;
                    continue;
                }

                break;
            }

            counts.add(count);
        }

        return counts.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}