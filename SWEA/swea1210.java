import java.io.*;
import java.util.*;

public class swea1210 {
	static int[] dr = {0, 0, -1}; // 탐색 범위
	static int[] dc = {-1, 1, 0};
	static int[][] map;
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("swea1210_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = 10; // 테스트 케이스의 개수
		for(int t = 1; t <= T; t++) {
			Integer.parseInt(br.readLine()); // 테스트 케이스 순서
			int r = 0, c = 0; // 도착점의 r, c
			map = new int[100][100]; // 2차원 배열의 사다리
			
			// 입력
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) { // 도착 지점에서 시작
						r = i;
						c = j;
					}
				}
			}
			
			move(r, c); // 탐색
			
			// 출력
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void move(int i, int j) {
		while(true) {
			if(i == 0) { // 첫 줄로 오면 종료
				ans = j;
				break;
			}
			
			for(int d = 0; d < 3; d++) {
				int nr = i + dr[d]; // 삼방탐색
				int nc = j + dc[d];
				
				if(nr >= 0 && nr < 100 && nc >= 0 && nc < 100 && map[nr][nc] == 1) {
					map[nr][nc] = 3; // 방문 처리
					i = nr;
					j = nc;
				}
			}
		}
	}
}
