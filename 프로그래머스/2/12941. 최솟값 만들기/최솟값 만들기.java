import java.util.*;

class Solution {
    public Integer solution(int[] A, int[] B) {
        Integer answer = 0;

        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }

        for (int i = 0; i < A.length; i++) {
            answer += a.poll() * b.poll();
        }

        return answer;
    }
}