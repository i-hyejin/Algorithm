import java.io.*;
import java.util.StringTokenizer;

public class swea1209 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src\\input (1).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int t = 1; t <= 10; t++) {
			// 입력
			t = Integer.parseInt(br.readLine());
			int[][] map = new int[100][100];
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0; // 정답
			int temp = 0; // 가로/세로/대각선의 합
			
			// 가로의 최대값
			for(int i = 0; i < map.length; i++) {
				temp = 0;
				for(int j = 0; j < map.length; j++) {
					temp += map[i][j];
				}
				ans = Math.max(ans, temp);
			}
			
			// 세로의 최대값
			for(int i = 0; i < map.length; i++) {
				temp = 0;
				for(int j = 0; j < map.length; j++) {
					temp += map[j][i];
				}
				ans = Math.max(ans, temp);
			}
			
			// 대각선의 합
			temp = 0;
			for(int i = 0; i < map.length; i++) {
				temp += map[i][i];
			}
			ans = Math.max(ans, temp);
			
			temp = 0;
			for(int i = 99; i >= 0; i--) {
				temp -= map[i][i];
			}
			ans = Math.max(ans, temp);
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
