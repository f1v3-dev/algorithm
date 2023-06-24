import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		for (int i = 0; i < N; i++) {
			que.offer(i + 1);
		}
		
		while(que.size() > 1) {
			for (int i = 0; i < K-1; i++) {
				que.offer(que.poll());
			}
			sb.append(que.poll()).append(", ");
		}
		
		sb.append(que.poll()).append(">");
		
		System.out.println(sb);
	}
}