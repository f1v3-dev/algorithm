import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = progresses.length - 1; i >= 0; i--) {
            stack.push(progresses[i]);
        }

        int index = 0;
        while (!stack.isEmpty()) {
            Integer num = stack.pop();

            int count = 0;
            int result = 1;
            while (num < 100) {
                count++;
                num += speeds[index];
            }

            index++;

            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (speeds[index] * count + peek >= 100) {
                    stack.pop();
                    result++;
                    index++;
                } else {
                    break;
                }
            }

            answer.add(result);
        }

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}