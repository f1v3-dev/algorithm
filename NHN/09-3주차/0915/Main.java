import java.util.Scanner;

public class Main {

    public static long factorial(int number) {
        switch (number) {
            case 0:
            case 1:
                return 1;
            default:
                return number * (factorial(number - 1));
        }
    }

    public static long fibonacci(int number) {

        switch (number) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            default:
                return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < FACTORIAL_TEST_CASES.length; i++) {
            System.out.println(
                    "Test Case " + (i + 1) + " = "
                            + factorialTest(FACTORIAL_TEST_CASES[i], FACTORIAL_TEST_CASE_RESULTS[i]));
        }

        System.out.printf("팩토리얼 정답률 = %.3f%%", (factorial_correct / FACTORIAL_TEST_CASES.length * 100));
        
        System.out.println();

        for (int i = 0; i < FIBONACCI_TEST_CASES.length; i++) {
            System.out.println(
                    "Test Case " + (i + 1) + " = "
                            + fibonacciTest(FIBONACCI_TEST_CASES[i], FIBONACCI_TEST_CASE_RESULTS[i]));
        }

        System.out.printf("피보나치 정답률 = %.3f%%", (fibonacci_correct / FIBONACCI_TEST_CASES.length * 100));

    }

    private static double factorial_correct = 0;
    private static double fibonacci_correct = 0;

    private static boolean factorialTest(int testCase, long result) {
        if (factorial(testCase) == result) {
            factorial_correct++;
            return true;
        }

        return false;
    }

    private static boolean fibonacciTest(int testCase, long result) {
        if (fibonacci(testCase) == result) {
            fibonacci_correct++;
            return true;
        }

        return false;
    }

    private static final int[] FACTORIAL_TEST_CASES = {
            0, 3, 4, 5
    };

    private static final long[] FACTORIAL_TEST_CASE_RESULTS = {
            1, 6, 24, 120
    };

    private static final int[] FIBONACCI_TEST_CASES = {
            0, 6, 8, 10
    };

    private static final long[] FIBONACCI_TEST_CASE_RESULTS = {
            0, 8, 21, 55
    };
}