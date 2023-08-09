import java.awt.Point;
import java.io.*;
import java.util.*;

public class b7576 {
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	private static int M;
	private static int N;
	private static int[][] map;
	private static Queue<Point> q = new ArrayDeque<Point>();

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(new File("b7576_input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		map = new int[N][M]; // 상자
		
		int tomato = 0; // 익지 않은 토마토의 개수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				// 1: 익은, 0: 익지 않은, -1: 토마토 없는
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) tomato++; // 익지 않은 토마토의 개수만 세기
			}
		}
		int ans = 0;
		
		
		// 토마토 익히기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) { // 익은 토마토이면 퍼뜨려야 함
					q.offer(new Point(i, j)); // 큐에 넣기
				}
			}
		}
		bfs(); // 토마토 퍼뜨리기
		
		// 안 익은 토마토가 있는지 확인
		int day = 0; // 얼마나 지났는지
		boolean ingTomato = false; // 안 익은 토마토(0) 여부
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) { // 안 익은 토마토가 있다면
					ingTomato = true;
				} else { // 익은 토마토가 있으면 언제 익었는지
					day = Math.max(day, map[i][j]);
				}
			}
		}
		
		// 토마토가 모두 익었는지에 따라 정답 결정
		if(ingTomato) { // 토마토가 모두 익지 못하는 상황 (안 익은 토마토가 있음)
			ans = -1;
		} else if(day == 0) { // 저장될 때부터 모두 익어 있는 상태
			ans = 0;
		} else { // 토마토가 모두 익은 상황
			ans = day - 1; // 익은 토마토가 1부터 시작했으므로 1 빼기
		}
		
		System.out.println(ans);
	}

	private static void bfs() {
		boolean tomato = false; // 토마토 하나라도 익혔으면 true, 아니면 false
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(map[nr][nc] == 0) { // 익지 않은 토마토이면 익히기
						tomato = true;
						map[nr][nc] = map[p.x][p.y] + 1; // 토마토 익히기
						q.add(new Point(nr, nc));
					}
				}
			}
		}
	}

}
