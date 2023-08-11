import java.awt.Point;
import java.io.*;
import java.util.*;

public class b15686 {
	private static int ans = Integer.MAX_VALUE; 
	private static int[][] nums;
	private static List<Point> home;
	private static List<Point> store;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. 입력
		int N = Integer.parseInt(st.nextToken()); // 도시의 정보
		int M = Integer.parseInt(st.nextToken()); // 치킨집의 개수 (M<= 치킨집 <= 13)
		
		home = new ArrayList<Point>();
		store = new ArrayList<Point>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// 0 : 빈 칸, 1 : 집, 2 : 치킨 집
				int value = Integer.parseInt(st.nextToken());
				if(value == 1) { // 1이면 home에 추가
					home.add(new Point(i, j));
				} else if(value == 2) { // 2면 store에 추가
					store.add(new Point(i, j));
				}
			}
		}
		
		// 2. 최소 거리
		nums = new int[home.size()][store.size()]; // 치킨집 별 최소 치킨 거리
		for (int i = 0; i < home.size(); i++) {
			for (int j = 0; j < store.size(); j++) {
				nums[i][j] = Math.abs(store.get(j).x - home.get(i).x) + Math.abs(store.get(j).y - home.get(i).y);
			}
		}
		
		// 3. 최대 M개 골랐을 때 도시 치킨 거리의 최소값
		for (int m = 1; m <= M; m++) {
			recursive(new int[m], 0, 0);
		}
		
		System.out.println(ans);
	}

	// idx : 원본 배열 인덱스, k : 선택 배열 인덱스
	private static void recursive(int[] sel, int idx, int k) {
		// basis part
		if(k == sel.length) { // 다 골랐으면
			
			int tempSum = 0; // 도시의 치킨 거리
			for (int i = 0; i < home.size(); i++) { 
				int temp = Integer.MAX_VALUE; // 집의 치킨 거리
				for (int j = 0; j < sel.length; j++) { // 고른 치킨 집 별 최소값 구하기
					temp = Math.min(temp, nums[i][sel[j]]); 
				}
				tempSum += temp; // 도시의 치킨 거리 더하기
			}
			
			ans = Math.min(ans, tempSum); // 도시의 치킨 거리 중 최소값
			return;
		}
		
		// inductive part
		for (int i = idx; i < store.size(); i++) { 
			sel[k] = i;
			recursive(sel, i+1, k+1);
		}
		
	}

}
