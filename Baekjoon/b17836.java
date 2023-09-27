import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int r;
	int c;
	int cnt;
	int gram;
	
	Point(int r, int c, int cnt, int gram) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.gram = gram;
	}
}

public class b17836 {

	private static int N;
	private static int M;
	private static int T;
	private static int[][] map;
	private static int ans;
	private static boolean[][] v;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 성의 크기
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); // 저주의 제한 시간
		map = new int[N][M]; // 성
		v = new boolean[N][M]; // 방문 여부
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		
		bfs();
		
		if(ans <= T) { // T 시간 내에 구할 수 있으면
			System.out.println(ans);
		} else { // T 시간 내에 구할 수 없으면
			System.out.println("Fail");
		}
		
	}

	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(0, 0, 0, 0));
		v[0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			// 그람을 만나면
			if(map[p.r][p.c] == 2) {
				ans = Math.min(ans, p.cnt + (N - p.r -1) + (M - p.c -1)); 
			}
			
			// 공주를 만나면
			if(p.r == N-1 && p.c == M-1) {
				ans = Math.min(ans, p.cnt);
				break;
			}
			
			for (int d = 0; d < dr.length; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]) {
					// 그람을 만나면
					if(map[nr][nc] == 2) {
						q.offer(new Point(nr, nc, p.cnt+1, 1));
					}
					// 벽이 아니면
					else if(map[nr][nc] == 0) {
						v[nr][nc] = true;
						q.offer(new Point(nr, nc, p.cnt+1, p.gram));
					}
					// 벽이지만 그람이 있는 경우
					else if(map[nr][nc] == 1 && p.gram == 1) {
						v[nr][nc] = true;
						q.offer(new Point(nr, nc, p.cnt+1, p.gram));
					}
				}
			}
		}
	}

}