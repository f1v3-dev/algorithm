import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] result = new String[input.length()];

        for (int i = 0; i < result.length; i++) {
            result[i] = input.substring(i);
        }

        Arrays.sort(result);

        for (String s : result) {
            System.out.println(s);
        }


    }
}