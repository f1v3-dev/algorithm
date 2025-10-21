import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

class Solution {
    public int solution(int n, Function<Integer, String> submit) {
        List<String> candidates = generateCandidates();

        while (candidates.size() > 1) {

            String guess = candidates.get(0);
            String result = submit.apply(Integer.parseInt(guess));

            if (result.equals("4S 0B")) {
                return Integer.parseInt(guess);
            }

            candidates = filterCandidates(candidates, guess, result);
        }

        return Integer.parseInt(candidates.get(0));
    }

    private List<String> generateCandidates() {
        List<String> result = new LinkedList<>();

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) continue;

                for (int k = 1; k <= 9; k++) {
                    if (i == k || j == k) continue;

                    for (int l = 1; l <= 9; l++) {
                        if (i == l || j == l || k == l) continue;
                        result.add("" + i + j + k + l);
                    }
                }
            }
        }

        return result;
    }

    private List<String> filterCandidates(List<String> candidates, String guess, String expectedResult) {
        List<String> filtered = new LinkedList<>();

        for (String candidate : candidates) {
            if (compare(candidate, guess).equals(expectedResult)) {
                filtered.add(candidate);
            }
        }

        return filtered;
    }

    private String compare(String answer, String guess) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 4; i++) {
            char guessChar = guess.charAt(i);
            char answerChar = answer.charAt(i);
            if (answerChar == guessChar) {
                strike++;
            } else if (answer.indexOf(guessChar) != -1) {
                ball++;
            }
        }

        return strike + "S " + ball + "B";
    }
}
