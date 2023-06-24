import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int start = 0;
		
		while(N-- > 0) {
			int num = sc.nextInt();
			
			if (num > start) {
				for (int i = start + 1; i <= num; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				start = num;
			}
			else if (stack.peek() != num) {
				sb.delete(0, sb.length());
				sb.append("NO");
				break;
			}
			
			stack.pop();
			sb.append("-").append("\n");
		}
		
		System.out.println(sb);
	}
}