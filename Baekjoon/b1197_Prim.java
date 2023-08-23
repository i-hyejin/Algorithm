import java.io.*;
import java.util.*;

// 인접 행렬 Prim 
public class b1197_Prim {
	
	private static int V;
	private static int E;
	private static int ans;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		// 인접 행렬
		int[][] arr = new int[V+1][V+1]; // 인접 행렬
		boolean[] visited = new boolean[V+1]; // v 방문 여부
		int[] minEdge = new int[V+1]; // v와 연결되는 간선 중 최소 비용
		
		for (int i = 1; i <= V; i++) {
			minEdge[i] = Integer.MAX_VALUE; // 최대값으로 초기화
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[s][e] = w;
		}
		
		int minVertex, minWeight; // 최소 정점, 최소 간선 비용
		int result = 0; // MST 비용
		minEdge[1] = 0; // 1번을 기준으로 생각
		
		// 정점 수만큼 반복하면서 모든 정점 연결
		for (int i = 1; i <= V; i++) {
			minVertex = 0; // 임의의 정점 0
			minWeight = Integer.MAX_VALUE; // 초기값을 최대값으로 설정
			
			for (int j = 1; j <= V; j++) { // V개의 정점 반복해가면서 최소 간선 선택
				if(!visited[j] && minWeight > minEdge[j]) { // 방문 전이고 간선 비용이 최소이면 선택
					minWeight = minEdge[j];
					minVertex = j;
				}
			}
			
			visited[minVertex] = true; // 방문 처리
			result += minWeight; // 비용 누적
			
			for (int j = 1; j <= V; j++) {
				// 신장 트리에 포함되어 있지 않고, 인접해 있는 정점이고, 간선 비용이 최소이면
				if(!visited[j] && arr[minVertex][j] != 0 && minEdge[j] > arr[minVertex][j]) {
					minEdge[j] = arr[minVertex][j]; // 비용 갱신
				}
			}
		}
		
		System.out.println(result);
	}

}
