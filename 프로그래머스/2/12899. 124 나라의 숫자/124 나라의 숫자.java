class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remain = n % 3;

            if (remain == 0) {
                sb.append("4");
                n = (n / 3) - 1;
                continue;
            }

            sb.append(remain);
            n /= 3;
        }
        
        return sb.reverse().toString();
    }
}