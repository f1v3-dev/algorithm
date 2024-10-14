import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            queue.offer(ch);
        }

        while (!queue.isEmpty()) {
            char x = queue.poll();
            int xCount = 1;
            int yCount = 0;

            while (!queue.isEmpty()) {
                char current = queue.poll();

                if (current == x) {
                    xCount++;
                } else {
                    yCount++;
                }

                if (xCount == yCount) {
                    break;
                }
            }

            answer++;
        }

        return answer;
    }
}