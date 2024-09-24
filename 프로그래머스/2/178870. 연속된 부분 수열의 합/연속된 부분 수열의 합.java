class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        // 투포인터로 i, j를 설정
        int i = 0;
        int j = 0;
        int sum = 0;

        // i, j가 배열의 길이보다 작을 때까지 반복
        // 합이 k인 부분 수열을 찾되, 길이가 짧은 수열을 찾기
        // 길이가 짧은 수열이 여러개인 경우 가장 먼저 나오는 수열을 찾기
        // 값이 아닌 '좌표' 기준으로 찾기

        while (i < sequence.length && j <= sequence.length) {

            if (sum < k && j < sequence.length) {
                sum += sequence[j];
                j++;
            } else {
                if (sum == k) {
                    if (answer.length == 0) {
                        answer = new int[]{i, j - 1};
                    } else {
                        if (answer[1] - answer[0] > j - i - 1) {
                            answer = new int[]{i, j - 1};
                        }
                    }
                }

                sum -= sequence[i];
                i++;
            }

        }


        return answer;
    }
}