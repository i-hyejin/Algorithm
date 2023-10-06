import java.awt.Point;
import java.io.*;
import java.util.*;

public class b2468 {

	private static int N;
	private static int[][] map;
	private static boolean[][] v;
	private static int ans;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// input
		N = Integer.parseInt(br.readLine()); // 배열의 행과 열의 개수
		map = new int[N][N]; // 배열
		ans = 1; // 물이 잠기지 않는 안전한 영역의 최대 개수
		int height = 0; // 물이 차오를 수 있는 최대 높이
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				height = Math.max(height, map[i][j]);
			}
		}
		
		// logic
		for (int h = 0; h < height; h++) { // 0부터 최대 높이까지 탐색
			v = new boolean[N][N]; // 방문 여부
			int safe = 0; // 안전한 영역의 개수
			for (int i = 0; i < N; i++) { // 모든 좌표 탐색
				for (int j = 0; j < N; j++) {
					if(map[i][j] > h && !v[i][j]) { // 안전한 영역이고 방문 전이면
						safe++; // 안전한 영역의 개수 추가
						bfs(i, j, h); // bfs로 탐색
					}
				}
			}
			ans = Math.max(ans, safe); // 최대 영역의 개수 찾기
		}
		
		// output
		System.out.println(ans);		
	}

	private static void bfs(int r, int c, int h) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(r, c));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] > h) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}
	}

}
