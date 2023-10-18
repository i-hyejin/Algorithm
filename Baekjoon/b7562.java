import java.io.*;
import java.util.*;
import java.awt.Point;

public class b7562 {
	static class Pos{
		int r, c, cnt;
		
		Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int[] dr = {2, 1, -1, -2, -2, -1, 1, 2};
	static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
	
	private static int L;
	private static Point prev;
	private static Point next;
	private static int ans;
	private static boolean[][] v;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이슷의 개수
		for (int t = 1; t <= T; t++) {
			// input
			L = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이
			st = new StringTokenizer(br.readLine());
			prev = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			next = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			// logic
			v = new boolean[L][L]; // 방문 여부
			ans = Integer.MAX_VALUE; // 정답 최대값으로 초기화
			bfs(); // bfs 탐색
			
			// output
			System.out.println(ans);
		}
	}

	private static void bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(prev.x, prev.y, 0)); // 처음은 0으로 시작
		v[prev.x][prev.y] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.r == next.x && p.c == next.y) { // 도착 지점까지 도착하면
				ans = Math.min(ans, p.cnt); // ans 중에 최소값 찾기
			}
			
			for (int d = 0; d < 8; d++) { // 팔방탐색
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr >= 0 && nr < L && nc >= 0 && nc < L && !v[nr][nc]) {
					q.add(new Pos(nr, nc, p.cnt + 1)); // 이동할 때마다 1 추가
					v[nr][nc] = true;
				}
			}
		}
	}

}
