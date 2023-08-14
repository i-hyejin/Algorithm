import java.awt.Point;
import java.io.*;
import java.util.*;

public class swea1953 {
	
	private static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	private static int[] dc = {0, 0, -1, 1}; 
	
	private static int[][] dir = {{}, // 0 터널없음
								{0, 1, 2, 3}, // 1 상하좌우
								{0, 1}, // 2 상하
								{2, 3}, // 3 좌우
								{0, 3}, // 4 상우
								{1, 3}, // 5 하우
								{1, 2}, // 6 하좌
								{0, 2} // 7 상좌		
	};
					   	  // [나의 방향 0~3][터널 구조물 타입]
	private static boolean[][] check = {{false, true, true, false, false, true, true, false}, // 상 0, 1, 1, 0, 0, 1, 1, 0
										{false, true, true, false, true, false, false, true}, // 하 0, 1, 1, 0, 1, 0, 0, 1
										{false, true, false, true, true, true, false, false}, // 좌 0, 1, 0, 1, 1, 1, 0, 0
										{false, true, false, true, false, false, true, true}}; // 우  0, 1, 0, 1, 0, 0, 1, 1
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 세로 크기
			int M = Integer.parseInt(st.nextToken()); // 가로 크기
			int R = Integer.parseInt(st.nextToken()); // 맨홀 세로 위치
			int C = Integer.parseInt(st.nextToken()); // 맨홀 가로 위치
			int L = Integer.parseInt(st.nextToken()); // 탈출 소요 시간
			int[][] map = new int[N][M]; // 맵
			boolean[][] visited = new boolean[N][M]; // 방문 여부
			int ans = 0; // 탈주범이 위치할 수 있는 장소의 개수
			
			for (int i = 0; i < N; i++) { // 터널 정보 받기
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int time = 0; // 시간
			
			Queue<Point> q = new LinkedList<Point>(); // 큐 생성
			ans++; // 장소 하나 추가
			visited[R][C] = true; // 방문 처리
			q.offer(new Point(R, C)); // 초기 좌표 넣기
			time += 1;
			
			while(!q.isEmpty()) { // 큐가 비어있을 때까지
				
				if(time == L) break; // time이 L과 같으면 중단
				
				int size = q.size(); // 현재 큐에 들어 있는 개수만 반복
				for (int i = 0; i < size; i++) {
					Point p = q.poll(); // 하나 꺼내기
					int type = map[p.x][p.y]; // 터널 구조물 타입
					
					for (int j = 0; j < dir[type].length; j++) { // dir[type]만큼 반복
						int nr = p.x + dr[dir[type][j]]; // 새로운 좌표
						int nc = p.y + dc[dir[type][j]];
						if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] > 0) { // 범위 내에 있고, 방문 전이면
							if(check[dir[type][j]][map[nr][nc]]) { // 연결 가능한 터널이면
								ans++;
								visited[nr][nc] = true;
								q.offer(new Point(nr, nc));
							}
						}
					}
				}
				
				time++;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
