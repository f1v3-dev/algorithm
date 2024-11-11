class Solution {
    public int[] solution(long n) {
        
        String[] str = String.valueOf(n).split("");
        int[] answer = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            int last = Integer.parseInt(str[str.length - i - 1]);
            answer[i] = last;
        }

        return answer;
    }
}