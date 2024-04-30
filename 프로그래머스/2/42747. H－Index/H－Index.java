import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            int h = numbers.length - i;

            if (numbers[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}