import java.util.Scanner;

public class swea2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 개수
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 배열의 크기
			int M = sc.nextInt(); // 파리채의 크기
			int[][] map = new int[N][N]; // 배열
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < N; m++) {
					map[n][m] = sc.nextInt();
				}
			}
			int ans = 0;
			
			for(int i = 0; i <= N-M; i++) {
				for(int j = 0; j <= N-M; j++) {
					int temp = 0; // 부분합
					for(int r = i; r < i+M; r++) { 
						for(int c = j; c < j+M; c++) {
							temp += map[r][c];
						}
					}
					ans = Math.max(temp, ans); // 최대값 찾기
				}
			}
		
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
