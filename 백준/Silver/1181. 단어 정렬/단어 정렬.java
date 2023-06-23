import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		
		List<String> words = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			if (!words.contains(str)) {
				words.add(str);
			}
		}
		
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
					}
				else {
					return s1.length() - s2.length();
				}
			}
		});
		
		for (String word : words) {
			System.out.println(word);
		}
	}
		
}