import java.io.*;
import java.util.*;

public class swea1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = 10;
		for(int t = 1; t <= T; t++) {
			// 원본 암호문의 길이
			int N = Integer.parseInt(br.readLine());
			// 원본 암호문
			ArrayList<String> origin = new ArrayList<String>();
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				origin.add(st.nextToken());
			}
			// 명령어의 개수
			int C = Integer.parseInt(br.readLine());
			// 명령어
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < C; n++) {
				st.nextToken(); // I
				int index = Integer.parseInt(st.nextToken()); // 삽입할 위치
				int nums = Integer.parseInt(st.nextToken()); //  삽입할 숫자의 개수
				for(int c = 0; c < nums; c++) { // 삽입할 숫자
					String temp = st.nextToken();
					origin.add(index + c, temp);
				}
			}
			
			// 출력
			System.out.print("#" + t + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(origin.get(i) + " ");
			}
			System.out.println();
			
		}
	}
}
