import java.util.Arrays;

class Solution {

    public String solution(long n, String[] bans) {
        long limit = n + bans.length;

        long[] bannedNumbers = new long[bans.length];

        int size = 0;
        for (String ban : bans) {
            long index = toIndexWithLimit(ban, limit);
            if (index <= limit) {
                bannedNumbers[size++] = index;
            }
        }

        long[] banned = Arrays.copyOf(bannedNumbers, size);
        Arrays.sort(banned);

        long result = n;
        long prev = Long.MIN_VALUE;

        for (long b : banned) {
            if (b == prev) {
                continue;
            }

            prev = b;
            if (b <= result) {
                result++;
            } else {
                break;
            }
        }

        return toWord(result);
    }

    private long toIndexWithLimit(String word, long limit) {
        long sum = 0;
        for (int i = 0; i < word.length(); i++) {
            int value = word.charAt(i) - 'a' + 1;
            sum = sum * 26 + value;
            if (sum > limit) {
                return sum;
            }
        }

        return sum;
    }

    private String toWord(long index) {
        StringBuilder sb = new StringBuilder();
        while (index > 0) {
            index--;
            long mod = index % 26;
            sb.append((char) ('a' + mod));
            index /= 26;
        }

        return sb.reverse().toString();
    }
}