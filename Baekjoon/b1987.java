import java.io.*;
import java.util.*;

public class b1987 {
	
	private static int R;
	private static int C;
	private static char[][] map;
	private static boolean[] visited;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int ans;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 가로
		C = Integer.parseInt(st.nextToken()); // 세로
		map = new char[R][C]; // 보드
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		visited = new boolean[27]; // 알파벳 방문 여부
		ans = 0; // 말이 지날 수 있는 최대 칸의 수
		
		dfs(0, 0, 0);
		
		System.out.println(ans);
		
	}

	private static void dfs(int r, int c, int cnt) {
		if(visited[map[r][c]-'A']) { // 이미 방문한 알파벳이면
			ans = Math.max(ans, cnt); // cnt 최대값 return
			return;
		}
		
		visited[map[r][c]-'A'] = true; // 방문 처리
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C){ // 범위 내에 있으면
				dfs(nr, nc, cnt+1); // 이어서 탐색
			}
		}
		visited[map[r][c]-'A'] = false; // 방문 해제
	}

}
