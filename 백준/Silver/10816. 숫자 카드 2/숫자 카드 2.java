import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 넘겨받은 배열 정렬
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		
		// 이진 탐색 시작
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(upper(arr, key) - lower(arr, key)).append(" ");
		}
		
		System.out.println(sb);
	}
	
	public static int lower(int[] arr, int key) {
		int low = 0;
		int hi = arr.length;
		
		while (low < hi) {
			int mid = (low + hi) / 2;
			
			if (key <= arr[mid]) {
				hi = mid;
			}
			else {
				low = mid + 1;
			}
		}
		
		return low;
	}
	
	public static int upper(int[] arr, int key) {
		int low = 0;
		int hi = arr.length;
		
		while (low < hi) {
			int mid = (low + hi) / 2;
			
			if (key < arr[mid]) {
				hi = mid;
			}
			else {
				low = mid + 1;
			}
		}
		return low;
	}
}