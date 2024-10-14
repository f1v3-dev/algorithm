import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public int[] solution(String today, String[] terms, String[] privacies) {

        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            map.put(split[0], Integer.parseInt(split[1]));
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String date = split[0];
            String term = split[1];

            int termMonth = map.get(term);

            String result = addMonth(date, termMonth);
            System.out.println(result);

            if (isAfter(today, result)) {
                answer.add(i + 1);
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private String addMonth(String date, int month) {

        LocalDate localDate = LocalDate.parse(date, formatter);
        localDate = localDate.plusMonths(month);
        return localDate.format(formatter);
    }

    private boolean isAfter(String today, String result) {
        LocalDate todayDate = LocalDate.parse(today, formatter);
        LocalDate resultDate = LocalDate.parse(result, formatter).minusDays(1);

        return todayDate.isAfter(resultDate);
    }
}