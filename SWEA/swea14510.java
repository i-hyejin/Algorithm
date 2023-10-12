import java.io.*;
import java.util.*;

public class swea14510 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			int odd = 0; // 하루 남은 경우
			int even = 0; // 이틀 남은 경우
			
			// input
			int N = Integer.parseInt(br.readLine()); // 나무의 개수
			int[] arr = new int[N]; // 나무
			int maxTree = 0; // 나무의 최대값
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				maxTree = Math.max(maxTree, arr[i]);
			}
			
			// logic
			// 이틀 - 하루 값 구하기
			for (int i = 0; i < N; i++) {
				// 모든 나무 최대값만큼 빼기
				arr[i] = Math.max(0, maxTree - arr[i]);
			
				// 2로 나눈 몫은 이틀로, 나머지는 하루로
				even += arr[i] / 2;
				odd += arr[i] % 2;
			}
			
			// 이틀을 하루-하루로 쪼개기
			if(even > odd) { // 이틀이 더 크면 하루-하루로 나눌 수 있기 때문에
				while(Math.abs(even - odd) > 1) { // 차이가 1보다 클 때까지
					even--; 
					odd += 2;
				}
			}
			
			// 물 주는 날 구하기
			if(odd > even) { // 하루인 날이 더 많으면
				ans = odd * 2 - 1;
			} else if(even > odd) { // 이틀인 날이 더 많으면
				ans = even * 2;
			} else { // 같으면
				ans = odd + even;
			}
			
			// output			
			System.out.println("#" + t + " " + ans);
		}
	}

}
