import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());
    }

    private static int solve() {

        // LIS 방식으로 풀어보자
        // 가장 긴 증가하는 부분 수열을 만들어가는 과정

        int[] LIS = new int[n];
        LIS[0] = arr[0];

        int index = 1;
        for (int i = 1; i < n; i++) {

            // 1. 현재 숫자가 LIS의 마지막 숫자보다 크다면
            // LIS 배열에 추가
            if (arr[i] > LIS[index - 1]) {
                LIS[index++] = arr[i];
            }

            // 2. 현재 숫자가 LIS의 첫 번째 숫자보다 작다면
            // LIS 배열의 첫 번째 수를 arr[i]로 변경한다.
            else if (LIS[0] > arr[i]) {
                LIS[0] = arr[i];
            }

            // 3. binary search를 사용하여 LIS 배열에 들어갈 위치를 찾는다.
            else {
                int pivot = binarySearch(LIS, arr[i], 0, index);
                LIS[pivot] = arr[i];
            }
        }

        return index;
    }

    private static int binarySearch(int[] LIS, int target, int start, int end) {

        // binary search 시작
        while (start < end) {

            int mid = (start + end) / 2;

            if (LIS[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}