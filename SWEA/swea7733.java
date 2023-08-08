import java.awt.Point;
import java.io.*;
import java.util.*;

public class swea7733 {
	private static int N;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int ans = 0; // 최대 덩어리의 개수
			N = Integer.parseInt(br.readLine()); // 치즈의 한 변의 길이
			arr = new int[N][N]; // 치즈 맛
			int maxDay = 0; // 100일 중 치즈가 다 사라지는 날
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
			for(int day = 0; day <= 100; day++) { // 100일 동안
				int temp = 0;
				visited = new boolean[N][N]; // 방문 여부
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(arr[i][j] > day && !visited[i][j]) {
							visited[i][j] = true;
							dfs(i, j, day);
							temp++;
						}
					}
				}
				ans = Math.max(ans, temp);			
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void dfs(int r, int c, int day) {
		// basis part
		
		// inductive part
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] > day) { // 범위 내에 안 먹은 치즈이면
				if(!visited[nr][nc]) { // 방문 전이면
					visited[nr][nc] = true;
					dfs(nr, nc, day);
				}
			}
		}
	}
}
