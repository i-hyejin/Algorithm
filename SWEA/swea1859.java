import java.util.*;

public class swea1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스의 개수
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 매매가의 개수
			int[] arr = new int[N]; // 매매가
			for(int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}
			
			long ans = 0L; // 수익
			long max = arr[N-1]; // 최대값
			
			for(int n = N-2; n >= 0; n--) {
				if(max > arr[n]) { // max가 현재 값보다 크면
					ans += max-arr[n]; // 매도
				} else { // max가 현재 값보다 작으면
					max = arr[n]; 
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " " + ans + "\n");
			System.out.print(sb.toString());
		}
	}
}
