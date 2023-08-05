import java.util.Arrays;
import java.util.Scanner;

public class b2023 {
	static int N;
	static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	static int[] sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N 자리 수
		sel = new int[N]; // 선택한 숫자
		makeDemical(0);
	}

	// idx : 원본 배열 인덱스, k : 선택 배열 인덱스
	private static void makeDemical(int k) {
		int temp; // 배열을 숫자로 만들 변수
		
		// basis part
		if(k == sel.length) { // 여기까지 선택했을 때 이미 소수이므로 소수 판별할 필요가 없음
			temp = 0;
			for(int j = 0; j < k; j++) { // 현재까지 배열 숫자로 만들기
				temp += sel[j] * Math.pow(10, k-1-j);
			}
			System.out.println(temp);
			return;
		}
		
		// inductive part
		for(int i = 0; i < arr.length; i++) {
			if(k == 0) { // 처음에는 소수로만 시작
				if(isPrime(arr[i]) == 1) { // 소수이면
					sel[k] = arr[i];
					makeDemical(k+1);
				} 
			} else if(k > 0) { // 한번 뽑은 후에는
				temp = 0;
				
				for(int j = 0; j < k; j++) { // 현재까지 배열 숫자로 만들기
					temp += sel[j] * Math.pow(10, k-j);
				}
				temp += arr[i];
				
				if(isPrime(temp) == 1) { // 현재까지의 수가 소수이면
					sel[k] = arr[i];
					makeDemical(k+1);
				}
			}
		}
	}
	
	// 소수인지 확인하는 함수
	private static int isPrime(int n) {
		if(n == 1) {
			return 0;
		}
		for(int i = 2; i <= (int)Math.sqrt(n); i++) {
			if(n % i == 0) { // 소수가 아님
				return 0;
			}
		}
		return 1;
	}
}
