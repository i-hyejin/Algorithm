import java.io.*;
import java.util.*;

public class swea2105 {
	
	private static boolean[] flag;
	private static int N;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 한 변의 길이
			map = new int[N][N]; // 지역
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			flag = new boolean[101]; // 디저트 종류 방문 여부
			int ans = -1; // 디저트를 먹을 수 없는 경우
			
			// 대각선으로 갈 수 있는 모든 장소를 탐색
			for (int r = 0; r < N-2; r++) {
				for (int c = 1; c < N-1; c++) {
					for (int w = 1; r+w<N && c+w<N; w++) {
						for (int h = 1; r+h<N && c-h>=0; h++) {
							int cnt = go(r, c, w, h);
							if(ans < cnt) ans = cnt;
						}
					}
					
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static int go(int r, int c, int w, int h) {
		for (int i = 0; i < flag.length; i++) {
			flag[i] = false;
		}
		
		for (int i = 0; i <= w; i++) {
			if (flag[map[r+i][c+i]]) return -1;
			flag[map[r+i][c+i]] = true;
			if (flag[map[r+h+i][c-h+i]]) return -1;
			flag[map[r+h+i][c-h+i]] = true;
		}
		
		for (int i = 1; i < h; i++) { 
			if (flag[map[r+i][c-i]]) return -1;
			flag[map[r+i][c-i]] = true;
			if (flag[map[r+w+i][c+w-i]]) return -1;
			flag[map[r+w+i][c+w-i]] = true;
		}
		
		return (w + h) * 2;
	}

}
