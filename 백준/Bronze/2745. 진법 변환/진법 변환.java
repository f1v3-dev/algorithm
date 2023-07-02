import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        String N = str[0];
        int B = Integer.parseInt(str[1]);

        // B진법 기준으로 각각의 자리수마다 B를 곱해준다
        int len = 1;
        int sum = 0;

        for (int i = N.length() - 1; i >= 0; i--) {
            char ch = N.charAt(i);

            if ('A' <= ch && ch <= 'Z') {
                sum += ((ch - 'A') + 10) * len;
            }
            else {
                sum += (ch - '0') * len;
            }
            len *= B;
        }

        System.out.println(sum);
    }
}