import java.awt.Point;
import java.io.*;
import java.util.*;

public class b2583 {
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, -1, 0, 1};

	private static int M;
	private static int N;
	private static int K;
	private static int[][] map;
	private static int cnt;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// input
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			
			for (int r = lx; r < rx; r++) {
				for (int c = ly; c < ry; c++) {
					map[r][c] = 1; // 직사각형을 1로 표시
				}
			}
		}
		
		// logic
		List<Integer> ans = new ArrayList<Integer>(); // 분리된 영역의 넓이를 저장할 리스트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) { // 직사각형이 없으면
					cnt = 0;
					dfs(i, j); // dfs로 탐색
					ans.add(cnt); // 영역의 넓이를 리스트에 저장
				}
			}
		}
		
		Collections.sort(ans); // 오름차순으로 정렬
		
		// output
		System.out.println(ans.size()); // 영역의 개수 출력
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " "); // 각 영역의 넓이 출력
		}
	}

	private static void dfs(int i, int j) {
		map[i][j] = 1; // 확인한 영역은 1로 만듦
		cnt++;
		
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) { // 범위 내에 있고 빈 칸이면
				dfs(nr, nc); // 해당 영역을 기준으로 재탐색
			}
		}
	}

}
