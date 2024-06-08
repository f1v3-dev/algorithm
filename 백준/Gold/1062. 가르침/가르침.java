import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int k;
    static String[] arr;
    static boolean[] alpha = new boolean[26];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        solve();
    }

    private static void solve() {
        // 1. 필수적으로 가져야 하는 것
        // prefix : anta, postfix : tica -> a, n, t, i, c

        if (k < 5) {
            System.out.println(0);
            return;
        }

        if (k == 26) {
            System.out.println(n);
            return;
        }

        setDefaultAlpha();
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int alphabet, int len) {

        // 2. len == k - 5 일 때, 만들 수 있는 단어 개수 세기
        if (len == k - 5) {
            int count = 0;

            for (int i = 0 ; i < n; i++) {
                String word = arr[i];
                word = word.substring(4, word.length() - 4);

                // word를 만들 때 필요한 알파벳이 있는지 확인
                boolean flag = true;
                for (int j = 0; j < word.length(); j++) {
                    if (!alpha[word.charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    count++;
                }
            }

            // 최대값 갱신
            answer = Math.max(answer, count);
            return;
        }

        // backtracking
        for (int i = alphabet; i < 26; i++) {
            if (!alpha[i]) {
                alpha[i] = true;
                backtracking(i, len + 1);
                alpha[i] = false;
            }
        }
    }


    private static void setDefaultAlpha() {
        alpha['a' - 'a'] = true;
        alpha['n' - 'a'] = true;
        alpha['t' - 'a'] = true;
        alpha['i' - 'a'] = true;
        alpha['c' - 'a'] = true;
    }
}