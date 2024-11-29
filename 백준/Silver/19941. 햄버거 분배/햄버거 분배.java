import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        char[] arr = new char[n];
        input = br.readLine().split("");

        for (int i = 0; i < n; i++) {
            arr[i] = input[i].charAt(0);
        }

        // 사람 기준으로 k만큼 앞에 있는 햄버거를 먹는다.

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                eat(arr, i, k);
            }
        }

        System.out.println(count);
    }

    private static void eat(char[] arr, int index, int reach) {

        // reach 만큼 뻗어서 먹을 수 있는 햄버거를 찾고 먹어
        for (int i = index - reach; i < index + reach + 1; i++) {

            if (i < 0 || i >= arr.length) {
                continue;
            }

            if (arr[i] == 'H') {
                arr[i] = 'X';
                count++;
                return;
            }
        }
    }
}