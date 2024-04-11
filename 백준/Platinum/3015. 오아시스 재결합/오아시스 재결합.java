import java.io.*;
import java.util.Stack;

class People {

    private int height;

    private int count;

    public People(int height, int count) {
        this.height = height;
        this.count = count;
    }

    public int getHeight() {
        return height;
    }

    public int getCount() {
        return count;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        long count = 0;
        Stack<People> stack = new Stack<>();

        for (int i = 0; i < size; i++) {

            int height = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek().getHeight() < height) {
                count += stack.pop().getCount();
            }

            // 동일한 키의 사람에 대한 처리가 필요
            int temp = 0;
            if (!stack.isEmpty() && stack.peek().getHeight() == height) {
                temp = stack.pop().getCount();
            }

            count += temp;

            if (!stack.isEmpty()) {
                count++;
            }

            stack.push(new People(height, temp + 1));
        }

        bw.write(String.valueOf(count));
        bw.flush();

        br.close();
        bw.close();

    }
}