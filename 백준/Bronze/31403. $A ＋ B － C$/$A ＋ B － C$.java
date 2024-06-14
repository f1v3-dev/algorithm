import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        solve(a, b, c);
    }

    private static void solve(int a, int b, int c) {

        // 1. a + b - c
        System.out.println(a + b - c);

        // 2. String a + b - c
        String left = a + String.valueOf(b);
        int result = Integer.parseInt(left) - c;
        System.out.println(result);
    }
}