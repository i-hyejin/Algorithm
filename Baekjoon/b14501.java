import java.util.Scanner;

public class b14501 {

	private static int N;
	private static int[] T;
	private static int[] P;
	private static boolean[] v;
	private static int ans;
	private static int[] d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		T = new int[N+2];
		P = new int[N+2];
		d = new int[N+2];
		ans = 0;
		for (int i = 1; i <= N; i++) {
			T[i] = sc.nextInt(); // 상담 완료 기간
			P[i] = sc.nextInt(); // 상담 받을 수 있는 금액
		}
		
		d[1] = 0;
		for (int i = 1; i <= N+1; i++) {
			if(d[i] <= d[i-1]) { // 현재까지의 값이 이전 값보다 작으면
				d[i] = d[i-1]; // 이전에서 바로 올 수도 있으므로 값 받아오기
			}
			if(i + T[i] <= N+1) { // 현재 날짜 + 상담 완료 기간이 퇴사 전까지이면
				d[i + T[i]] = Math.max(d[i + T[i]], d[i] + P[i]); // 가능한 경우임
			}
		}
		
		for (int i = 1; i <= N+1; i++) { // 정리한 d 배열에서 최대값 찾기
			ans = Math.max(ans, d[i]);
		}
		
		System.out.println(ans);
	}

}
