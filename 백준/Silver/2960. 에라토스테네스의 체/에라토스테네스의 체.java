import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        boolean [] era = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            era[i] = true;
        }

        eratos(era, N, K);
    }

    public static void eratos(boolean[] era, int N, int K) {

        int count = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (!era[j])
                    continue;
                era[j] = false;
                count++;

                if (count == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}