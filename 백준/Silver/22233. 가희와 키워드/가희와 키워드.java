import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String line = br.readLine();

            String[] split = line.split(",");
            for (String word : split) {
                set.remove(word);
            }

            sb.append(set.size()).append("\n");
        }

        System.out.println(sb);
    }
}