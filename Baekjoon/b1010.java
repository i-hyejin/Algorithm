import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class b1010 {
	// 범위가 넘어가기 때문에 BigInteger 사용
	private static BigInteger[] memo = new BigInteger[31];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		memo[0] = new BigInteger("1");
		memo[1] = new BigInteger("1");
		memo[2] = new BigInteger("2");
		
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 경우
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N == M) { // N과 M이 같은 경우 1
				System.out.println(1);
			} else { // 조합으로 계산
				factorial(M);
				BigInteger a = memo[M];
				BigInteger b = memo[M-N];
				BigInteger c = memo[N];
				System.out.println(a.divide(b.multiply(c)));
			}
		}
	}

	private static void factorial(int n) {
		for (int i = 3; i <= n; i++) {
			if(memo[i] == null) {
				memo[i] = memo[i-1].multiply(BigInteger.valueOf(i));
			}
		}
	}

}
