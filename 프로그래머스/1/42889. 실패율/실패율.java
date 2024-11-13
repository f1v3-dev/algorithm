import java.util.*;

class Pair {
    int index;
    double value;

    public Pair(int index, double value) {
        this.index = index;
        this.value = value;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] rate = new double[N];

        // stages = 사용자가 도전중인 스테이지 번호
        for (int i = 1; i <= N; i++) {
            
            int total = 0;
            int fail = 0;

            for (int stage : stages) {
                if (stage >= i) {
                    total++;
                }

                if (stage == i) {
                    fail++;
                }
            }

            if (total == 0) {
                rate[i - 1] = 0;
            } else {
                rate[i - 1] = (double) fail / total;
            }
        }

        // rate를 기준으로 내림차순으로 정렬
        Pair[] pairs = new Pair[N];
        for (int i = 0; i < N; i++) {
            pairs[i] = new Pair(i + 1, rate[i]);
        }

        Arrays.sort(pairs, (a, b) -> {
            if (a.value == b.value) {
                return a.index - b.index;
            }

            return Double.compare(b.value, a.value);
        });


        for (int i = 0;i < N; i++) {
            answer[i] = pairs[i].index;
        }

        return answer;
    }
}