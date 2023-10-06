import java.awt.Point;
import java.io.*;
import java.util.*;

public class b2573 {
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};
	private static int N;
	private static int M;
	private static int[][] map;
	private static int ans;
	private static boolean[][] v;
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// input
		N = Integer.parseInt(st.nextToken()); // 행의 개수
		M = Integer.parseInt(st.nextToken()); // 열의 개수
		map = new int[N][M]; // 빙산
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 1; // 빙산이 2 덩어리 이상으로 분리되는 최초의 시간
		
		// logic
		while(true) {
			// step 1. 빙산의 높이 줄어듦
			
			// 바닷물 찾기
			int[][] status = new int[N][M]; // 바닷물의 개수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] > 0) { // 빙산이 있으면
						for (int d = 0; d < 4; d++) { // 사방탐색으로 바닷물 찾기
							int nr = i + dr[d];
							int nc = j + dc[d];
							if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
								status[i][j]++;
							}
						}
					}
				}
			}
			
			// 바닷물 개수만큼 높이 줄이면서 모두 0인지 확인
			boolean isMelt = true; 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = Math.max(0, map[i][j] - status[i][j]); // 높이는 최소 0으로 처리
					if(map[i][j] > 0) isMelt = false; // 하나라도 빙산이 있으면 false 처리
				}
			}
			
			// 빙산이 모두 녹으면 반복문 종료
			if(isMelt) { 
				ans = 0;
				break;
			}
			
			// step 2. 빙산이 몇 덩어리인지
			v = new boolean[N][M];
			int ice = 0; // 빙산의 덩어리 개수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] > 0 && !v[i][j]) { // 빙산이 있으면
						ice++; // 덩어리 하나 추가
						bfs(i, j); // bfs로 연결되어 있는 빙산 찾기
					}
				}
			}
			
			// step 3. 빙산의 덩어리가 두 덩어리 이상인지
			if(ice >= 2) {
				break;
			}
			
			// 1년 추가
			ans++;
		}
		
		// output
		System.out.println(ans);
	}

	private static void bfs(int i, int j) {
		Queue<Point> q = new ArrayDeque<Point>();
		v[i][j] = true;
		q.add(new Point(i, j));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] > 0 && !v[nr][nc]) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}
	}
}
