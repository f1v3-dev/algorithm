import java.util.*;

public class Main {

    static int N;
    static int S;
    static int cnt = 0;
    static int[] num;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        S = scanner.nextInt();
        num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = scanner.nextInt();
        }

        dfs(0, 0);

        if (S == 0) {
            cnt -= 1;
        }

        System.out.println(cnt);
    }

    static void dfs(int depth, int sum) {

        if (depth == N) {
            if (sum == S) {
                cnt++;
            }
            return;
        }

        dfs(depth + 1, sum + num[depth]);
        dfs(depth + 1, sum);
    }
}