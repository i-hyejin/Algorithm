import java.io.*;
import java.util.*;

public class b9095 {

	private static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		arr = new int[12];
		plus(11);
		
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			sb.append(arr[n]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void plus(int n) {
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for (int i = 4; i <= n; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
	}

}
