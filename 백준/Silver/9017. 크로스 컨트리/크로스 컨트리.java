import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, List<Integer>> map = new HashMap<>();
            String[] split = br.readLine().split(" ");
            solve(n, map, split);
        }
    }

    private static void solve(int n, Map<Integer, List<Integer>> map, String[] str) {

        int[] team = new int[201];
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(str[i]);
            team[key]++;
        }

        // team 에서 value가 6이 넘는
        int score = 1;

        for (String s : str) {
            int key = Integer.parseInt(s);
            if (team[key] == 6) {
                if (map.containsKey(key)) {
                    map.get(key).add(score);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(score);
                    map.put(key, list);
                }

                score++;
            }
        }

        int minScore = Integer.MAX_VALUE;
        int winner = -1;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

            List<Integer> scores = entry.getValue();
            if (scores.size() != 6) continue;

            int teamScore = scores.get(0) + scores.get(1) + scores.get(2) + scores.get(3);

            if (teamScore < minScore) {
                minScore = teamScore;
                winner = entry.getKey();
            } else if (teamScore == minScore) {
                int cur5 = scores.get(4);
                int winner5 = map.get(winner).get(4);
                if (cur5 < winner5) {
                    winner = entry.getKey();
                }
            }
        }

        System.out.println(winner);
    }
}