import java.awt.Point;
import java.io.*;
import java.util.*;

public class b17143 {
	static class Shark{
		int r, c, s, d, z;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static int[] dr = {-1, 0, 1, 0}; // 상,좌,하,우
	static int[] dc = {0, -1, 0, 1};
	private static int R;
	private static int C;
	private static Shark[][] map;

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); // 격자판의 크기
		C = sc.nextInt();
		map = new Shark[R][C]; // 격자판
		int M = sc.nextInt(); // 상어의 수
		int ans = 0; // 잡은 상어 크기의 합

		for (int i = 1; i <= M; i++) {
			int r = sc.nextInt()-1; // 상어의 위치
			int c = sc.nextInt()-1;
			int s = sc.nextInt(); // 속력
			int d = sc.nextInt(); // 이동 방향
			int z = sc.nextInt(); // 크기
			
			// 방향 바꾸기 (상하좌우->상좌하우)
			if(d == 1) d = 0;
			else if(d == 4) d = 1;
			
			map[r][c] = new Shark(r, c, s, d, z); // 상어의 정보 저장
		}
		
		for (int col = 0; col < C; col++) { // 낚시왕 이동
			// 1. 낚시왕이 오른쪽으로 한 칸 이동한다
			// 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다
			for(int row = 0; row < R; row++) {
				if(map[row][col] != null) {
					ans += map[row][col].z; // 잡은 상어의 크기 더하기
					map[row][col] = null; // 상어를 잡았으니 null로 변경
					break; // 한 마리 잡았으니 반복문 종료
				}
			}
			
			// 3. 상어가 이동한다
			Queue<Shark> q = new LinkedList<>(); // 상어를 저장할 큐
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] != null) { // 상어가 있으면 큐에 저장하기
						q.add(new Shark(i, j, map[i][j].s, map[i][j].d, map[i][j].z));
					}
				}
			}
			
			// 상어 저장한 맵 초기화
			map = new Shark[R][C];
			while(!q.isEmpty()) {
				Shark p = q.poll(); // 큐에서 하나씩 꺼내기
				int speed = p.s; // 이동 속도
				
				// 방향 바꾸기
				if(p.d == 0 || p.d == 2) { // 상, 하
					speed %= (R-1) * 2;
				} else if(p.d == 1 || p.d == 4) { // 좌, 우
					speed %= (C-1) * 2;
				}
				
				// 이동하기
				for (int s = 0; s < speed; s++) {
					int nr = p.r + dr[p.d];
					int nc = p.c + dc[p.d];
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) { // 범위를 벗어나면
						// 1) 위치 되돌아가기
						p.r -= dr[p.d]; 
						p.c -= dc[p.d];
						// 2) 방향 반대로 바꾸기
						p.d = (p.d + 2) % 4;
						continue;
					}
					
					p.r = nr;
					p.c = nc;
				}
				
				// 상어 있는지 확인
				if(map[p.r][p.c] != null) { // 상어가 있다면
					if(map[p.r][p.c].z < p.z) { // 기존 상어보다 현재 상어의 크기가 크면
						map[p.r][p.c] = new Shark(p.r, p.c, p.s, p.d, p.z); // 현재 상어로 넣기 
					}
				} else { // 상어가 없다면
					map[p.r][p.c] = new Shark(p.r, p.c, p.s, p.d, p.z); // 현재 상어로 넣기
				}
			}
			
		} // 낚시왕 이동 끝
		
		System.out.println(ans);
		
	}

}
