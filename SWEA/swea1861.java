import java.io.*;
import java.util.*;

public class swea1861 {

	private static Ans ans;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int N;
	private static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 하나의 정수
			arr = new int[N][N]; // 방
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = new Ans(Integer.MAX_VALUE, 0); // 정답
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, arr[i][j], 1); // 모든 점에 대해서 dfs 탐색
				}
			}

			System.out.println("#" + t + " " + ans.pos + " " + ans.cnt);
		}
		
	}
	
	private static class Ans implements Comparable<Ans>{ // 비교 가능한 class로 생성
		int pos, cnt;
		
		public Ans(int pos, int cnt) {
			this.pos = pos;
			this.cnt = cnt;
		}
		
		public int compareTo(Ans o) {
			if(this.cnt == o.cnt) { // 이동할 수 있는 방의 개수가 최대인 방이 여러 개라면
				return pos - o.pos; // 위치가 가장 작은 것
			}
			return o.cnt - this.cnt; // 이동할 수 있는 방의 개수가 최대인 것 
		}
	}

	private static void dfs(int r, int c, int start, int cnt) { // 출발 좌표, 시작 값, 몇 개 방 지나왔는지
		// basis part
		Ans res = new Ans(start, cnt);
		if(ans.compareTo(res) > 0) { // res가 ans보다 크면
			ans = res;
		}
		
		// inductive part
		for (int d = 0; d < 4; d++) { // 사방탐색
			int nr = r + dr[d];
			int nc = c+  dc[d];
			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if(arr[nr][nc] == arr[r][c] + 1) {
					dfs(nr, nc, start, cnt+1);
				}
			}
		}
	}

}
