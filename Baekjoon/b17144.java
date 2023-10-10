import java.io.*;
import java.util.*;

public class b17144 {

	private static int R;
	private static int C;
	private static int T;
	private static int[][] map;
	private static int ans;
	private static int[] machine;

	private static int dr[] = {-1, 0, 1, 0};
	private static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// input
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		T = Integer.parseInt(st.nextToken()); // 시간
		map = new int[R][C]; // 방의 정보
		machine = new int[2]; // 공기청정기 위치 정보
		int idx = 0; // 공기청정기 인덱스
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) { // 공기청정기 위치
					machine[idx] = i;
					idx++;
				}
			}
		}
		ans = 0; // 남아있는 미세먼지의 양
		
		// logic
		for (int t = 0; t < T; t++) {
			// 1. 미세먼지 확산
			DiffuseDust();
			
			// 2. 공기청정기 작동
			ActivateMachine();
		}
			
		// output
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans += map[i][j]; // 남아있는 미세먼지 더하기
			}
		}
		System.out.println(ans + 2); // 공기청정기 값 만큼 더해주기
	}

	private static void DiffuseDust() {
		int dust[][] = new int[R][C]; // 먼지
		
		// 네 방향으로 확산
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0) { // 먼지가 있으면
					int cnt = 0; // 확산된 방향의 개수
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
							cnt++;
							dust[nr][nc] += (map[i][j] / 5);
						}
					}
					dust[i][j] += (map[i][j] - (map[i][j] / 5) * cnt); // 확산되는 값
				}
			}
		}		
		
		// 확산된 값으로 업데이트
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = dust[i][j];
			}
		}
		
		// 공기청정기 돌려두기
		for (int i = 0; i < machine.length; i++) {
			map[machine[i]][0] = -1;
		}
		
	}
	
	private static void ActivateMachine() {
		// 첫번째 공기청정기
		int r = machine[0];
		
		// 1. 아래로 옮기기
		for (int i = r - 1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		// 2. 왼쪽으로 옮기기
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i+1];
		}
		// 3. 위로 옮기기
		for (int i = 0; i < r; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		// 4. 오른쪽으로 옮기기
		for (int i = C - 1; i > 1; i--) {
			map[r][i] = map[r][i-1];
		}
		map[r][1] = 0;
		
		// 두번째 공기청정기
		r = machine[1];
		
		// 1. 위로 옮기기
		for (int i = r + 1; i < R - 1; i++) {
			map[i][0] = map[i+1][0];
		}
		// 2. 왼쪽으로 옮기기
		for (int i = 0; i < C - 1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		// 3. 아래로 옮기기
		for (int i = R - 1; i > r; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		// 4. 오른쪽으로 옮기기
		for (int i = C - 1; i > 1; i--) {
			map[r][i] = map[r][i-1];
		}
		map[r][1] = 0;
	}
	
	

}
