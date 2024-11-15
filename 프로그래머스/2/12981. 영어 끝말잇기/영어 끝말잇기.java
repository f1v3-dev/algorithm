import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        Set<String> wordSet = new HashSet<>();
        String prev = words[0];
        wordSet.add(prev);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];

            // 이미 등장한 단어이거나, 이전 단어의 끝과 시작 문자가 다르면
            if (wordSet.contains(word) || prev.charAt(prev.length() - 1) != word.charAt(0)) {
                // 몇 번째 사람이 몇 번째 차례에 탈락하는지 계산
                int person = (i % n) + 1;
                int time = (i / n) + 1;

                return new int[]{person, time};
            }

            wordSet.add(word);
            prev = word;
        }

        return new int[]{0, 0};
    }
}
