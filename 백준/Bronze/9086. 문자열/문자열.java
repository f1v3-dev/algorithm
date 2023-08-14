import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            String str = sc.next();
            if (str.length() < 2) {
                sb.append(str.charAt(0)).append(str.charAt(0));
            }
            else {
                sb.append(str.charAt(0)).append(str.charAt(str.length() - 1));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}