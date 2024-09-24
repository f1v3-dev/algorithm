import java.util.*;

class Solution {
    public int[] solution(String s) {

        int processCount = 0;
        int zeroCount = 0;
        while (!s.equals("1")) {
            zeroCount += countingZero(s);
            s = removeZero(s);
            s = convertBinary(s.length());
            processCount++;
        }

        return new int[]{processCount, zeroCount};
    }

    public int countingZero(String s) {

        long count = Arrays.stream(s.split(""))
                .filter(c -> c.equals("0"))
                .count();

        return (int) count;
    }

    public String removeZero(String s) {
        return s.replaceAll("0", "");
    }

    public String convertBinary(int size) {
        return Integer.toBinaryString(size);
    }
}