import java.io.*;
import java.util.*;

public class swea3289 {
	
	static int parents[]; // 대표자 집합
	
	private static void make(int n) { // 생성
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) { // 찾기
		if(a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) { // 합치기
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt(); // 테스트 케이스의 개수
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " "); // 테스트 케이스의 번호 출력
			
			int n = sc.nextInt(); // a, b는 n 이하의 자연수
			int m = sc.nextInt(); // m개의 연산의 개수가 주어짐
			make(n + 1); // 서로소 집합 생성(1부터 n까지 이므로 n+1 크기의 배열 생성)
			
			for (int i = 0; i < m; i++) {
				int cmd = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				switch(cmd) {
				case 0: // a가 포함되어 있는 집합과 b가 포함되어 있는 집합을 합침
					union(a, b);
					break;
				case 1: // a와 b가 같은 집합에 포함되어 있는지를 확인
					if(find(a) == find(b)) { // 같은 집합에 포함되어 있으면
						sb.append("1"); // 1 출력
					} else { 				// 다른 집합에 포함되어 있으면
						sb.append("0");	// 0 출력
					}
					break;
				}
			}
			
			sb.append("\n"); // 줄바꿈 출력
		}
		
		System.out.println(sb);
	}

}
