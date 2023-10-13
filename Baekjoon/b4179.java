import java.io.*;
import java.util.*;

public class b4179 {
	static class Pos{
		int r, c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	private static int R;
	private static int C;
	private static int[][] map;
	private static int ans;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// input
		R = Integer.parseInt(st.nextToken()); // 행의 개수
		C = Integer.parseInt(st.nextToken()); // 열의 개수
		map = new int[R][C]; // 미로
		Queue<Pos> jq = new ArrayDeque<Pos>(); // 지훈 위치 큐
		Queue<Pos> fq = new ArrayDeque<Pos>(); // 불 위치 큐
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = s.charAt(j);
				if(c == '#') 
					map[i][j] = -1; // 벽
				else if(c == '.') 
					map[i][j] = 0; // 빈칸
				else if(c == 'J') {
					jq.offer(new Pos(i, j)); // 지훈
					map[i][j] = 1;
				}
				else if(c == 'F') {
					fq.offer(new Pos(i, j));
					map[i][j] = -2; // 불
				}
			}
		}
		
		ans = 0;
		
		// logic
		while(true) {
			ans++;
			
			// 불 큐
			int fs = fq.size();
			while(fs > 0) { // 사이즈만큼만 움직임(1초)
				fs--;
				Pos fp = fq.poll();
				for (int d = 0; d < 4; d++) {
					int nr = fp.r + dr[d];
					int nc = fp.c + dc[d];
					if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
						if(map[nr][nc] >= 0) { // 0보다 클 때만 움직이기 가능
							fq.add(new Pos(nr, nc));
							map[nr][nc] = -2;
						}
					}
				}
			}
			
			// 지훈 큐
			int js = jq.size();
			while(js > 0) { // 사이즈만큼만 움직임(1초)
				js--;
				Pos jp = jq.poll();
				for (int d = 0; d < 4; d++) {
					int nr = jp.r + dr[d];
					int nc = jp.c + dc[d];
					if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
						if(map[nr][nc] == 0) { // 0일 때만 움직이기 가능
							jq.offer(new Pos(nr, nc));
							map[nr][nc] = 1;
						}
					} else { // 범위를 벗어나면 탈출로 가정
						System.out.println(ans);
						return;
					}
				}
			}
			
			// 지훈 큐가 비어 있으면 불에 탐..
			if(jq.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				return;
			}
		}
	}
}
