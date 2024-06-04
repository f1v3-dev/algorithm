import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 1번 수포자 : 1, 2, 3, 4, 5 반복
        // 2번 수포자 : 2, 1, 2, 3, 2, 4, 2, 5 반복
        // 3번 수포자 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 반복

        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3]; // 각 수포자가 맞힌 문제 수를 저장할 배열

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) {
                score[0]++;
            }
            if (answers[i] == second[i % second.length]) {
                score[1]++;
            }
            if (answers[i] == third[i % third.length]) {
                score[2]++;
            }
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxScore) {
                list.add(i + 1);
            }
        }

        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
