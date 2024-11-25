import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int count = Integer.parseInt(br.readLine());
        for (int x = 0; x < count; x++) {
            input = br.readLine().split(" ");
            int gender = Integer.parseInt(input[0]);
            int num = Integer.parseInt(input[1]);

            if (gender == 1) {
                for (int i = 0; i < n; i++) {
                    if ((i + 1) % num == 0) {
                        arr[i] = arr[i] == 0 ? 1 : 0;
                    }
                }
            } else if (gender == 2) {

                arr[num - 1] = arr[num - 1] == 0 ? 1 : 0;
                // num - i, num + i 가 같은지 계속해서 확인
                for (int i = 0; i < n; i++) {
                    if (num - i - 1 < 0 || num + i - 1 >= n) {
                        break;
                    }

                    if (arr[num - i - 1] == arr[num + i - 1]) {
                        arr[num - i - 1] = arr[num - i - 1] == 0 ? 1 : 0;
                        arr[num + i - 1] = arr[num + i - 1] == 0 ? 1 : 0;
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");

            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}