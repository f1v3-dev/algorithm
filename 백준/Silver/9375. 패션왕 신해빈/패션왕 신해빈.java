import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {

            Map<String, Integer> map = new HashMap<>();

            int size = Integer.parseInt(br.readLine());
            for (int j = 0; j < size; j++) {
                String[] input = br.readLine().split(" ");

                map.put(input[1], map.getOrDefault(input[1], 0) + 1);
            }

            int result = 1;

            for (Integer value : map.values()) {
                result *= (value + 1);
            }

            System.out.println(result - 1);
        }
    }
}