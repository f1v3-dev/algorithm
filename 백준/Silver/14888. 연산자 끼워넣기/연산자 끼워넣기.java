import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arr;
    static int[] operators = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 배열 크기 입력
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];


        // 2. N개의 수 입력
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 3. 연산자 입력
        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(input[i]);
        }

        // 4. 백트래킹 방식을 통해 모든 경우의 수 조회
        backTracking(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void backTracking(int num, int index) {

        // 1. 연산자가 모두 소진된 경우 MAX, MIN 값 갱신
        if (index == arr.length) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        // 2. 남은 연산자를 소진
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                // 현재 연산자 감소
                operators[i]--;

                switch (i) {
                    case 0:
                        backTracking(num + arr[index], index + 1);
                        break;
                    case 1:
                        backTracking(num - arr[index], index + 1);
                        break;
                    case 2:
                        backTracking(num * arr[index], index + 1);
                        break;
                    case 3:
                        backTracking(num / arr[index], index + 1);
                        break;
                    default:
                        throw new IllegalArgumentException("잘못된 값이 들어왔습니다. : " + i);
                }

                operators[i]++;
            }
        }
    }
}