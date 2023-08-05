import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea5215 {
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		
		for(int t = 1; t <= T; t++) {
			ans = 0; // 맛 점수가 높은 햄버거 변수 값 초기화
			
			// 1. 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
			int L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			
			int[][] map = new int[N][2]; // 점수, 칼로리
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				map[n][0] = Integer.parseInt(st.nextToken()); // 점수
				map[n][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}
			
			// 2. 조합
			int[] sel; // 선택한 재료
			
			for(int n = 1; n <= N; n++) { // N가지 재료 중에서 n개 뽑아서 조합하기
				recursive(map, new int[n][2], 0, 0, L);
			}
			
			// 3. 출력
			System.out.println("#" + t + " " + ans);
		}
	}
	
	// map : 원본 배열 / sel : 선택 배열 / i : 원본 배열 인덱스 / k : 선택 배열 인덱스
	private static void recursive(int[][] map, int[][] sel, int idx, int k, int L) {
		// basis part
		if(k == sel.length) { // 선택이 끝났으면
			if(arraySum(sel, 1) <= L) { // 제한 칼로리보다 낮으면
				ans = Math.max(ans, arraySum(sel, 0)); // 맛 점수 비교하기
			}
			return;
		}
		
		// inductive part
		for(int i = idx; i < map.length; i++) {
			sel[k][0] = map[i][0]; // 점수
			sel[k][1] = map[i][1]; // 칼로리
			recursive(map, sel, i+1, k+1, L);
		}
		
	}
	
	// 특정 배열의 1차원 합 구하기
	private static int arraySum(int[][] sel, int k) {
		int sum = 0;
		for(int i = 0; i < sel.length; i++) {
			sum += sel[i][k];
		}
		return sum;
	}
	
	// 2차원 배열 출력하기
//	private static void print(int[][] map) {
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

}
