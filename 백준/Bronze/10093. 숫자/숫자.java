import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        long min = Math.min(Long.parseLong(input[0]), Long.parseLong(input[1]));
        long max = Math.max(Long.parseLong(input[0]), Long.parseLong(input[1]));


        StringBuilder sb = new StringBuilder();

        if (min == max) {
            sb.append(0);
        } else {
            sb.append(max - min - 1).append("\n");
            for (long i = min + 1; i < max; i++) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}