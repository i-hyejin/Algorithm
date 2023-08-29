import java.io.*;
import java.util.*;

public class b1463_recursive {

	private static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ans = Integer.MAX_VALUE;
		calc(N, 0);
		
		System.out.println(ans);
	}

	private static void calc(int n, int cnt) {
		if(cnt > ans) {
			return;
		}
		
		if(n == 1) {
			ans = Math.min(ans, cnt);
			return;
		}

		if(n % 3 == 0) calc(n / 3, cnt + 1);
		if(n % 2 == 0) calc(n / 2, cnt + 1);
		calc(n - 1, cnt + 1);
	}
}
