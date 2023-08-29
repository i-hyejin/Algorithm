import java.io.*;
import java.util.*;

public class b1463_dp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N+1]; // 숫자 별 연산 횟수 정리
		arr[1] = 0;
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i-1] + 1; // -1로 연산 한 번 실행
			
			if(i % 2 == 0 && arr[i] > arr[i/2] + 1) {
				arr[i] = arr[i/2] + 1; // /2 연산으로 실행
			}
			
			if(i % 3 == 0 && arr[i] > arr[i/3] + 1) {
				arr[i] = arr[i/3] + 1; // /3 연산으로 실행
			}
		}
		
		System.out.println(arr[N]);
	}
}
