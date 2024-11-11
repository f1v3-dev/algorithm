class Solution {
    public boolean solution(String s) {

        char[] arr = s.toCharArray();

        // 1. 길이가 4 혹은 6인지 확인
        if (arr.length != 4 && arr.length != 6) {
            return false;
        }

        // 2. 숫자만 들어있는 배열인가?
        for (char ch : arr) {
            if (ch - '0' < 0 || ch - '0' > 9) {
                return false;
            }
        }

        return true;
    }
}