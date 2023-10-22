import java.io.*;
import java.util.*;

public class b9466 {

	private static int n;
	private static int[] arr;
	private static boolean[] v;
	private static boolean[] finished;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// input
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine()); // 학생의 수
			arr = new int[n+1]; // 학생의 번호
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// logic
			v = new boolean[n+1]; // 팀에 속했는지 여부를 판단
			finished = new boolean[n+1]; // 마지막 여부
			ans = 0;
			for (int i = 1; i <= n; i++) {
				if(!v[i]) // 방문 전이면
					dfs(i); // dfs 탐색
			}
			
			// output
			System.out.println(n - ans);
		}
			
	}

	private static void dfs(int i) {		
		v[i] = true; // 방문 처리
		int next = arr[i]; // 다음 팀에 속했는지 판단할 학생 
		
		if(!v[next]) dfs(next); // 팀에 안 속했으면 탐색
		
		if(v[next] && !finished[next]) { // 방문했고 마지막이 아니면
			ans++; // 자기 자신 더하기
			for (int j = next; j != i; j = arr[j]) { // 팀 결성한 학생 수 더하기
				ans++; 
			}
		}
		
		finished[i] = true; // 팀 결성 완료
	}

}
