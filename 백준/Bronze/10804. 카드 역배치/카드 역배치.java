import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int[] arr = new int[20];

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 20; i++) {
            arr[i] = i + 1;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            shuffle(start - 1, end - 1);
        }

        Arrays.stream(arr)
                .forEach(item -> System.out.print(item + " "));
    }

    public static void shuffle(int start, int end) {

        for (int i = start; i < end; i++) {
            int temp = arr[end];
            arr[end] = arr[i];
            arr[i] = temp;

            end--;
        }
    }
}