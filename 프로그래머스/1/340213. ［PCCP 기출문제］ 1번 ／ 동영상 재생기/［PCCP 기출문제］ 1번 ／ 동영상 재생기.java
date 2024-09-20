class Solution {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        for (String command : commands) {
            if (isBetweenStartAndEnd(pos, op_start, op_end)) {
                pos = op_end;
            }

            pos = updatePosition(command, pos, video_len);
        }

        if (isBetweenStartAndEnd(pos, op_start, op_end)) {
            pos = op_end;
        }

        return pos;
    }

    public String updatePosition(String command, String pos, String video_len) {
        return switch (command) {
            case "prev" -> prevPos(pos);
            case "next" -> nextPos(pos, video_len);
            default -> pos;
        };
    }

    public String prevPos(String pos) {
        String[] posSplit = pos.split(":");
        int minute = Integer.parseInt(posSplit[0]);
        int second = Integer.parseInt(posSplit[1]);

        second -= 10;
        if (second < 0) {
            if (minute == 0) {
                second = 0;
            } else {
                second += 60;
                minute = Math.max(minute - 1, 0);
            }
        }

        return formatTime(minute, second);
    }

    public String nextPos(String pos, String video_len) {
        String[] posSplit = pos.split(":");
        int minute = Integer.parseInt(posSplit[0]);
        int second = Integer.parseInt(posSplit[1]);

        second += 10;
        if (second >= 60) {
            second -= 60;
            minute += 1;
        }

        String[] videoSplit = video_len.split(":");
        int videoMinute = Integer.parseInt(videoSplit[0]);
        int videoSecond = Integer.parseInt(videoSplit[1]);

        if (minute > videoMinute ||
                (minute == videoMinute && second > videoSecond)) {
            return formatTime(videoMinute, videoSecond);
        }

        return formatTime(minute, second);
    }

    public boolean isBetweenStartAndEnd(String pos, String op_start, String op_end) {
        return compareTime(pos, op_start) >= 0 && compareTime(pos, op_end) <= 0;
    }

    private int compareTime(String pos, String target) {
        String[] posSplit = pos.split(":");
        String[] targetSplit = target.split(":");

        int posMinute = Integer.parseInt(posSplit[0]);
        int posSecond = Integer.parseInt(posSplit[1]);

        int targetMinute = Integer.parseInt(targetSplit[0]);
        int targetSecond = Integer.parseInt(targetSplit[1]);

        if (posMinute == targetMinute) {
            return Integer.compare(posSecond, targetSecond);
        }

        return Integer.compare(posMinute, targetMinute);
    }

    private String formatTime(int minute, int second) {
        return String.format("%02d:%02d", minute, second);
    }
}