import java.io.*;
import java.util.*;

public class b17136 {

	private static int[][] map;
	private static int ans = Integer.MAX_VALUE;
	private static int[] paper = {0, 5, 5, 5, 5, 5}; // 인덱스 1번부터 사용

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		
		if(ans == Integer.MAX_VALUE) { // 1을 덮는 것이 불가능하여 초기값이면
			System.out.println(-1); // -1 출력
		} else {
			System.out.println(ans); // 정답 출력
		}
	}

	private static void dfs(int r, int c, int cnt) {
		
		if(r >= 9 && c > 9) { // 세로도 모두 봤으면
			ans = Math.min(ans, cnt); // 정답 확인
			return;
		}
		
		if(ans <= cnt) { // 정답보다 cnt가 크면 탐색 안함
			return;
		}
		
		if(c > 9) { // 가로 모두 봤으면 세로로 한 칸 이동
			dfs(r+1, 0, cnt);
			return;
		}

		if(map[r][c] == 1) { // 색종이를 붙일 수 있으면
			for (int i = 5; i >= 1; i--) { // 색종이 당 5장까지 가능
				if(paper[i] > 0 && isAttached(r, c, i)) { // 색종이가 남아 있고 붙일 수 있으면
					attach(r, c, i, 0); // 색종이 붙이기
					paper[i]--; // 색종이 사용
					dfs(r, c+1, cnt+1); // 한 칸 옆으로 이동
					attach(r, c, i, 1); // 색종이 떼기
					paper[i]++; // 색종이 복원
				}
			}
		} else { // 색종이를 붙일 수 없으면 오른쪽으로 이동
			dfs(r, c+1, cnt);
		}
	}

	private static void attach(int r, int c, int size, int state) { // 색종이 붙이기
		for (int i = r; i < r+size; i++) { 
			for (int j = c; j < c+size; j++) {
				map[i][j] = state; // map[r][c] 자리에 state로 덮기
			}
		}
		
	}

	private static boolean isAttached(int r, int c, int size) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(i < 0 || i >= 10 || j < 0 || j >= 10 || map[i][j] != 1) { // 범위 밖으로 벗어나거나 색종이를 안 붙였으면
					return false;
				}
			}
		}
		
		return true;
	}

}
