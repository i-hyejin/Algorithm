import java.io.*;
import java.util.*;

public class b16926 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(new File("b16926_input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < R; r++) {
			int rmin = 0;
			int cmin = 0;
			int rmax = N-1;
			int cmax = M-1;
			
			while(true) {
				if(rmin >= N/2 || cmin >= M/2) break;
				
				int temp = map[rmin][cmin]; // 첫자리
				for (int i = cmin; i < cmax; i++) { // 왼쪽으로
					map[rmin][i] = map[rmin][i+1];
				}
				for (int i = rmin; i < rmax; i++) { // 위로
					map[i][cmax] = map[i+1][cmax];
				}
				for (int i = cmax; i > cmin; i--) { // 오른쪽으로
					map[rmax][i] = map[rmax][i-1];
				}
				for (int i = rmax; i > rmin; i--) { // 아래로
					map[i][cmin] = map[i-1][cmin];
				}
				map[rmin+1][cmin] = temp; // 빈자리

				rmin++;
				cmin++;
				rmax--;
				cmax--;
			}
		}
	
		print(map);
		
	}
	
	static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
