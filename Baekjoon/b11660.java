import java.awt.Point;
import java.io.*;
import java.util.*;

public class b11660 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("b11660_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		int[][] map = new int[N][N];
		int[][] sumMap = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = 0;
			for(int j = 0; j < N; j++) {
				temp += Integer.parseInt(st.nextToken());
				sumMap[i][j] = temp;
			}
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			Point x = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
			Point y = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
			
			int sum = 0;
			for(int i = x.x; i <= y.x; i++) {
				sum += sumMap[i][y.y];
				if(x.y-1 >= 0) {
					sum -= sumMap[i][x.y-1];
				}
			}
			
			sb.append(sum + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
