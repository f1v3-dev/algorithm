import java.util.*;

class Solution {

    static int currentDay;

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();

        for (String term : terms) {
            String[] line = term.split(" ");
            char key = line[0].charAt(0);
            int value = Integer.parseInt(line[1]) * 28;

            map.put(key, value);
        }


        currentDay = getDay(today);

        for (int i = 0; i < privacies.length; i++) {

            String privacy = privacies[i];

            String[] split = privacy.split(" ");
            int day = getDay(split[0]);

            char key = split[1].charAt(0);
            int value = map.get(key);

            // 만료일이 지났다면
            if (currentDay - day >= value) {
                result.add(i + 1);
            }
        }

        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private static int getDay(String date) {
        String[] line = date.split("\\.");
        int year = Integer.parseInt(line[0]) * 12 * 28;
        int month = Integer.parseInt(line[1]) * 28;
        int day = Integer.parseInt(line[2]);

        return year + month + day;
    }
}