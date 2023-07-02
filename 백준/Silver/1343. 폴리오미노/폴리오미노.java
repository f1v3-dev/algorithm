import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        poliomino(input);
    }

    public static void poliomino(String input) {

        input = input.replace("XXXX", "AAAA");
        input = input.replace("XX", "BB");

        if (input.contains("X")) {
            System.out.println(-1);
        }
        else {
            System.out.println(input);
        }
    }
}