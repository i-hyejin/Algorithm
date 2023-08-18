import java.io.*;
import java.util.*;

public class b1018 {

	private static boolean[][] map;
	private static int ans;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 세로
		map = new boolean[M][N]; // 체스판
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				if(s.charAt(j) == 'W') {
					map[i][j] = true;
				} else map[i][j] = false;
			}
		}

		ans = Integer.MAX_VALUE; 
		int temp = 0; // 다시 칠해야 하는 정사각형의 개수
		
		for (int i = 0; i <= M-8; i++) { // 8*8 체스판으로 잘라서 생각
			for (int j = 0; j <= N-8; j++) {
				
				// 기준점이 true
				temp = 0; 
				if(map[i][j] != true) temp++; // 기준점이 true가 아니면 칠하기
				find(i, j, true, temp); // 8*8 체스판 확인
				
				// 기준점이 false
				temp = 0;
				if(map[i][j] != false) temp++; // 기준점이 false가 아니면 칠하기
				find(i, j, false, temp); // 8*8 체스판 확인
				
			}
		}
		
		System.out.println(ans); // 출력
		
	}

	private static void find(int i, int j, boolean check, int temp) {
		for (int r = i; r < i+8; r++) {
			for (int c = j; c < j+8; c++) {
				
				if(r == i && c == j) continue; // 첫 칸은 패스
				
				else if(c == j) { // 다음 줄의 첫 칸
					if(check != map[r][c]) {
						temp++;
					}						
				}
				
				else if(check == map[r][c]) {
					temp++; // 정사각형 칠하기
					check = !map[r][c]; // 바꾸기						
				}
				
				else {
					check = map[r][c];
				}
				
			}
		}
		
		ans = Math.min(ans, temp); // 최소값 찾기
	}

}
