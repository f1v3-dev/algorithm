import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void calc(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            max = Math.max(max, numbers[i]);
            min = Math.min(min, numbers[i]);
        }

        System.out.println(min + " " + max);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int size = Integer.parseInt(br.readLine());
            int[] numbers = new int[size];

            String[] str = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                numbers[j] = Integer.parseInt(str[j]);
            }
            calc(numbers);
        }
    }
}