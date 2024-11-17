class Solution {
    public int[] solution(int n, long left, long right) {

        int[] answer = new int[(int) (right - left + 1)];

        int index = 0;
        for (long i = left; i <= right; i++) {
            int row = (int) (i / n) + 1;
            int column = (int) (i % n) + 1;

            answer[index++] = Math.max(row, column);
        }

        return answer;
    }
}