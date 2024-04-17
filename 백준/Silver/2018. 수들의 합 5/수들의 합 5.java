import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        calcCount(N);
    }

    private static void calcCount(int N) {

        int count = 1; // 자기 자신을 포함해서 시작
        int start = 1;
        int end = 1;

        int sum = 1;
        while (end != N) {

            if (sum == N) {
                count++;
                end++;
                sum += end;
            } else if (sum < N) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        System.out.println(count);

    }

}