import java.io.*;
import java.util.*;

public class b2606 {
	static class Pos{
		int n;
		int m;
		
		public Pos(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// input
		int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int M = Integer.parseInt(br.readLine()); // 연결되어 있는 컴퓨터 쌍의 수
		int[][] map = new int[N+1][N+1]; // 컴퓨터 연결 정보
		boolean[] visited = new boolean[N+1]; // 컴퓨터 확인 여부
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			map[n][m] = 1;
			map[m][n] = 1;
		}
		int ans = 0; // 바이러스에 걸리게 되는 컴퓨터의 수
		
		// logic
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(1); // 1번 컴퓨터 바이러스 걸림
		visited[1] = true; // 1번 컴퓨터 확인
		
		while(!q.isEmpty()) { // 큐가 빌 때까지
			int tmp = q.poll(); // 하나 꺼내기
			
			for (int i = 1; i <= N; i++) { // 꺼낸 컴퓨터 번호 기준으로 연결 정보 탐색
				if(map[tmp][i] == 1 && !visited[i]) { // 연결되어 있고 확인하지 않은 컴퓨터이면
					ans++; // 바이러스 걸림
					q.add(i); // 큐에 추가
					visited[i] = true; // 확인 처리
				}
			}
		}
		
		// output
		System.out.println(ans);
	}

}
