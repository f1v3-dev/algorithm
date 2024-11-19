import java.util.*;

class Solution {

    static char[] alphabets = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {

        List<String> words = new ArrayList<>();
        init("", words);

        return words.indexOf(word);
    }

    private void init(String word, List<String> words) {

        words.add(word);

        if (word.length() == 5) {
            return;
        }

        for (char alphabet : alphabets) {
            init(word + alphabet, words);
        }
    }
}