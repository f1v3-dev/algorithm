import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static Map<Integer, Integer> countMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            countMap.put(b, countMap.get(b) + 1);
        }

        solve();
    }

    private static void solve() {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (countMap.get(i) == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            sb.append(current).append(" ");

            int size = map.get(current).size();
            for (int i = 0; i < size; i++) {
                int next = map.get(current).get(i);

                countMap.put(next, countMap.get(next) - 1);

                if (countMap.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(sb);
    }

    private static void init() {

        for (int i = 0; i <= n; i++) {
            map.put(i, new ArrayList<>());
            countMap.put(i, 0);
        }
    }
}