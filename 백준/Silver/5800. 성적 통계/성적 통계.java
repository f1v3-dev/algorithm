import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        for (int i = 0; i < K; i++) {
            System.out.println("Class " + (i + 1));

            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }
            
            Arrays.sort(arr);

            int largestGap = 0;
            for (int j = 1; j < N; j++) {
                largestGap = Math.max(largestGap, arr[j] - arr[j - 1]);
            }
            System.out.println("Max " + arr[N - 1] + ", Min " + arr[0] + ", Largest gap " + largestGap);
        }
    }
}