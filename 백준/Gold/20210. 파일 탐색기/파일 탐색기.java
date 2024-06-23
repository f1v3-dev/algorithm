import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    private static class FileExplorer {

        public static String[] sort(String... fileName) {
            Arrays.sort(fileName, (s1, s2) -> {

                // 1글자씩 비교해야할 것 같은데 문자열의 길이가 같지 않은 경우도 존재
                int len1 = s1.length();
                int len2 = s2.length();

                int index1 = 0;
                int index2 = 0;

                while (index1 < len1 && index2 < len2) {

                    char c1 = s1.charAt(index1);
                    char c2 = s2.charAt(index2);

                    // 1. 숫자일 경우 숫자열을 묶어서 비교해야 됨.
                    boolean isNumber1 = isNumber(c1);
                    boolean isNumber2 = isNumber(c2);

                    if (isNumber1 && isNumber2) {
                        int zeroCount1 = 0, zeroCount2 = 0;
                        while (index1 < s1.length() && s1.charAt(index1) == '0') {
                            zeroCount1++;
                            index1++;
                        }

                        while (index2 < s2.length() && s2.charAt(index2) == '0') {
                            zeroCount2++;
                            index2++;
                        }

                        String num1 = makeNumber(s1, index1);
                        String num2 = makeNumber(s2, index2);

                        // index 길이를 조절
                        index1 += num1.length();
                        index2 += num2.length();

                        // 길이가 다르면 짧은 숫자가 먼저 오도록
                        if (num1.length() > num2.length()) return 1;
                        if (num2.length() > num1.length()) return -1;

                        // 길이가 같다면 한자리씩 비교
                        for (int i = 0; i < num1.length(); i++) {
                            if (num1.charAt(i) > num2.charAt(i)) return 1;
                            if (num2.charAt(i) > num1.charAt(i)) return -1;
                        }

                        // 숫자까지 동일한 경우 0의 개수가 적은 것이 먼저 오도록
                        if (zeroCount1 != zeroCount2) {
                            return zeroCount1 - zeroCount2;
                        }

                        continue;
                    }


                    // 2. 숫자가 아닌 경우 (알파벳인 경우)
                    if (!isNumber1 && !isNumber2) {

                        c1 = s1.charAt(index1);
                        c2 = s2.charAt(index2);

                        if (c1 == c2) {
                            index1++;
                            index2++;
                            continue;
                        }

                        boolean isUpper1 = Character.isUpperCase(c1);
                        boolean isUpper2 = Character.isUpperCase(c2);

                        c1 = Character.toLowerCase(c1);
                        c2 = Character.toLowerCase(c2);

                        // 대문자 && 대문자 || 소문자 && 소문자
                        if ((isUpper1 && isUpper2) || (!isUpper1 && !isUpper2)) {
                            return c1 - c2;
                        }

                        // 소문자 && 대문자
                        if (!isUpper1 && isUpper2) {

                            // c1 == c2
                            if (c1 == c2) {
                                return 1;
                            }
                            return c1 - c2;
                        }

                        // 대문자 && 소문자
                        if (isUpper1 && !isUpper2) {

                            if (c1 == c2) {
                                return -1;
                            }

                            return c1 - c2;
                        }

                    }

                    // 3. s1 문자, s2 숫자
                    if (!isNumber1 && isNumber2) {
                        return 1;
                    }
                    // 4. s1 숫자, s2 문자
                    if (isNumber1 && !isNumber2) {
                        return -1;
                    }

                    index1++;
                    index2++;
                }

                // 5. 같은 문자인 경우 (문자열 길이를 비교)
                return len1 - len2;
            });

            return fileName;
        }

        private static String makeNumber(String str, int index) {
            StringBuilder sb = new StringBuilder();
            while (index < str.length() && isNumber(str.charAt(index))) {
                sb.append(str.charAt(index++));
            }

            return sb.toString();
        }

        private static boolean isNumber(char c) {
            return '0' <= c && c <= '9';
        }
    }

    static int n;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (String str : solve()) {
            System.out.println(str);
        }
    }

    private static String[] solve() {
        /*
        1. 문자열은 알파뎃 대소문자와 숫자로만 이루어져 있다.
        2. 숫자열이 알파벳보다 앞에 오고, 알파벳끼리는 AaBbCc...XxYyZz 순서를 따른다.
        3. 문자열을 비교하는 중 숫자가 있을 경우 그 다음에 오는 숫자를 최대한 많이 묶어 한 단위로 비교한다.
          ex. "a12bc345"는 "a", "12", "b", "c", "345" 다섯 단위로 이루어져 있다.
        4. 숫자열끼리는 십진법으로 읽어서 더 작은 것이 앞에 온다. (최대 : 2^63 초과 -> BigInteger?)
        5. 같은 값을 가지는 숫자열일 경우 앞에 따라붙는 0의 개수가 적은 것이 앞에 온다.
         */
        return FileExplorer.sort(arr);
    }
}