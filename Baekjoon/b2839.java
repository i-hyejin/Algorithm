import java.io.*;
import java.util.*;

public class b2839 {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N 킬로그램
		int remain = 0;
		int ans = Integer.MAX_VALUE; // 봉지의 최소 개수
		int fiveK = 0; // 5 킬로 봉지
		int threeK = 0; // 3 킬로 봉지
		
		fiveK = N / 5; // 5 킬로로 나누어봄
		if(fiveK == 0) { // 5 킬로로 나누었을 때 0 봉지이면
			if(N % 3 == 0) { // 3 킬로로 나누었을 때 나머지가 0이면
				ans = Math.min(ans, N / 3);
			}
		}
		
		for(int f = fiveK; f >= 0; f--) {
			remain = N - f * 5; // 5 킬로로 나눈 나머지
			threeK = remain / 3; // 나머지를 3 킬로로 나눈 나머지
			if(remain % 3 == 0) { // 3 킬로로 나누었을 때 나머지가 0이면
				ans = Math.min(ans, f + threeK); 
			}
		}
		
		if(ans == Integer.MAX_VALUE) { // 봉지가 갱신되지 않아서 여전히 최대값이면
			ans = -1; // 정확하게 N 킬로그램을 만들 수 없으므로 -1 출력 
		}
		
		System.out.println(ans);
	}
}
