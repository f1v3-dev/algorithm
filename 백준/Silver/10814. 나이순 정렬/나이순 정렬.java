import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Member implements Comparable<Member> {
    private int age;

    private String name;

    private int sequence;

    public Member(int age, String name, int sequence) {
        this.age = age;
        this.name = name;
        this.sequence = sequence;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getSequence() {
        return sequence;
    }

    @Override
    public int compareTo(Member o) {
        if (this.age != o.age) {
            return this.age - o.age;
        }
        return this.sequence - o.sequence;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Member> members = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];

            members.add(new Member(age, name, i));
        }

        StringBuilder sb = new StringBuilder();
        members.stream()
                .sorted()
                .forEach(member -> sb.append(member.getAge()).append(" ").append(member.getName()).append("\n"));

        System.out.println(sb);
    }
}