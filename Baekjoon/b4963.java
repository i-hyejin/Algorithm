import java.io.*;
import java.util.*;

public class b4963 {
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	private static int w;
	private static int h;
	private static int[][] map;
	private static boolean[][] v;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("b4963_input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int t = 1; // 테스트 케이스
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 너비
			h = Integer.parseInt(st.nextToken()); // 높이
			if(w == 0 && h == 0) break; // 0 0이 주어지면 끝
			map = new int[h][w]; // 지도
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // 1은 땅, 0은 바다
				}
			}
			v = new boolean[h][w]; // 방문 여부
			int ans = 0; // 섬의 개수
			
			for(int i = 0; i < h; i++) { // 탐색
				for(int j = 0; j < w; j++) {
					if(!v[i][j] && map[i][j] == 1) {
						v[i][j] = true;
						dfs(i, j);
						ans++;
					}
				}
			}
			
			sb.append(ans + "\n"); // 섬의 개수 출력
			t++; // 테스트 케이스 개수 추가
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int r, int c) {
		// basis part
		
		// inductive part
		for (int d = 0; d < 8; d++) { // 8방탐색
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < h && nc >= 0 && nc < w && !v[nr][nc]) {
				if(map[nr][nc] == 1) {
					v[nr][nc] = true;
					dfs(nr, nc);
				}
			}
		}
	}

}
