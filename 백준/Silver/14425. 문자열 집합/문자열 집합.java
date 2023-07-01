import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> hashSet = new HashSet<>();

        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }

        int count = 0;
        for (int j = 0; j < M; j++) {
            String input = br.readLine();
            if (hashSet.contains(input)) {
                count++;
            }
        }
        System.out.println(count);

    }
}