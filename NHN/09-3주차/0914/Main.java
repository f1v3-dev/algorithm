import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static class Fraction {
        private int numerator; // 분자
        private int denominator; // 분모

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;

            normalize();
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        public void normalize() {
            int gcdValue = gcd(this.getNumerator(), this.getDenominator());
            this.setNumerator(this.getNumerator() / gcdValue);
            this.setDenominator(this.getDenominator() / gcdValue);
        }

        private int gcd(int firstNum, int secondNum) {
            if (firstNum % secondNum == 0) {
                return secondNum;
            }
            return gcd(secondNum, (firstNum % secondNum));
        }

        private void setNumerator(int numerator) {
            this.numerator = numerator;
        }

        private void setDenominator(int denominator) {
            this.denominator = denominator;
        }

        @Override
        public String toString() {
            return getNumerator() + "/" + getDenominator();
        }

    }

    /**
     * 소수점 값에 대해 자리 수 계산 하는 메서드. <br/>
     * ex) <br/>
     * 0.01 -> 100을 곱하기 위해 2를 return <br/>
     * 0.1 -> 10을 곱하기 위해 1을 return
     *
     *
     * @param num 소수 값
     * @return 소수점 이하 자리 수 값
     */
    public static int getDecimalNumber(BigDecimal num) {
        String str = num.toPlainString();

        str = str.substring(2, str.length());
        // System.out.println(str.length());

        return str.length();
    }

    public static String solution(String input) {
        BigDecimal number = new BigDecimal(input);

        int decimalNumber = getDecimalNumber(number);

        double denominator = Math.pow(10, decimalNumber);
        int numerator = (int) (Double.parseDouble(input) * (Math.pow(10, decimalNumber)));

        // System.out.println(denominator + " " + numerator);
        return new Fraction(numerator, (int) denominator).toString();
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // System.out.println(solution(sc.nextLine()));

        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES[i], TEST_CASE_RESULTS[i]));
        }

        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));
    }

    private static double correct = 0;

    private static boolean test(String testCase, String result) {
        if (solution(testCase).equals(result)) {
            correct++;
            return true;
        }

        return false;
    }

    private static final String[] TEST_CASES = {
            "0.1", "0.25", "0.3", "0.5"
    };

    private static final String[] TEST_CASE_RESULTS = {
            "1/10", "1/4", "3/10", "1/2"
    };

}