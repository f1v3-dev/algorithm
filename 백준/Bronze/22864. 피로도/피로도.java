import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int C = Integer.parseInt(str[2]);
        int M = Integer.parseInt(str[3]);

        int time = 24;
        int fatigue = 0;
        int count = 0;

        for (int i = 0; i < time; i++) {

            if (fatigue + A <= M) {
                count += B;
                fatigue += A;
            }
            else {
                fatigue = Math.max(fatigue - C, 0);
            }
        }

        System.out.println(count);


    }
}