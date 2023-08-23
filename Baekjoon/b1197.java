import java.io.*;
import java.util.*;

import datastructure.tree.MSTPrimPriortyQueue.Vertex;

// 인접 행렬 Prim 
public class b1197 {
	
	static class Vertex implements Comparable<Vertex>{
		int e, w;
		
		Vertex(int e, int w) {
			this.e = e;
			this.w = w;
		}
	
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	private static int V;
	private static int E;
	private static int ans;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		// 인접 리스트
		ArrayList<Vertex> adj[] = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[s].add(new Vertex(e, w));
			adj[e].add(new Vertex(s, w));
		}
		
		// prim
		boolean[] v = new boolean[V+1]; // 방문 배열
		int[] dist = new int[V+1]; // 거리 배열
		Arrays.fill(dist, Integer.MAX_VALUE); // 거리 배열을 무한대로 초기화
		dist[1] = 0; // 하나의 정점을 선택(관습적으로 첫 번째)
		
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>(); // PriorityQueue를 사용
		Q.add(new Vertex(1, dist[1])); // 1번 정점 넣기
		int cnt = 0; // 탐색한 정점의 개수
		
		while(!Q.isEmpty()) { // Q가 비어 있지 않을 때까지
			Vertex p = Q.poll(); // 큐에서 하나를 뽑으면 최소 비용 정점이 뽑아짐 -> compare로 이미 비교
			
			if(v[p.e]) continue; // 이미 방문한 정점이면 continue
			ans += p.w; // 확정된 정점의 가중치 값을 추가
			cnt++;
			
			if(cnt == V) break; // V개의 정점을 봤으면 그만 -> 성능 향상
			v[p.e] = true; // p.e 기준 정점으로 삼고 방문 처리
			
			int size = adj[p.e].size(); // 기준 정점에 연결된 정점의 크기
			for (int i = 0; i < size; i++) {
				Vertex next = adj[p.e].get(i); // 기준 정점에서 연결된 정점들
				if(!v[next.e] && dist[next.e] > next.w) // 연결된 정점이 방문되지 않았고, 새롭게 찾은 정점의 값이 기존에 찾았던 값보다 작다면
					dist[next.e]= next.w; // 거리 배열을 업데이트 함
					Q.add(new Vertex(next.e, next.w)); // 연결된 정점들을 Q에 저장
			}
			
		}
		
		System.out.println(ans);
	}

}
