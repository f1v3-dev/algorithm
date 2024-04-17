import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int x = Integer.parseInt(br.readLine());
        calcPair(x);
    }

    public static void calcPair(int x) {
        int start = 0;
        int end = arr.length - 1;

        // 투 포인터 문제
        Arrays.sort(arr);

        int count = 0;
        while (start < end) {

            int temp = arr[start] + arr[end];

            if (temp < x) {
                start++;
            } else if (temp > x){
                end--;
            }

            if (temp == x) {
                count++;
                start++;
            }
        }

        System.out.println(count);
    }
}