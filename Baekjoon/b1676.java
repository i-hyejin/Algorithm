import java.util.Scanner;

public class b1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;

		while(N >= 5) { // N이 5보다 클 때까지 나누기
			ans = ans + N / 5;
			N = N / 5;
		}
		
		System.out.println(ans);
	}
}
