import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int count  = 0;
        int prevScore = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            int nextScore = Integer.parseInt(br.readLine());

            if ((prevScore - nextScore) >= k) {
                count++;
            }

            prevScore = nextScore;
        }

        System.out.println(count);
    }
}