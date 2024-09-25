import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            int[] command = commands[i];
            answer[i] = findNumber(array, command);
        }

        return answer;
    }

    private int findNumber(int[] array, int[] command) {
        int start = command[0] - 1;
        int end = command[1];
        int pivot = command[2] - 1;

        int[] temp = Arrays.copyOfRange(array, start, end);
        Arrays.sort(temp);

        return temp[pivot];
    }
}