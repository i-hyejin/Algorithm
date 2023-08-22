import java.io.*;
import java.util.*;

public class b13023 {
	private static int N;
	private static int M;
	private static ArrayList<ArrayList<Integer>> list;
	private static boolean[] v;
	private static boolean flag;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 사람의 수
		M = Integer.parseInt(st.nextToken()); // 관계의 수
		list = new ArrayList<>(); // 친구 관계를 저장할 리스트
		for (int i = 0; i < N; i++) { // 2차원 리스트로 만들기 위해 초기화 처리
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) { // 관계의 수 만큼 친구 관계 입력
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b); // 친구 관계(양방향)
			list.get(b).add(a);
		}
		
		flag = false; // A->B->C->D->E 까지 가면 true, 아니면 false
		
		for (int i = 0; i < N; i++) { 
			v = new boolean[N];
			dfs(i, 1); // i번부터 depth 1로 시작해서 M까지 가는지 확인
			
			if(flag) { // 끝까지 갔으면 1 출력하고 종료
				System.out.println("1"); 
				return;
			} 
		}
		System.out.println("0"); // 끝까지 가지 못했으므로 0 출력하고 종료
		
	}

	private static void dfs(int idx, int depth) { // idx번째부터 depth까지 dfs 탐색
		// basis part
		if(depth == 5) { // depth M까지 탐색했다면 flag를 true로 바꾸고 탐색 종료
			flag = true;
			return;
		}
		
		// recursive part
		v[idx] = true; // 방문 처리
		for (int i = 0; i < list.get(idx).size(); i++) { 
			if(!v[list.get(idx).get(i)]) { // 방문 전이면
				dfs(list.get(idx).get(i), depth + 1); // 현재 방문한 정점 기준으로 depth+1 해서 이어서 탐색
			}
		}
		v[idx] = false; // 방문 처리 해제
	}
}
