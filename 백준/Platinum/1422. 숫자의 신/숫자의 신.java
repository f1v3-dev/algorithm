import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int n;
    static String[] numbers;
    static int maxLength = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        numbers = new String[k];
        for (int i = 0; i < k; i++) {
            numbers[i] = br.readLine();
            if (numbers[i].length() > maxLength) {
                maxLength = numbers[i].length();
            }
        }

        solve();
    }

    private static void solve() {

        // 1. 숫자 정렬
        Arrays.sort(numbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 모든 숫자는 1번 이상 사용해야 된다.
        // 총 숫자의 길이는 n이다.
        // 따라서 n개의 숫자를 사용해야 한다.
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < k; i++) {
            String number = numbers[i];

            if (!flag && number.length() == maxLength) {
                flag = true;
                for (int j = 0; j < n - k + 1; j++) {
                    sb.append(number);
                }
            } else {
                sb.append(number);
            }
        }

        System.out.println(sb);
    }
}