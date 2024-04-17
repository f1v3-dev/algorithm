import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';

            if (num == 6 || num == 9) {
                if (arr[6] > arr[9]) {
                    arr[9]++;
                } else {
                    arr[6]++;
                }

            } else {

                arr[num]++;

            }
        }

        int max = Arrays.stream(arr)
                .max()
                .orElse(1);

        System.out.println(max);

    }
}