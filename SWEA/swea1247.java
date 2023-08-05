import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1247 {
	static int N;
	static int[][] map;
	static int[][] sel;
	static int[] com;
	static int[] home;
	static boolean[] v;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			com = new int[2];
			com[0] = Integer.parseInt(st.nextToken());
			com[1] = Integer.parseInt(st.nextToken());
			home = new int[2];
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			map = new int[N][2]; // 회사, 집, N명의 고객
			for (int i = 0; i < map.length; i++) {
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			ans = Integer.MAX_VALUE;
			
			// 회사 - N명의 고객 - 집 (순열)
			sel = new int[N][2];
			v = new boolean[N];
			recursive(0);
			
			System.out.printf("#%d %d\n", t, ans);
		}
		

	}
	private static void recursive(int idx) {
		// basis part
		if(idx == sel.length) {
			int temp = 0;
			temp += getDistance(com[0], com[1], sel[0][0], sel[0][1]);
			for(int i = 0; i < sel.length-1; i++) {
				temp += getDistance(sel[i][0], sel[i][1], sel[i+1][0], sel[i+1][1]);
			}
			temp += getDistance(home[0], home[1], sel[sel.length-1][0], sel[sel.length-1][1]);
			ans = Math.min(ans, temp);
			
			return;
		}
		
		// inductive part
		for(int i = 0; i < N; i++) { // 고객 거리만 구하면 됨
			if(v[i] == false) {
				v[i] = true;
				sel[idx][0] = map[i][0];
				sel[idx][1] = map[i][1];
				recursive(idx+1);
				v[i] = false;
			}
		}
	}
	
	private static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}

}
