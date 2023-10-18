import java.io.*;
import java.util.*;
import java.awt.Point;

public class b5427 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	private static int w;
	private static int h;
	private static int[][] map;
	private static Queue<Point> person;
	private static Queue<Point> fire;
	private static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		
		for (int t = 1; t <= T; t++) {
			// input
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 너비
			h = Integer.parseInt(st.nextToken()); // 높이
			map = new int[h][w];
			person = new ArrayDeque<Point>();
			fire = new ArrayDeque<Point>();
			
			for (int i = 0; i < h; i++) {
				String s = br.readLine();
				for (int j = 0; j < w; j++) {
					char c = s.charAt(j);
					switch(c) {
					case '#': // 벽
						map[i][j] = -1;
						break;
					case '.': // 빈 공간
						map[i][j] = 0;
						break;
					case '@': // 상근이의 시작 위치
						map[i][j] = 1;
						person.offer(new Point(i,j));
						break;
					case '*': // 불
						map[i][j] = -2;
						fire.offer(new Point(i, j));
						break;
					}
				}
			}
			
			// logic
			ans = 0;
			bfs();
			
			// output
			if(ans == -1) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(ans);
			}
		}

	}

	private static void bfs() {
		while(true) {
			ans++;
			
			// 불 이동
			int fireSize = fire.size();
			while(fireSize > 0) {
				fireSize--;
				Point p = fire.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = p.x + dr[d];
					int nc = p.y + dc[d];
					if(nr >= 0 && nr < h && nc >= 0 && nc < w) {
						if(map[nr][nc] >= 0) { // 빈 칸 일때만
							fire.add(new Point(nr, nc));
							map[nr][nc] = -2; // 불이 퍼짐
						}
					}
				}
			}
			
			// 상근 이동
			int personSize = person.size();
			while(personSize > 0) {
				personSize--;
				Point p = person.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = p.x + dr[d];
					int nc = p.y + dc[d];
					if(nr >= 0 && nr < h && nc >= 0 && nc < w) {
						if(map[nr][nc] == 0) { // 빈 칸이면 이동 가능
							person.offer(new Point(nr, nc));
							map[nr][nc] = 1;
						}
					} 
					else { // 탈출
						return;
					}
				}
			}
			
			// 상근 큐가 비어 있으면
			if(person.isEmpty()) {
				ans = -1;
				return;
			}
		}
	}

}
