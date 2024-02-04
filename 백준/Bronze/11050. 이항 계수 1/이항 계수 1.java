import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        System.out.println(factorial(n) / (factorial(n - k) * factorial(k)));
    }


    public static int factorial(int num) {

        if (num <= 1) {
            return 1;
        }

        return num * factorial(num - 1);
    }
}