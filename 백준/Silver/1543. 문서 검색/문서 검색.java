import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        String word = br.readLine();

        // line에서 word가 몇 번 등장하는지 파악

        int result = 0;
        int left = 0;
        int right = 0;
        int wordLength = word.length();
        int lineLength = line.length();


        while (right < lineLength) {
            if (right - left + 1 == wordLength) {

                String target = line.substring(left, right + 1);

                if (word.equals(target)) {
                    result++;

                    right = right + 1;
                    left = right;
                } else {
                    left++;
                    right++;
                }
            } else {
                right++;
            }
        }


        System.out.println(result);

    }
}