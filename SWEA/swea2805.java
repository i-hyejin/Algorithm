import java.util.*;

public class swea2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 받기
		int T = sc.nextInt();
		
		// 테스트케이스 반복
		for(int t = 1; t <= T; t++){
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int ans = 0;
			
			// 공백 없는 숫자 입력 받기
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			// 왼쪽, 오른쪽 기준
			int left = N / 2;
			int right = N / 2;
			
			for(int i = 0; i < N; i++) {
				if (i < N / 2) { // 내려가면서 증가
					for(int j = left; j <= right; j++) {
						ans += map[i][j];
					}
					left--;
					right++;
				} else { // 내려가면서 감소
					for(int j = left; j <= right; j++) {
						ans += map[i][j];
					}
					left++;
					right--;
				}
			}
			
			// 출력
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
