import java.util.*;

public class swea1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int k = N; 
			int r = 0; // 세로
			int c = -1; // 가로
			int num = 1; // 배열의 값
			
			while(k > 0) {
				for(int i = 0; i < k; i++) {
					arr[r][++c] = num++; // 가로 증가
				}
				k--; // 방향 바뀌면서 감소
				for(int i = 0; i < k; i++) {
					arr[++r][c] = num++; // 세로 증가
				}
				for(int i = 0; i < k; i++) {
					arr[r][--c] = num++; // 가로 감소
				}
				k--; // 방향 바뀌면서 감소
				for(int i = 0; i < k; i++) {
					arr[--r][c] = num++; // 세로 감소
				}
			}
			
			// 출력
			System.out.println("#"+t);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
