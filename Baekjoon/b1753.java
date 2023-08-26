import java.io.*;
import java.util.*;

public class b1753 {
	static class Node implements Comparable<Node>{
		int e, w;
		
		public Node(int e, int w) {
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	private static int V;
	private static int E;
	private static ArrayList<Node>[] list;
	private static int[] dist;
	
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		V = sc.nextInt(); // 정점의 개수 (1<=V<=20,000)
		E = sc.nextInt(); // 간선의 개수 (1<=E<=300,000)
		int K = sc.nextInt(); // 시작 정점의 번호(1<=K<=V)
		
		list = new ArrayList[V+1]; // 리스트 생성
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		dist = new int[V+1]; // 거리 배열
		Arrays.fill(dist, Integer.MAX_VALUE); // 최대값으로 채우기
		
		
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt(); // u에서
			int v = sc.nextInt(); // v로 가는
			int w = sc.nextInt(); // 가중치 w인 간선
			list[u].add(new Node(v, w)); // 리스트에 추가
		}
		
		dijkstra(K);
		
		for (int i = 1; i <= V; i++) { // 출력
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		
		System.out.println(sb);
		
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>(); // 우선순위 큐 생성
		boolean[] check = new boolean[V+1]; // 방문 배열
		q.add(new Node(start, 0));  // (start, 0) 넣기
		dist[start] = 0; // 시작 지점의 거리를 0으로 설정
		
		while(!q.isEmpty()) { // 큐가 비어 있을 때까지
			Node n = q.poll(); // 큐에서 하나 꺼내기
			int cur = n.e; // 방문할 지점
			
			if(check[cur] == true) continue; // 이미 방문했으면 패스
			check[cur] = true; // 방문 처리
			
			for(Node node : list[cur]) { // cur와 연결된 다른 정점들 방문
				if(dist[node.e] > dist[cur] + node.w) { // 현재 거리보다 현재 cur의 거리와 node의 가중치보다 작으면
					dist[node.e] = dist[cur] + node.w; // 값 업데이트
					q.add(new Node(node.e, dist[node.e])); // 큐에 넣기
				}
			}
		}
		
	}
}
