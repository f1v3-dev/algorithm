import java.util.*;

public class Main {
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int A = sc.nextInt() / 2;
		int B = sc.nextInt();
		
		System.out.println(Math.min(N, A + B));
	}
}