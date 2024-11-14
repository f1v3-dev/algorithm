import java.util.HashMap;
import java.util.Map;

class Solution {

    static Map<Character, Integer> map = new HashMap<>();

    public String solution(String[] survey, int[] choices) {

        init();

        // survey[i] 의 첫번째 : 비동의
        // survey[i] 의 두번째 : 동의

        // choice 1 ~ 3 비동의
        // choice 5 ~ 7 동의

        for (int i = 0; i < choices.length; i++) {

            int choice = choices[i];
            String str = survey[i];

            if (choice == 1 || choice == 2 || choice == 3) {
                map.put(str.charAt(0), map.get(str.charAt(0)) + (4 - choice));
            } else if (choice == 5 || choice == 6 || choice == 7) {
                map.put(str.charAt(1), map.get(str.charAt(1)) + (choice - 4));
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        sb.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        sb.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        sb.append(map.get('A') >= map.get('N') ? 'A' : 'N');

        return sb.toString();
    }

    private static void init() {
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
    }
}