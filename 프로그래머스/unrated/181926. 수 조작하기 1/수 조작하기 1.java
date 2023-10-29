class Solution {
    public static int solution(int n, String control) {
        int answer = n;

        for (int i = 0; i < control.length(); i++) {
            char ch = control.charAt(i);
            switch (ch) {
                case 'w':
                    answer += 1;
                    break;
                case 's':
                    answer -= 1;
                    break;
                case 'd':
                    answer += 10;
                    break;
                case 'a':
                    answer -= 10;
                    break;
                default:
                    throw new IllegalArgumentException("잘못된 문자열이 들어왔습니다!");
            }
        }
        return answer;
    }
}