import java.io.*;
import java.util.*;

public class swea3124 {

	private static int V;
	private static int E;
	private static int[] parents;
	private static int[] rank;
	private static long ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			int[][] edges = new int[E][3];
			ans = 0;
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edges[i][0] = Integer.parseInt(st.nextToken()); // 시작
				edges[i][1] = Integer.parseInt(st.nextToken()); // 끝
				edges[i][2] = Integer.parseInt(st.nextToken()); // 가중치;
			}
			
			// 정렬
			Arrays.sort(edges, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1[2], o2[2]);
				}
			});
			
			// 서로소집합
			// Make-Set
			parents = new int[V+1];
			rank = new int[V+1];
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
			}
			
			// kruscal
			int cnt = 0;
			for (int i = 0; i < E; i++) {
				int a = findSet(edges[i][0]);
				int b = findSet(edges[i][1]);
				
				// 같은 집합이라면(순환이라면) pass 이번 간선은 버려~~
				if(a == b) { 
					continue;
				}
				// 다른 집합이라면 한 집합으로 묶어주고 간선 값을 저장한다
				unionSet(a, b);
				ans += edges[i][2];
				cnt++;
				
				// V-1만큼 수행했으면
				if(cnt == V-1) {
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int findSet(int i) {
		if(i == parents[i]) {
			return i;
		} else {
			// path compression
			return parents[i] = findSet(parents[i]);
		}
		
	}
	
	private static void unionSet(int i, int j) {
		int pi = findSet(i);
		int pj = findSet(j);
		
		if(rank[pi] > rank[pj]) {
			parents[pj] = pi;
		} else {
			parents[pi] = pj;
			if(rank[pi] == rank[pj]) {
				rank[pj]++;
			}
		}
	}

}
