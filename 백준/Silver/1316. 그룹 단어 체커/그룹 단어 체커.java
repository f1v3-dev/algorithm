import java.util.*;

public class Main {

	public static boolean check(String str) {

		boolean[] check = new boolean[26];
		int prev = 0;

		for (int i = 0; i < str.length(); i++) {
			int pos = str.charAt(i);

			// 앞의 문자와 i번째 문자가 같지 않다면
			if (prev != pos) {

				if (check[pos - 'a'] == false) {
					check[pos - 'a'] = true;
					prev = pos;
				}

				else {
					return false;
				}

			}

		}
		return true;

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int num = s.nextInt();
		int count = 0;
		for (int i = 0; i < num; i++) {
			String str = s.next();
			if (check(str) == true) {
				count++;
			}
		}

		System.out.println(count);
	}
}
