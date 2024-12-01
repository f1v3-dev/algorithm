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

        StringBuilder sb = new StringBuilder();

        sb.append("0".repeat(zero));
        sb.append("1".repeat(one));

        System.out.println(sb);
    }
}