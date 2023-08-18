import java.util.Scanner;

public class b1978 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0; // 소수의 개수
		
		for (int i = 0; i < N; i++) { // N개의 수가 소수인지 판단
			int num = sc.nextInt(); 
			if(isPrime(num)) ans++; // 소수이면 ans 1 증가
		}
		
		System.out.println(ans);
	}

	private static boolean isPrime(int n) { // 소수인지 판단
		if(n == 1) { //1은 소수가 아니다
			return false;
		}
		for (int i = 2; i <= (int)Math.sqrt(n); i++) { // 2부터 n의 제곱근까지 나누어 봄 
			if(n % i == 0) { // 나머지가 0이면 나누어 떨어지므로 소수가 아님
				return false;
			}
		}
		
		return true; // 모든 나누기를 통과하면 소수
	}

}
