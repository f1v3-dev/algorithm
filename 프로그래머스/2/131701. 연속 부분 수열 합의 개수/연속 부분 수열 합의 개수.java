import java.util.*;

class Solution {
    public int solution(int[] elements) {

        Set<Integer> set = new HashSet<>();


        for (int element : elements) {
            set.add(element);
        }

        for (int size = 2; size <= elements.length; size++) {

            // 원형 수열의 연속 부분 수열 합으로 만들 수 있는 개수

            for (int i = 0; i < elements.length; i++) {

                int sum = 0;

                for (int j = i; j < i + size; j++) {
                    sum += elements[j % elements.length];
                }

                set.add(sum);
            }
        }

        return set.size();
    }
}