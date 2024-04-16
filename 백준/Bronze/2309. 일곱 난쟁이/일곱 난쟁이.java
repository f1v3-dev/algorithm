import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int[] arr = new int[9];
    private static int sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            int tall = sc.nextInt();
            arr[i] = tall;
        }

        sum = Arrays.stream(arr).sum();

        findDwarf(arr);

        // 정렬 후 출력
        Arrays.sort(arr);
        Arrays.stream(arr)
                .limit(7)
                .forEach(System.out::println);
    }

    private static void findDwarf(int[] dwarf) {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (dwarf[i] + dwarf[j]) != 100) {
                    continue;
                }

                arr[i] = Integer.MAX_VALUE;
                arr[j] = Integer.MAX_VALUE;
                return;
            }
        }
    }
}