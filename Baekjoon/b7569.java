import java.io.*;
import java.util.*;

public class b7569 {
	static class Tomato{
		int h, r, c;
		
		public Tomato(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}
	
	private static int[] dh = {-1, 1, 0, 0, 0, 0}; // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
	private static int[] dr = {0, 0, -1, 1, 0, 0};
	private static int[] dc = {0, 0, 0, 0, -1, 1};
	private static int M;
	private static int N;
	private static int H;
	private static int[][][] map;
	private static Queue<Tomato> q;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// input
		N = Integer.parseInt(st.nextToken()); // 가로
		M = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이
		map = new int[H][M][N]; // 토마토의 정보
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < M; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					// 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토가 없음
					map[h][r][c] = Integer.parseInt(st.nextToken());
				}
			}
		}
		q = new ArrayDeque<Tomato>();
		int ans = 0;
		
		// logic
		// step 1. 익힐 토마토 정하기
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if(map[h][r][c] == 1) { // 익은 토마토면 퍼뜨리기
						q.add(new Tomato(h, r, c));
					}
				}
			}
		}
		
		// step 2. 토마토 익히기
		bfs();
		
		// step 3. 안 익은 토마토 확인
		int day = 0; // 얼마나 지났는지
		boolean notTomato = false; // 익지 않은 토마토(0) 있느지
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if(map[h][r][c] == 0) { // 익지 않은 토마토가 있다면
						notTomato = true;
						break;
					} else { // 익은 토마토가 있다면 언제 익었는지
						day = Math.max(day, map[h][r][c]); 
					}
				}
			}
		}
		
		// output
		// 모든 토마토가 익어있는 상태 : 0
		if(notTomato) {
			ans = -1;
		}
		// 토마토가 모두 익지 못하는 상황 : -1
		else {
			ans = day - 1;
		}
		// 토마토가 모두 익을 때까지 며칠이 걸리는지
		System.out.println(ans);
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Tomato t = q.poll();
			for (int d = 0; d < 6; d++) {
				int nh = t.h + dh[d];
				int nr = t.r + dr[d];
				int nc = t.c + dc[d];
				if(nh >= 0 && nh < H && nr >= 0 && nr < M && nc >= 0 && nc < N) {
					if(map[nh][nr][nc] == 0) {
						map[nh][nr][nc] = map[t.h][t.r][t.c] + 1; // 토마토 익히기
						q.add(new Tomato(nh, nr, nc));
					}
				}
			}
		}
	}

}
