import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static BigInteger[] fibo = new BigInteger[10_001];

    static {

        fibo[0] = BigInteger.ZERO;
        fibo[1] = BigInteger.ONE;

        for (int i = 2; i < fibo.length; i++) {
            fibo[i] = fibo[i - 1].add(fibo[i - 2]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo[n]);
    }
}