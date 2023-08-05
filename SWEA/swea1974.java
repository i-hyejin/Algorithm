import java.util.*;

public class swea1974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int[][] map = new int[9][9]; // 스도쿠 맵
			boolean flag = true; // 겹치는 숫자가 없으면 true
			
			for(int i = 0; i < 9; i++) { // 맵 채우기
				for(int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 가로
			for(int i = 0; i < 9; i++) {
				int[] arr = new int[9];
				for(int j = 0; j < 9; j++) {
					arr[map[i][j]-1]++;
				}
				for(int k = 0; k < 9; k++) {
					if(arr[k] == 0) {
						flag = false;
						break;
					}
				}
			}
			
			// 세로
			for(int i = 0; i < 9; i++) {
				int[] arr = new int[9];
				for(int j = 0; j < 9; j++) {
					arr[map[j][i]-1]++;
				}
				for(int k = 0; k < 9; k++) {
					if(arr[k] == 0) {
						flag = false;
						break;
					}
				}
			}
			
			// 3x3 격자
			for(int i = 0; i <= 6; i += 3) {
				for(int j = 0; j <= 6; j += 3) {
					int[] arr = new int[9];
					int r = i+3;
					int c = j+3;
					for(int m = i; m < r; m++) {
						for(int n = j; n < c; n++) {
							arr[map[m][n]-1]++;
						}
					}
					for(int k = 0; k < 9; k++) {
						if(arr[k] == 0) {
							flag = false;
							break;
						}
					}
				}
			}
			
			if(flag == true) {
				System.out.printf("#%d %d\n", t, 1);
			} else {
				System.out.printf("#%d %d\n", t, 0);
			}
		}
	}
}
