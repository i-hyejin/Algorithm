import java.io.*;
import java.util.*;

public class b2675 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken()); // 반복 횟수
			String S = st.nextToken(); // 문자열
			
			for (int s = 0; s < S.length(); s++) { // 문자 하나 당 반복
				char c = S.charAt(s); // 반복할 문자 하나
				for (int r = 0; r < R; r++) { // 반복 횟수
					sb.append(c); // sb에 넣기
				}
			}
			sb.append("\n"); // 줄바꿈
		}
		System.out.println(sb.toString()); // 출력
	}

}
