import java.io.*;
import java.util.*;

public class b11048 {
	
	static int[] dr = {1, 0, 1};
	static int[] dc = {0, 1, 1};

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] dist = new int[N][M];
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = map[i][j]; // 같은 값으로 초기화
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int d = 0; d < dr.length; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
						dist[nr][nc] = Math.max(dist[nr][nc], map[nr][nc] + dist[i][j]); // 두 값 비교해서 큰 값 넣기
					}
				}
			}
		}
		
		System.out.println(dist[N-1][M-1]); // 마지막 지점의 경우의 수 출력
	}
}
