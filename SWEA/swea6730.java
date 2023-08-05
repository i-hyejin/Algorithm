import java.util.*;

public class swea6730 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스의 개수
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 직사각형 블록의 개수
			int[] arr = new int[N]; // 직사각형 블록
			for(int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}
			
			int min = 0; 
			int max = 0;
			
			for(int n = 1; n < N; n++) {
				int sub = arr[n] - arr[n-1];
				
				if(sub > 0) { // 올라갈 때
					max = Math.max(sub, max);
				} else if(sub < 0) { // 내려갈 때
					min = Math.max(-sub, min);
				}
			}
			
			System.out.println("#" + t + " " + max + " " + min);
			
		}
	}
}
