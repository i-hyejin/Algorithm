import java.io.*;
import java.util.*;

public class b1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		for (int i = M; i <= N; i++) { // M 이상 N 이하
			if(isPrime(i)) { // 소수이면
				sb.append(i).append("\n"); // StringBuilder에 저장
			}
		}
		
		System.out.println(sb.toString()); // 출력
	}

	private static boolean isPrime(int n) {
		if(n == 1) { // 1은 소수가 아님
			return false;
		}
		
		for (int i = 2; i <= (int)Math.sqrt(n); i++) { // 2부터 확인
			if(n % i == 0) { // 나누어 떨어지면 false
				return false;
			}
		}
		return true; // 끝까지 왔으면 소수임
	}

}
