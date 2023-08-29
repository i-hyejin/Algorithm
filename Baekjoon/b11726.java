import java.util.Scanner;

public class b11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[] arr = new long[n+1];
		arr[1] = 1; // 2*1 1개
		if(n >= 2) { // n이 2보다 클 때만 실행 -> ArrayIndexOutOfBounds
			arr[2] = 2; // 2*1 2개 or 1*2 2개
			for (int i = 3; i <= n; i++) {
				arr[i] = (arr[i-1] + arr[i-2]) % 10007; // 10007로 나눈 나머지로 저장
			}
		}
		
		System.out.println(arr[n]);
	}

}
