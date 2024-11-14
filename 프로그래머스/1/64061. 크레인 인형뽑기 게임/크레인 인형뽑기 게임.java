import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int n = board.length;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            // move 위치 y축에서 0이 아닌 애들 뽑아

            move -= 1;

            int cur = 0;

            for (int i = 0; i < n; i++) {
                if (board[i][move] != 0) {
                    cur = board[i][move];
                    System.out.println(board[i][move]);

                    board[i][move] = 0;
                    break;
                }
            }

            if (!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
                answer += 2;
            } else if (cur != 0) {
                stack.push(cur);
            }
        }

        // 남아있는 스택에서 터지는 경우

        while (true) {
            boolean flag = false;

            if (stack.size() < 2) {
                break;
            }
            
            if (stack.get(stack.size() - 1).equals(stack.get(stack.size() - 2))) {
                stack.pop();
                stack.pop();

                answer += 2;
                flag = true;
            }

            if (!flag) {
                break;
            }
        }

        return answer;
    }
}
