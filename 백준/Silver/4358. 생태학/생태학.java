import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> hashMap = new HashMap<>();
        String input;
        int size = 0;
        while (true){
            input = br.readLine();
            if (input == null || input.length() == 0) {
                break;
            }
            hashMap.put(input, hashMap.getOrDefault(input, 0) + 1);
            size++;
        }

        Object[] keys = hashMap.keySet().toArray();
        Arrays.sort(keys);

        for (Object key : keys) {
            String tree = key.toString();
            int num = hashMap.get(tree);
            double per = (double)(num * 100.0) / size;
            sb.append(tree + " " + String.format("%.4f", per)).append("\n");
        }

        System.out.println(sb);
    }
}