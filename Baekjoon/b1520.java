import java.io.*;
import java.util.*;

public class b1520 {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	private static int M;
	private static int N;
	private static int[][] map;
	private static int ans;
	private static int[][] dist;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dist = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = -1; // -1로 초기화
			}
		}
		ans = 0;
		
		System.out.println(dfs(0, 0));
	}

	private static int dfs(int r, int c) {
		if(r == M-1 && c == N-1) { // 마지막 지점에 도달하면 종료
			return 1;
		}
		
		if(dist[r][c] != -1) { // 마지막 지점이 -1이 아니면 경로의 수 반환
			return dist[r][c];
		}
		
		dist[r][c] = 0; // 현재 위치에서 마지막 지점까지 가는 거리를 0으로 초기화
		for (int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < M && nc >= 0 && nc < N) {
				if(map[r][c] > map[nr][nc]) { // 주변 높이가 더 낮으면
					dist[r][c] += dfs(nr, nc); // 주변 높이부터 마지막 지점까지 탐색
				}
			}
		}
		
		return dist[r][c]; // 현재 좌표의 거리 경우의 수 반환
	}

}
