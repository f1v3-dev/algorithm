import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    static Map<Character, Integer> targetMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        두 단어가 같은 구성
        한 단어에서 한 문자를 더하거나, 빼거나, 다른 문자로 바꾸어 같은 구성을 갖는 경우
         */

        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n - 1];
        String target = br.readLine();

        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            words[i] = br.readLine();
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (isSimilar(target, words[i])) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isSimilar(String target, String word) {

        if (Math.abs(target.length() - word.length()) > 1) {
            return false;
        }

        Map<Character, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            wordMap.put(ch, wordMap.getOrDefault(ch, 0) + 1);
        }

        Set<Character> keySet = new HashSet<>();
        keySet.addAll(targetMap.keySet());
        keySet.addAll(wordMap.keySet());

        int diff = 0;

        for (char key : keySet) {
            int c1 = targetMap.getOrDefault(key, 0);
            int c2 = wordMap.getOrDefault(key, 0);
            diff += Math.abs(c1 - c2);
        }

        return diff <= 2;
    }
}