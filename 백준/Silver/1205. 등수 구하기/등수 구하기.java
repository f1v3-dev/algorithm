import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] scores = new int[n];

        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }
        }

        if (n == p && n > 0 && newScore <= scores[n - 1]) {
            System.out.println(-1);
            return;
        }

        // 새로운 점수의 순위를 계산합니다.
        int rank = 1;
        for (int score : scores) {
            if (score > newScore) {
                rank++;
            } else {
                break;
            }
        }

        System.out.println(rank);
    }
}