import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int[] arr = new int[input.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int ys = calcYsPlan(arr);
        int ms = calcMsPlan(arr);

        if (ys > ms) {
            System.out.println("M " + ms);
        } else if (ys == ms) {
            System.out.println("Y M " + ys);
        } else {
            System.out.println("Y " + ys);
        }
    }

    /**
     * 30초마다 10원씩 청구
     */
    private static int calcYsPlan(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            double ceil = Math.ceil((double) (arr[i] + 1) / 30);
            sum += (10 * ceil);
        }

        return sum;
    }

    /**
     * 60초마다 15원씩 청구
     */
    private static int calcMsPlan(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            double ceil = Math.ceil((double) (arr[i] + 1) / 60);
            sum += (15 * ceil);
        }

        return sum;
    }
}