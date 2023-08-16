import java.awt.Point;
import java.io.*;
import java.util.*;

class Pos{
	int r;
	int c;
	int cnt;
	
	public Pos(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class swea7793 {
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, -1, 0, 1};
	private static int N;
	private static int M;
	private static char[][] map;
	private static Queue<Pos> q;
	private static Queue<Point> devils;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M]; // 지도 정보
			devils = new LinkedList<Point>(); // 악마 이동 큐
			q = new LinkedList<Pos>(); // 수연 이동 큐
			ans = 0;
			
			for (int i = 0; i < N; i++) {				
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == 'S') { // 수연 좌표 저장
						q.offer(new Pos(i, j, 0));
					}
					if(map[i][j] == '*') { // 악마 좌표 저장
						devils.offer(new Point(i, j));
					}
				}
			}
			
			bfs(); // bfs로 탐색
			
			if(ans > 0) { // 0보다 크면 정답 입력
				System.out.println("#" + t + " " + ans);				
			} else { // 0이거나 0보다 작으면 GAME OVER
				System.out.println("#" + t + " GAME OVER");
			}
			
			
		}
	}

	private static void bfs() {
		int size = 0;
		
		while(!q.isEmpty()) {
			// 악마 이동
			size = devils.size(); // 악마 사이즈 따로 저장(추가하면서 사이즈가 바뀌기 때문에)
			for (int i = 0; i < size; i++) {
				Point p = devils.poll(); // 하나 꺼내고
				for (int d = 0; d < 4; d++) { // 사방탐색
					int nr = p.x + dr[d];
					int nc = p.y + dc[d];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M) { // 범위 내에 있고
						if(map[nr][nc] == '.' || map[nr][nc] == 'S') { // 평범한 지역이거나 수연이가 있는 위치이면
							map[nr][nc] = '*'; // 악마의 손아귀 확장
							devils.offer(new Point(nr, nc)); // 큐에 추가
						}
					}
				}
			}
			
			size = q.size(); // 큐 사이즈 따로 저장(추가하면서 사이즈가 바뀌기 때문에)
			for (int i = 0; i < size; i++) {
				Pos p = q.poll(); // 하나 꺼내고
				for (int d = 0; d < 4; d++) { // 사방탐색
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M) { // 범위 내에 있고
						if(map[nr][nc] == 'D') { // 여신의 공간이면
							ans = p.cnt + 1; // 현재 cnt에서 1 추가해서 ans에 저장
							return;
						} else if(map[nr][nc] == '.') { // 평범한 지역이면
							map[nr][nc] = 'S'; // 수연이의 위치 이동
							q.offer(new Pos(nr, nc, p.cnt + 1)); // 큐에 추가
						}
					}
				}
			}
		}
	}
}