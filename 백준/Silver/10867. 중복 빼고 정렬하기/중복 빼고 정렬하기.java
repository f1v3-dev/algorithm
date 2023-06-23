import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		
		List<Integer> lists = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (!lists.contains(num)) {
				lists.add(num);
			}
		}
		
		Collections.sort(lists);
		
		for (int list : lists) {
			System.out.print(list + " ");
		}
		
	}
}