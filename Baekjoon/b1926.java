import java.io.*;
import java.util.*;

public class b1926 {
	static class Picture{
		int r, c;
		
		public Picture(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static int dr[] = {-1, 1, 0, 0};
	private static int dc[] = {0, 0, 1, -1};
	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[][] v;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// input
		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기
		map = new int[N][M]; // 도화지
		v = new boolean[N][M]; // 방문 여부
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0; // 그림의 개수
		int area = 0; // 가장 넓은 그림의 넓이
		
		// logic
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !v[i][j]) {
					cnt++; // 그림의 개수 1 추가
					area = Math.max(area, bfs(i, j)); // 저장된 값보다 크면 저장
				}
			}
		}
		
		// output
		System.out.println(cnt);
		System.out.println(area);
		
	}

	private static int bfs(int i, int j) {
		Queue<Picture> q = new LinkedList<Picture>();
		v[i][j] = true;
		int tmp = 1; // 그림의 넓이
		q.add(new Picture(i, j));
		
		while(!q.isEmpty()) {
			Picture p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 1) {
					tmp++; // 1 추가
					v[nr][nc] = true;
					q.add(new Picture(nr, nc));
				}
			}
		}
		
		return tmp;
	}

}
