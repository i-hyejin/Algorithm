import java.util.Scanner;

public class b2567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dr = {-1, 1, 0, 0}; // 사방탐색
		int[] dc = {0, 0, -1, 1};
		int ans = 0; // 정답(둘레)

		int N = sc.nextInt(); // 색종이의 수
		int[][] rc = new int[N][2]; // 색종이 붙일 위치 배열
		int max_rc = 0; // 색종이 최대 좌표
		for(int n = 0; n < N; n++) {
			rc[n][1] = sc.nextInt() + 1;
			rc[n][0] = sc.nextInt() + 1;
			max_rc = Math.max(max_rc, Math.max(rc[n][1], rc[n][0]));
		}
		max_rc += 11; // 10 만큼 붙이고도 여백 하나 추가
		int[][] map = new int[max_rc][max_rc]; // 흰색 도화지 축소해서 만들기
		
		for(int n = 0; n < N; n++) { // 색종이 붙이기
			int r = rc[n][0];
			int c = rc[n][1];
			for(int i = r; i < r+10; i++) {
				for(int j = c; j < c+10; j++) {
					map[i][j] = 1;
				}
			}
		}
	
		for(int i = 0; i < max_rc; i++) { 	// 사방탐색 후 주변이 0 값이 있으면 둘레로 계산
			for(int j = 0; j < max_rc; j++) {
				if(map[i][j] == 1) {
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr > 0 && nr <= max_rc && nc > 0 && nc <= max_rc && map[nr][nc] == 0) {
							ans++;
						}
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}
