import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] myArr = new int[4];
    private static int[] checkArr = new int[4];
    private static int checkSameSize = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int S = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);
        int total = 0;

        char[] arr = br.readLine().toCharArray();

        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(input[i]);
            if (checkArr[i] == 0) {
                checkSameSize++;
            }
        }


        for (int i = 0; i < P; i++) {
            add(arr[i]);
        }

        if (checkSameSize == 4) {
            total++;
        }

        // i : 끝나는 지점
        // j : 시작점
        for (int i = P; i < S; i++) {
            int j = i - P;
            add(arr[i]);
            remove(arr[j]);

            if (checkSameSize == 4) {
                total++;
            }
        }

        System.out.println(total);
    }

    private static void remove(char ch) {
        switch (ch) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSameSize--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSameSize--;
                myArr[1]--;
                break;

            case 'G':
                if (myArr[2] == checkArr[2]) checkSameSize--;
                myArr[2]--;
                break;

            case 'T':
                if (myArr[3] == checkArr[3]) checkSameSize--;
                myArr[3]--;
                break;
        }
    }

    private static void add(char ch) {
        switch (ch) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSameSize++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSameSize++;
                break;

            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSameSize++;
                break;

            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSameSize++;
                break;
        }
    }


}