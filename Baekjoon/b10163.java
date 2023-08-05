import java.util.*;

public class b10163 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[1001][1001];
		int N = sc.nextInt(); // 색종이의 장수
		int[] ans = new int[N]; // 색종이의 면적
		
		for(int n = 1; n <= N; n++) { // 색종이의 장수만큼 반복
			int r = sc.nextInt(); // 좌표
			int c = sc.nextInt();
			int h = sc.nextInt(); // 너비
			int w = sc.nextInt(); // 높이
			
			for(int i = r; i < r+h; i++) {
				for(int j = c; j < c+w; j++) {
					map[i][j] = n; // 해당되는 색종이 위치 넣기
				}
			}
		}
		
		for(int i = 0; i < 1001; i++) { // 1000 * 1000 = 1,000,000 (백만 연산 가능)
			for(int j = 0; j < 1001; j++) {
				if(map[i][j] > 0) {
					ans[map[i][j] - 1]++; // 해당되는 색종이 개수 세기
				}
			}
		}
		
		for(int n = 0; n < N; n++) {
			System.out.println(ans[n]); // 출력
		}
	}

}
