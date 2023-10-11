import java.io.*;
import java.util.*;

public class swea2115 {
	static boolean[] sel;
	private static int N;
	private static int M;
	private static int C;
	private static int[][] map;
	private static boolean[][] v;
	private static int[][] worker;
	private static boolean[] selected;
	private static int[] profit;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int t = 1; t <= T; t++) {
			// input
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 벌통 크기
			M = Integer.parseInt(st.nextToken()); // 선택 가능한 벌꿀 개수
			C = Integer.parseInt(st.nextToken()); // 최대 양
			map = new int[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			worker = new int[2][M]; // 두 일꾼이 선택한 벌꿀
			selected = new boolean[M]; // 벌꿀 선택 여부
			ans = 0; // 최대 수익
			
			// logic
			selectHoney(v, 0, 0);
			
			// output
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void selectHoney(boolean[][] v, int start, int k) {
		if(k == 2) {
			profit = new int[2];
			
			for (int i = 0; i < 2; i++) {
				combination(i, 0, 0);
			}
			
			int total = profit[0] + profit[1];
			ans = Math.max(ans, total);
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(j + M - 1 >= N) continue;
				
				for (int l = 0; l < M; l++) {
					if(v[i][j+l]) continue;
				}
				
				for (int l = 0; l < M; l++) {
					v[i][j+l] = true;
					worker[k][l] = map[i][j+l];
				}
				
				selectHoney(v, start, k+1);
				for (int l = 0; l < M; l++) {
					v[i][j+l] = false;
				}
				
			}
		}
	}

	private static void combination(int workerNum, int sum, int m) {
		profit[workerNum] = Math.max(profit[workerNum], m);
		
		for (int i = 0; i < M; i++) {
			if(selected[i]) continue;
			
			if(sum + worker[workerNum][i] <= C) {
				selected[i] = true;
				combination(workerNum, sum + worker[workerNum][i], m + worker[workerNum][i] * worker[workerNum][i]);
				selected[i] = false;
			}
		}
	}

	

}
