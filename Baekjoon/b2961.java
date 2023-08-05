import java.util.*;

public class b2961 {
	static int N;
	static int[][] taste;
	static boolean[] selected;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 재료의 개수
		taste = new int[N][2]; // 맛 배열
		selected = new boolean[N]; // 선택 여부
		ans = Integer.MAX_VALUE; // 정답
		for(int n = 0; n < N; n++) {
			taste[n][0] = sc.nextInt(); // 신맛의 곱
			taste[n][1] = sc.nextInt(); // 쓴맛의 합
		}
		
		recursive(0, 0);
		System.out.println(ans); // 출력
	}

	private static void recursive(int cnt, int sel) {
		// basis part
		
		if(cnt == N) {
			if(sel == 0) { // 고른게 없으면 종료
				return;
			}
			int mul = 1; // 곱
			int sum = 0; // 합
			for(int n = 0; n < N; n++) {
				if(selected[n]) { // 선택되었으면
					mul *= taste[n][0]; // 신맛은 곱하고
					sum += taste[n][1]; // 쓴맛은 더하고
				}
			}
			ans = Math.min(ans, Math.abs(mul-sum)); // ans와 신맛의 곱과 쓴맛의 합 중 min 구하기
			return;
		}
		
		// inductive part
		selected[cnt] = true;
		recursive(cnt+1, sel+1);
		selected[cnt] = false;
		recursive(cnt+1, sel);
	}

}
