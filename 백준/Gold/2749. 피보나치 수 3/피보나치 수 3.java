import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] fibo = new long[1_500_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // m > 2라면, k(10^m) = 15×10(m-1)
        // m = 1_000_000

        int period = 15 * (int) Math.pow(10, 6 - 1);

        long n = Long.parseLong(br.readLine()) % period;

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= period; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1_000_000;
        }

        System.out.println(fibo[(int) n]);
    }

}