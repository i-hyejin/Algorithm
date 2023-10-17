import java.io.*;
import java.util.*;
import java.awt.Point;

public class b10026 {

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	private static int N;
	private static int[][] rgbMap;
	private static int[][] rrbMap;
	private static boolean[][] rgbV;
	private static boolean[][] rrbV;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		N = Integer.parseInt(br.readLine());
		
		rgbMap = new int[N][N]; // 적록색약이 아닌 사람이 보는 맵
		rrbMap = new int[N][N]; // 적록색약인 사람이 보는 맵
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = s.charAt(j);
				switch(c){
				case 'R':
					rgbMap[i][j] = 1;
					rrbMap[i][j] = 1;
					break;
				case 'G':
					rgbMap[i][j] = 2;
					rrbMap[i][j] = 1;
					break;
				case 'B':
					rgbMap[i][j] = 3;
					rrbMap[i][j] = 3;
					break;
				}
			}
		}
		
		// logic
		int rgbCnt = 0;
		int rrbCnt = 0;
		
		rgbV = new boolean[N][N]; // 적록색약이 아닌 사람이 방문한 그림
		rrbV = new boolean[N][N]; // 적록색약인 사람이 방문한 그림
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!rgbV[i][j]) { // 방문 안했으면
					rgb(i, j); // bfs로 탐색
					rgbCnt++; // 하나 발견
				}
				if(!rrbV[i][j]) { // 방문 안했으면
					rrb(i, j); // bfs로 탐색
					rrbCnt++; // 하나 발견
				}
			}
		}
		
		// output
		System.out.println(rgbCnt + " " + rrbCnt);
	}


	private static void rgb(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(r, c));
		rgbV[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !rgbV[nr][nc] && rgbMap[nr][nc] == rgbMap[r][c]) {
					rgbV[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
			
		}
	}
	
	private static void rrb(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(r, c));
		rrbV[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !rrbV[nr][nc] && rrbMap[nr][nc] == rrbMap[r][c]) {
					rrbV[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
			
		}
	}

}
