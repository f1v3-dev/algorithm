public class Recursion {

    static int reverse = 0;

    static int recursion(int n) {
        int temp = 0;
        if (n > 0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            return recursion(n / 10);
        }

        temp = reverse;
        reverse = 0;
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(recursion(123) + recursion(123));
        // System.out.println(recursion(123));
    }
}
