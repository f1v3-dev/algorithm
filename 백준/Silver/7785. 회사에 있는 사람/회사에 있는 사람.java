import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            if ("enter".equals(input[1])) {
                set.add(input[0]);
            } else if ("leave".equals(input[1])) {
                set.remove(input[0]);
            }
        }

        List<String> result = new ArrayList<>(set);
        Collections.sort(result, Collections.reverseOrder());

        result.stream()
                .forEach(r -> System.out.println(r));
    }
}