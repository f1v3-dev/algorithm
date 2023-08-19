import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int coprime = Integer.parseInt(br.readLine());

        // 서로소 = 최대공약수가 1인 수
        double sum = 0;
        double count = 0;
        for (int i = 0; i < N; i++) {
            if (gcd(arr[i], coprime) == 1) {
                sum += arr[i];
                count++;
            }
        }

        System.out.println(sum / count);
    }
}