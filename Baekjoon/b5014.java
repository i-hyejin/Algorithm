import java.io.*;
import java.util.*;

public class b5014 {
	private static int F;
	private static int S;
	private static int G;
	private static int U;
	private static int D;
	private static int[] v;
	private static int ans;
	private static boolean isFound;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// input
		F = Integer.parseInt(st.nextToken()); // 총 건물의 층수
		S = Integer.parseInt(st.nextToken()); // 현재 위치
		G = Integer.parseInt(st.nextToken()); // 목적지
		U = Integer.parseInt(st.nextToken()); // 위로 U층 이동
		D = Integer.parseInt(st.nextToken()); // 아래로 D층 이동
		v = new int[1000001]; // 방문 여부
		ans = -1; // 버튼을 눌러야 하는 횟수

		// logic
		bfs();

		// output
		if(ans == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(ans);
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(S); // 현재 위치 넣기
		v[S] = 0;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			if(tmp == G) { // 목적지에 도달하면
				ans = v[tmp]; 
			}
			
			if(tmp + U <= F) { // 올라가기
				if(v[tmp + U] == 0) { // 간 적 없으면
					v[tmp + U] = v[tmp] + 1; // 현재까지 밟은 계단 + 1
					q.add(tmp + U);
				}
			}
			
			if(tmp - D > 0) { // 내려가기
				if(v[tmp - D] == 0) { // 간 적 없으면
					v[tmp - D] = v[tmp] + 1; // 현재까지 밟은 계단 + 1
					q.add(tmp - D);
				}
			}
		}
	}

	
}
