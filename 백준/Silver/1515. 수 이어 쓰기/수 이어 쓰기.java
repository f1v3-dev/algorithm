import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();

        int index = 0;
        int num = 0;

        while (true) {
            num++;
            String str = String.valueOf(num);

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == target.charAt(index)) {
                    index++;
                }

                if (index == target.length()) {
                    System.out.println(num);
                    return;
                }
            }
        }
    }
}