import java.io.*;
import java.util.*;

public class b2667 {
	static class Pos{
		int r;
		int c;
		
		public Pos(int x, int y) {
			this.r = x;
			this.c = y;
		}
	}

	private static int N;
	private static int[][] map;
	private static boolean[][] v;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		N = Integer.parseInt(br.readLine()); // 지도의 크기
		map = new int[N][N]; // 지도
		v = new boolean[N][N]; // 방문 여부
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		List<Integer> list = new ArrayList<>(); // 단지별 번호
		
		// logic
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !v[i][j]) { // 집이 있고 방문 전이면 탐색
					list.add(bfs(i, j)); 
				}
			}
		}
		
		// output
		System.out.println(list.size()); // 단지 개수 출력
		if(list.size() > 0) { // 단지가 있으며 단지별 번호 출력
			Collections.sort(list); // 오름차순 정렬
			for (Integer l : list) {
				System.out.println(l);
			}
		}
	}

	private static int bfs(int i, int j) {
		Queue<Pos> q = new ArrayDeque<>();
		q.add(new Pos(i, j));
		v[i][j] = true;
		int danji = 1;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for (int d = 0; d < 4; d++) { // 사방탐색
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1 && !v[nr][nc]) {
					v[nr][nc] = true;
					danji++;
					q.add(new Pos(nr, nc));
				}
			}
		}
		
		return danji; // 단지 수 반환
	}

}
