import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static String[] first = new String[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            String left = input[0];
            String right = input[1];

            char[] leftArray = left.toCharArray();
            char[] rightArray = right.toCharArray();

            Arrays.sort(leftArray);
            Arrays.sort(rightArray);

            if (isSame(leftArray, rightArray)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }

    public static boolean isSame(char[] left, char[] right) {

        for (int i = 0; i < left.length; i++) {
            if (left[i] != right[i]) {
                return false;
            }
        }
        
        return true;
    }


}