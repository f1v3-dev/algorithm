import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(numbers[i]);
            sum += (int) Math.pow(num, 2);
        }

        System.out.println(sum % 10);
    }
}