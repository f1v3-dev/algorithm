import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer [] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        Long result = 0L;
        for (int i = 0; i < N; i++) {
            Long tip = Long.valueOf(arr[i]);
            Long val = tip - i;
            result = val > 0 ? result + val : result;
        }
        System.out.println(result);

    }
}