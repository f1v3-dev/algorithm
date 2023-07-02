import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int num = sc.nextInt();
        int div = 2;
        while (num > 1) {
            if (num % div == 0) {
                sb.append(div).append("\n");
                num /= div;
            }
            else {
                div++;
            }
        }
        System.out.println(sb);
    }
}