import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int startTime = calcTime(str[0]);
        int endTime = calcTime(str[1]);
        int endStream = calcTime(str[2]);

        HashSet<String> attendee = new HashSet<>();
        int count = 0;
        String input;

        while ((input = br.readLine()) != null) {
            String[] arr = input.split(" ");
            int time = calcTime(arr[0]);
            String name = arr[1];

            if (time <= startTime) {
                attendee.add(name);
            }

            if (endTime <= time && time <= endStream && attendee.contains(name)) {
                count++;
                attendee.remove(name);
            }
        }

        System.out.println(count);
    }

    public static int calcTime(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        return hour * 60 + minute;
    }
}
