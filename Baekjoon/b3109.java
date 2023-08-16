import java.awt.Point;
import java.io.*;
import java.util.*;

public class b3109 {

	private static int R;
	private static int C;
	private static char[][] map;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 가로
		C = Integer.parseInt(st.nextToken()); // 세로
		map = new char[R][C]; // 지도
		ans = 0; // 파이프의 최대 개수
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			if(check(i, 0)) { // (i, 0) 확인하기
				ans++;
			}
		}
	
		System.out.println(ans);
	}

	private static boolean check(int i, int j) {
		map[i][j] = '-'; // 방문 처리
		
		if(j == C - 1) // 마지막 열이면 끝
			return true;
		
		if(i > 0 && map[i-1][j+1] == '.') { // 오른쪽 위
			if(check(i-1, j+1)) {
				return true;
			}
		}
		
		if(j + 1 < C && map[i][j+1] == '.') { // 오른쪽
			if(check(i, j+1)) {
				return true;
			}
		}
		
		if(i + 1 < R && map[i+1][j+1] == '.') { // 오른쪽 위
			if(check(i+1, j+1)) {
				return true;
			}
		}
		
		return false;
	}
}
