import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                String[] str = br.readLine().split(" ");
                String cmd = str[0];
                int val = Integer.parseInt(str[1]);

                switch (cmd) {
                    case "I":
                        tm.put(val, tm.getOrDefault(val, 0) + 1);
                        break;

                    case "D":
                        if (tm.isEmpty()) {
                            continue;
                        }
                        // D 1 : 최댓값, D -1 : 최솟값
                        int key = val == 1 ? tm.lastKey() : tm.firstKey();

                        // 중복된 키가 여러개인 경우가 있을 수 있음
                        int dupCount = tm.get(key);
                        if (dupCount == 1) {
                            tm.remove(key);
                        } else {
                            // 같은 값이 존재 할 경우 덮어씌우기
                            tm.put(key, dupCount - 1);
                        }
                }
            }
            if (tm.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                // 최댓값 최솟값 출력
                sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}