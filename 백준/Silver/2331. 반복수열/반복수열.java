import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);

        solve(a, p);

    }

    private static void solve(int a, int p) {
        List<Integer> list = new ArrayList<>();
        list.add(a);

        dfs(a, p, list);
    }

    private static void dfs(int a, int p, List<Integer> list) {
        int next = 0;
        while (a > 0) {
            next += Math.pow(a % 10, p);
            a /= 10;
        }

        if (list.contains(next)) {
            int count = 0;
            for (Integer num : list) {
                if (num != next) {
                    count++;
                } else {
                    break;
                }
            }

            System.out.println(count);
            return;
        }

        list.add(next);
        dfs(next, p, list);
    }

}