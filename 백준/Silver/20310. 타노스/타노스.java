import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int zero = 0;
        int one = 0;

        for (char ch : arr) {
            if (ch == '0') {
                zero++;
            } else {
                one++;
            }
        }

        zero /= 2;
        one /= 2;

        // 1은 앞에서 지우고
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1' && one > 0) {
                one--;
                arr[i] = '2';
            }
        }

        // 0은 뒤에서부터 지운다.
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '0' && zero > 0) {
                zero--;
                arr[i] = '2';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            if (ch != '2') {
                sb.append(ch);
            }
        }

        System.out.println(sb);
    }
}