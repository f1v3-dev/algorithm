import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> mappedNum = new HashMap<>();
        HashMap<Integer, String> mappedName = new HashMap<>();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            mappedNum.put(name, i + 1);
            mappedName.put(i + 1, name);
        }

        for (int j = 0; j < M; j++){
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                int index = Integer.parseInt(str);
                sb.append(mappedName.get(index)).append("\n");
            } else {
                sb.append(mappedNum.get(str)).append("\n");
            }
        }

        System.out.println(sb);
    }
}