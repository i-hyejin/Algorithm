import java.awt.Point;
import java.io.*;
import java.util.*;

public class b15683 {

	static class CCTV {
		int r;
		int c;
		int num;

		public CCTV(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}

	private static int wall;
	private static boolean[][] v;
	private static ArrayList<CCTV> list;
	private static int ans;
	
	private static int[] dr = { 0, 1, 0, -1 };
	private static int[] dc = { 1, 0, -1, 0 };
	private static boolean[][][] cctv = { { { false, false, false, false } }, // 0일 때

										{ { true, false, false, false }, // 1일 때
										{ false, true, false, false }, 
										{ false, false, true, false }, 
										{ false, false, false, true } },
						
										{ { true, false, true, false }, // 2일 때
											{ false, true, false, true } },
						
										{ { true, false, false, true }, // 3일 때
											{ true, true, false, false }, 
											{ false, true, true, false }, 
											{ false, false, true, true } },
							
										{ { true, false, true, true }, // 4일 때
											{ true, true, false, true }, 
											{ true, true, true, false }, 
											{ false, true, true, true } },
						
										{ { true, true, true, true }}}; // 5일 때 
	static int[][] status = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 0, 1, 2, 3 }, { 0, 1, 2, 3 }, { 0 } };
	
	private static int N;
	private static int M;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로의 크기
		M = Integer.parseInt(st.nextToken()); // 가로의 크기
		map = new int[N][M]; // 사무실의 정보

		list = new ArrayList<CCTV>(); // cctv 리스트
		wall = 0; // 벽의 개수
		ans = 0; // cctv로 감시 가능한 최대 거리

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 칸의 정보
				
				if (map[i][j] == 6) { // 벽이면
					wall += 1;
				} 
				else if (map[i][j] > 0) { // CCTV 이면
					list.add(new CCTV(i, j, map[i][j])); // list에 추가하기
				}
			}
		}
		
		// CCTV별 경우의 수 만들고 CCTV 가능한 최대 거리 구하기
		recursive(new int[list.size()], 0);
		
		// N*M 크기에서 CCTV로 가능한 최대 거리, 벽, CCTV의 개수 빼기
		System.out.println(N * M - ans - wall - list.size());

	}

	
	// cctv의 개수에 따라 가능한 방향을 조합하는 경우의 수
	private static void recursive(int[] sel, int idx) {
		if (idx == list.size()) { // cctv의 개수대로 다 찾았으면
			moveCCTV(sel); // moveCCTV에서 가능한 거리 구하기
			return;
		}
		
		for (int i = 0; i < status[list.get(idx).num].length; i++) { // 각 CCTV 별로 가능한 거리 구하기
			sel[idx] = status[list.get(idx).num][i];
			recursive(sel, idx + 1);
		}
	}
	
	// cctv를 움직여서 가려진 사각지대의 최소 거리 찾기
	private static void moveCCTV(int[] sel) {
		int cnt = 0; // cctv로 가릴 수 있는 거리 개수
		boolean[][] visited = new boolean[N][M]; // 방문 여부
		
		for (int j = 0; j < list.size(); j++) { // cctv의 개수만큼 반복
			
			for (int d = 0; d < 4; d++) { // 사방향 탐색
				boolean flag = true;
				int nr = list.get(j).r; // 새로운 좌표
				int nc = list.get(j).c;
				visited[nr][nc] = true; // 방문 처리
				
				while(cctv[list.get(j).num][sel[j]][d] && flag) { // cctv의 경우 방향이 true이면
					nr += dr[d]; // 새로운 좌표 탐색
					nc += dc[d];
					
					// 범위 내 && 빈 칸 && -> 방문 전이면 방문 처리하고 cnt +1 하기
					if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
						if(!visited[nr][nc]) // 방문 전이면
							cnt += 1; 
						visited[nr][nc] = true; // 방문 처리
					}
					// 범위 내 && 벽이면 -> 방문 처리하고 그만
					else if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 6) {
						visited[nr][nc] = true; 
						flag = false; 
						break;
					}
					// 범위 내 && 다른 CCTV 존재 -> CCTV는  나중에 따로 계산
					else if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] > 0) {
						visited[nr][nc] = true;
					}
					// 범위를 벗어난 경우
					else {
						flag = false;
						break;
					}
				}
			}
		}
	
		ans = Math.max(ans, cnt); // 최대값 구하기
		
	}

}
