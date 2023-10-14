import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void reverse(String line, StringBuilder sb) {

        for (int i = line.length() - 1; i >= 0; i--) {
            sb.append(line.charAt(i));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String line;

        while (!(line = br.readLine()).equals("END")) {
            reverse(line, sb);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}