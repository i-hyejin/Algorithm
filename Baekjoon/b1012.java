import java.util.*;
import java.awt.Point;
import java.io.*;

public class b1012 {
	private static int M;
	private static int N;
	private static int K;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream(new File("b1012_input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken()); // 배추의 개수
			map = new int[M][N]; // 땅
			visited = new boolean[M][N]; // 방문 여부
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1; // 배추 심기
			}
			ans = 0; // 흰지렁이 개수
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1 && !visited[i][j]) { // 배추가 심어져 있고, 방문 전이면
						dfs(i, j); // dfs로 탐색
//						bfs(i, j); // bfs로 탐색
						ans++; // 흰지렁이 한 마리 추가
					}
				}
			}
			
			System.out.println(ans); // 출력
		}
	}

	private static void dfs(int r, int c) {
		// inductive part
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] == 1) { // 범위 내에 배추가 있으면
				if(!visited[nr][nc]) { // 방문 전이면
					visited[nr][nc] = true; // 방문 처리
					dfs(nr, nc); // 이어서 방문
				}
			}
		}
		
	}

	private static void bfs(int r, int c) {
		Queue<Point> Q = new LinkedList();
		Q.add(new Point(r, c)); // 큐에 넣고
		visited[r][c] = true; // 방문 처리
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if(nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					Q.add(new Point(nr, nc));
				}
			}
		}
	}

}
