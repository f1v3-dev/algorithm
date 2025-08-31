class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int posSecond = toSeconds(pos);
        int opStartSecond = toSeconds(op_start);
        int opEndSecond = toSeconds(op_end);
        int videoLenSecond = toSeconds(video_len);

        posSecond = checkOpening(posSecond, opStartSecond, opEndSecond);
        
        for (String command : commands) {

            switch (command) {
                case "prev":
                    posSecond = Math.max(0, posSecond - 10);
                    break;
                case "next":
                    posSecond = Math.min(posSecond + 10, videoLenSecond);
                    break;
            }

            // 오프닝 건너뛰기
            posSecond = checkOpening(posSecond, opStartSecond, opEndSecond);

            System.out.println(toTime(posSecond));
        }

        return toTime(posSecond);

    }

    private int checkOpening(int posSecond, int opStartSecond, int opEndSecond) {
        if (posSecond >= opStartSecond && posSecond <= opEndSecond) {
            posSecond = opEndSecond;
        }
        return posSecond;
    }

    private int toSeconds(String time) {
        String[] split = time.split(":");

        int minute = Integer.parseInt(split[0]) * 60;
        int second = Integer.parseInt(split[1]);

        return minute + second;
    }

    private String toTime(int seconds) {

        int minute = seconds / 60;
        int second = seconds % 60;

        // 00:00 형태로 맞춰줘야 함.
        return String.format("%02d:%02d", minute, second);
    }
}