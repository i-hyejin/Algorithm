import java.io.*;
import java.util.*;

public class b8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int i = 0; i < T; i++) {
			String result = br.readLine(); // OX퀴즈 결과
			int score = 0; // OX퀴즈 점수
			int bonus = 1; // 연속된 개수
			
			for (int j = 0; j < result.length(); j++) {
				switch(result.charAt(j)) {
					case 'O':
						score += bonus; // 연속된 점수
						bonus += 1; // 1점 추가
						break;
					case 'X':
						bonus = 1; // 연속 점수 초기화
						break;
					default:
						break;
				}
			}
			
			System.out.println(score);
		}

	}

}
