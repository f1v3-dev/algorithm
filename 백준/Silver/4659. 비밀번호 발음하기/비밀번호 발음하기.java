import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        StringBuilder sb = new StringBuilder();
        while (!"end".equals(input = br.readLine())) {
            sb.append("<").append(input).append("> is ");
            if (firstCondition(input) &&
                    secondCondition(input) &&
                    thirdCondition(input)) {
                sb.append("acceptable.").append("\n");
            } else {
                sb.append("not acceptable.").append("\n");
            }
        }

        System.out.println(sb);
    }

    /**
     * 조건 1. 모음(a, e, i, o, u) 하나를 반드시 포함
     */
    private static boolean firstCondition(String input) {

        return input.contains("a")
                || input.contains("e")
                || input.contains("i")
                || input.contains("o")
                || input.contains("u");
    }

    /**
     * 모음/자음 3개 연속으로 오는지 체크
     */
    private static boolean secondCondition(String input) {
        char[] chars = input.toCharArray();

        int vowelCount = 0;
        int consonantCount = 0;

        for (char ch : chars) {
            if (firstCondition(String.valueOf(ch))) {
                vowelCount++;
                consonantCount = 0;
            } else {
                consonantCount++;
                vowelCount = 0;
            }

            if (vowelCount == 3 || consonantCount == 3) {
                return false;
            }
        }

        return true;
    }

    /**
     * 같은 글자 연속 금지 (but, ee, oo 허용)
     */
    private static boolean thirdCondition(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            char current = input.charAt(i);
            char next = input.charAt(i + 1);

            if (current == next && current != 'e' && current != 'o') {
                return false;
            }
        }

        return true;
    }

}