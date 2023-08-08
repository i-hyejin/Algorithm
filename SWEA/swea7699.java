import java.util.*;
import java.io.*;

public class swea7699 {
	private static int R;
	private static int C;
	private static int[][] map;
	private static boolean[] visited;
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	private static int ans;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(new File("swea7699_input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken()); // 행
			C = Integer.parseInt(st.nextToken()); // 열
			map = new int[R][C]; // 섬
			visited = new boolean[27]; // 알파벳 명물 방문 여부
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for(int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j) - 'A' + 1; // 숫자로 저장
				}
			}
			
			visited[map[0][0]] = true; // 출발 지점 명물은 방문한 상태
			ans = 1; // 볼 수 있는 명물의 최대 개수(출발하면서 하나 방문)
			dfs(0, 0, ans); // (0, 0, ans)에서 출발
			
			System.out.println("#" + t + " " + ans); // 출력
		}
	}

	private static void dfs(int r, int c, int cnt) {
		// basis part
		if(cnt == 26) { // 26개의 명물을 모두 봤다면 최대 개수로 업데이트하고 탐색을 종료함
			ans = 26;
			return;
		}
		ans = Math.max(ans, cnt); // 볼 수 있는 명물의 최대 개수 업데이트
		
		// inductive part
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if(!visited[map[nr][nc]]) { // 방문 전이면
					visited[map[nr][nc]] = true; // 방문 처리
					dfs(nr, nc, cnt+1); // 다른 곳도 방문
					visited[map[nr][nc]] = false; // 방문 처리 해제
				}
			}
		}
	}
}
