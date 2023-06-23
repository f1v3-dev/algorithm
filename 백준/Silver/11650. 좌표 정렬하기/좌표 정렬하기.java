import java.util.*;

public class Main {
	

	public static class position {
		int x;
		int y;
		
		public position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		
		List<position> lists = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			lists.add(new position(x, y));
		}
		
		Collections.sort(lists, new Comparator<position>() {
			@Override
			public int compare(position p1, position p2) {
				if (p1.x != p2.x) {
					return Integer.compare(p1.x, p2.x);
				} else {
					return Integer.compare(p1.y, p2.y);
				}
			}
		});
		
		for (position list : lists) {
			System.out.println(list.x + " " + list.y);
		}
	}
		
}