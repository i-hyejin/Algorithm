import java.io.*;
import java.util.StringTokenizer;

public class b11659 {
	static int jSum = 0;
	static int iSum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N]; // N개의 수
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		int[] sum = new int[N]; // 합 저장
		for(int n = 0; n < N; n++) {
			if(n == 0) {
				sum[n] = arr[0];
			} else {
				sum[n] = sum[n-1] + arr[n];
			}
		}
		
		for(int m = 0; m < M; m++) { // 합 구하기
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1; // 1 <= i <= j <= N
			int j = Integer.parseInt(st.nextToken())-1;
			System.out.println(sum[j] - sum[i] + arr[i]);
		}
	}

}
