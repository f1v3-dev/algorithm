import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        1. 자주 나오는 단어
        2. 단어의 길이가 길수록
        3. 알파벳 사전 순으로 앞에 있는 단어일수록
         */

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> result = new ArrayList<>(map.keySet());

        Collections.sort(result, (o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return map.get(o2) - map.get(o1);
        });

        for (String s : result) {
            bw.write(s + "\n");
        }

        bw.flush();
    }
}