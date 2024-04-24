import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int P = Integer.parseInt(br.readLine());

        result = new int[P];

        for (int i = 0; i < P; i++) {
            String[] input = br.readLine().split(" ");
            int T = Integer.parseInt(input[0]);

            int[] arr = new int[20];
            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(input[j + 1]);
            }
            int count = bubbleSort(arr);

            result[T - 1] = count;
        }

        for (int i = 0; i < P; i++) {
            System.out.println((i + 1) + " " + result[i]);
        }
    }

    /**
     * Bubble sort
     */
    private static int bubbleSort(int[] arr) {
        int count = 0;

        // 키 순서 (오름차순) 정렬 필요
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    count++;
                    swap(arr, j, j + 1);
                }
            }
        }
        return count;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}