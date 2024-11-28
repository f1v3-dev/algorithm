import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int m;
    static int[] lights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        lights = new int[m];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            lights[i] = Integer.parseInt(split[i]);
        }

        int start = 1;
        int end = n;

        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean check(int height) {
        int range = 0;

        // light의 위치
        for (int light : lights) {
            if (light - height > range) {
                return false;
            }

            range = light + height;
        }

        return range >= n;
    }
}