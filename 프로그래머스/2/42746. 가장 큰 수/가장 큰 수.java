import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] answer = new String[numbers.length];

        // 정수를 String으로 변환하여 배열에 저장
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = String.valueOf(numbers[i]);
        }

        // 내림차순이기 때문에 두 수를 합쳤을 때 큰 수가 앞에 오도록
        // (o2 + o1).compareTo(o1 + o2)를 사용하여 정렬
        Arrays.sort(answer, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 정렬된 배열의 첫 값이 0인 경우는 모든 값이 0
        // 즉, return 0
        if ("0".equals(answer[0])) {
            return "0";
        }

        return String.join("", answer);
    }
}