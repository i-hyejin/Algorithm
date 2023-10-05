import java.io.*;
import java.util.*;

public class b2644 {
	static class Relation{
		int person;
		int chonsu;
		
		public Relation(int person, int chonsu) {
			this.person = person;
			this.chonsu = chonsu;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// input
		int N = Integer.parseInt(br.readLine()); // 사람의 수
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()); // 촌수를 계산할 사람 1
		int b = Integer.parseInt(st.nextToken()); // 촌수를 계산할 사람 2
		int M = Integer.parseInt(br.readLine()); // 관계의 수
		int[][] relation = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 부모
			int y = Integer.parseInt(st.nextToken()); // 자식
			relation[x][y] = 1;
			relation[y][x] = 1;
		}
		boolean[] v = new boolean[N+1]; // 확인 여부
		int ans = -1; // 촌수를 계산한 결과
		
		// logic
		Queue<Relation> q = new ArrayDeque<>();
		q.add(new Relation(a, 0));
		v[a] = true;
		
		while(!q.isEmpty()) {
			Relation tmp = q.poll();
			
			if(tmp.person == b) { // 촌수를 찾는 사람이면 ans에 반환
				ans = tmp.chonsu;
			}
			
			for (int i = 1; i <= N; i++) {
				if(relation[tmp.person][i] == 1 && !v[i]) {
					v[i] = true;
					q.add(new Relation(i, tmp.chonsu + 1)); // 촌수 1 추가하여 큐에 넣기
				}
			}
		}
		
		// output
		System.out.println(ans);
	}

}
