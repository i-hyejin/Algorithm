import java.io.*;
import java.util.*;

public class b16935 {
	public static void main(String[] args) throws IOException, NumberFormatException {
//		System.setIn(new FileInputStream("b16935_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()); // 연산 횟수
		int[][] map = new int[N][M];
		int[][] ans = new int[N][M];
		int[][] ansR = new int[M][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int K, n, m;
		for (int r = 0; r < R; r++) {
			K = Integer.parseInt(st.nextToken()); // 수행해야 하는 연산
			
			switch(K) {
			case 1: // 상하 반전
				n = map.length;
				m = map[0].length;
				ans = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						ans[i][j] = map[n-i-1][j];
					}
				}
				map = ans;
				break;
				
			case 2: // 좌우 반전
				n = map.length;
				m = map[0].length;
				ans = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m ; j++) {
						ans[i][j] = map[i][m-j-1];
					}
				}
				map = ans;
				break;
				
			case 3: // 오른쪽으로 90도 회전
				ansR = new int[map[0].length][map.length];
				n = ansR.length;
				m = ansR[0].length;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						ansR[i][j] = map[m-j-1][i];
					}
				}
				map = ansR;
				break;
				
			case 4: // 왼쪽으로 90도 회전
				ansR = new int[map[0].length][map.length];
				n = ansR.length;
				m = ansR[0].length;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						ansR[i][j] = map[j][n-i-1];
					}
				}
				map = ansR;	
				break;
				
			case 5: // 부분 배열로 나누어 오른쪽으로
				n = map.length;
				m = map[0].length;
				ans = new int[n][m];
				for (int i = 0; i < n; i++) {
					if(i < n/2) {
						for (int j = 0; j < m; j++) {
							if(j < m/2) ans[i][j] = map[i+n/2][j];
							else ans[i][j] = map[i][j-m/2];
						}
					}	else {
						for (int j = 0; j < m; j++) {
							if(j < m/2) ans[i][j] = map[i][j+m/2];
							else ans[i][j] = map[i-n/2][j];
						}
					}
				}
				map = ans;
				break;
				
			case 6: // 부분 배열을 나누어 왼쪽으로
				n = map.length;
				m = map[0].length;
				ans = new int[n][m];
				for (int i = 0; i < n; i++) {
					if(i < n/2) {
						for (int j = 0; j < m; j++) {
							if(j < m/2) ans[i][j] = map[i][j+m/2];
							else ans[i][j] = map[i+n/2][j];
						}
					}	else {
						for (int j = 0; j < m; j++) {
							if(j < m/2) ans[i][j] = map[i-n/2][j];
							else ans[i][j] = map[i][j-m/2];
						}
					}
				}
				map = ans;
				break;
			}
			
			print(map);
		}
	}

	private static void print(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
