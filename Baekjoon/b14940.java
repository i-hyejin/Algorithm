import java.awt.Point;
import java.io.*;
import java.util.*;

class Pos{
	int r, c, cnt;
	
	public Pos(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class b14940 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] v = new int[N][M];
		
		Pos start = new Pos(0, 0, 0);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) { // 목표 지점 설정
					start.r = i;
					start.c = j;
					start.cnt = 0;
				} 
				else if(map[i][j] == 1) { // 갈 수 있는 땅
					v[i][j] = -1; // 도달할 수 없으면 -1
				}
			}
		}
		
		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(start); // 시작 지점 추가
		
		while(!q.isEmpty()) { // 큐가 빌 때까지
			Pos p = q.poll(); // 큐에서 하나 꺼내기
			for (int i = 0; i < 4; i++) { // 사방탐색
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				// 범위 내에 있고, 갈 수 있는 땅이며, 아직 안 갔으면
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && v[nr][nc] == -1) {
					v[nr][nc] = p.cnt + 1;
					q.offer(new Pos(nr, nc, p.cnt + 1));
				}
			}
		}
		
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(v[i][j]).append(" "); 
			}
			sb.append("\n");
		}		
		System.out.println(sb);
	}

}
