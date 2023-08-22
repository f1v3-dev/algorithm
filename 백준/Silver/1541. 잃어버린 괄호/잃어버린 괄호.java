import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int result = Integer.MAX_VALUE;
        while (st.hasMoreTokens()) {
            int temp = 0;


            StringTokenizer add = new StringTokenizer(st.nextToken(), "+");

            while (add.hasMoreTokens()) {
                temp += Integer.parseInt(add.nextToken());
            }

            if (result == Integer.MAX_VALUE) {
                result = temp;
            } else {
                result -= temp;
            }
        }

        System.out.println(result);
    }
}