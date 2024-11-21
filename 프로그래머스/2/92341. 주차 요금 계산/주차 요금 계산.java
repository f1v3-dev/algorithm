import java.util.*;

class Solution {

    static int basicTime;
    static int basicFee;
    static int unitTime;
    static int unitFee;

    public int[] solution(int[] fees, String[] records) {

        // 기본 시간, 기본 요금, 단위 시간, 단위 요금
        basicTime = fees[0];
        basicFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        // 차가 들어온 시간과 나간 시간을 관리할 Map (Key: 차량번호, Value: 시간)
        Map<String, Integer> timeMap = new HashMap<>();

        // 차가 토탈 주차한 시간을 관리할 Map (Key: 차량번호, Value: 주차한 시간)
        Map<String, Integer> totalMap = new HashMap<>();

        for (String rec : records) {
            String[] split = rec.split(" ");
            String time = split[0];
            String carNumber = split[1];
            String op = split[2];

            if (op.equals("IN")) {
                timeMap.put(carNumber, timeToMinute(time));
            } else {
                int inTime = timeMap.get(carNumber);
                int outTime = timeToMinute(time);
                int parkingTime = outTime - inTime;

                totalMap.put(carNumber, totalMap.getOrDefault(carNumber, 0) + parkingTime);
                timeMap.remove(carNumber);
            }
        }

        // 출차 내역이 없다면, 23:59에 출차로 처리해야 한다.
        for (String carNumber : new ArrayList<>(timeMap.keySet())) {
            int inTime = timeMap.get(carNumber);
            int outTime = timeToMinute("23:59");
            int parkingTime = outTime - inTime;

            totalMap.put(carNumber, totalMap.getOrDefault(carNumber, 0) + parkingTime);
            timeMap.remove(carNumber);
        }

        // 차량번호를 정렬
        List<String> carNumbers = new ArrayList<>(totalMap.keySet());
        Collections.sort(carNumbers);

        int[] answer = new int[carNumbers.size()];

        for (int i = 0; i < answer.length; i++) {
            String carNumber = carNumbers.get(i);
            int parkingTime = totalMap.get(carNumber);
            int totalFee = totalFee(parkingTime);

            answer[i] = totalFee;
        }

        return answer;
    }

    private int timeToMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private int totalFee(int parkingTime) {
        if (parkingTime <= basicTime) {
            return basicFee;
        }

        int fee = (int) Math.ceil((double) (parkingTime - basicTime) / unitTime);
        return basicFee + fee * unitFee;
    }
}