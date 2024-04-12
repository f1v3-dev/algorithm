import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int k = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {

            String id = br.readLine();

            if (set.contains(id)) {
                set.remove(id);
            }

            set.add(id);
        }

        set.stream()
                .limit(k)
                .forEach(result -> System.out.println(result));

    }
}