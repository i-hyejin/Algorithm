import java.io.*;
import java.util.*;

public class swea1249 {
	static class Pos implements Comparable<Pos>{
		int r;
		int c;
		int cnt;
		
		Pos(){}
		
		Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		public int compareTo(Pos o) {
			return this.cnt - o.cnt;
		}
	}
	
	static int[] dr = {0, 0, -1, 1}; // 상, 하, 좌, 우
	static int[] dc = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int t = 1; t <= T; t++) {
			int ans = Integer.MAX_VALUE; // 정답
			
			int N = Integer.parseInt(br.readLine()); // 지도의 크기
			int[][] map = new int[N][N]; // 지도
			for (int i = 0; i < map.length; i++) {
				String s = br.readLine();
				for (int j = 0; j < map.length; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			boolean[][] visited = new boolean[N][N];
			
			PriorityQueue<Pos> q = new PriorityQueue<Pos>(); // 우선순위 큐 적용
			q.add(new Pos(0, 0, map[0][0])); // 시작 지점 넣기
			visited[0][0] = true; // 방문 처리
			
			while(!q.isEmpty()) {
				Pos p = q.poll();
				
				if(p.r == N-1 && p.c == N-1) { // 끝 지점이면 복구 시간 최소값 찾기
					ans = Math.min(ans, p.cnt);
				}
				
				for (int d = 0; d < 4; d++) { // 사방탐색
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
						visited[nr][nc] = true; // 방문 처리
						q.add(new Pos(nr, nc, p.cnt + map[nr][nc])); // 복구 시간 더해서 큐에 넣기
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
