import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 2. N개 중에 중복 없이 M개 고르기
		int[] arr = new int[N]; // 원본 배열 
		boolean[] v = new boolean[N]; // 방문 배열
		int[] sel = new int[M]; // 선택 배열
		
		for(int n = 0; n < N; n++) { // 원본 배열 생성
			arr[n] = n+1;
		}
		
		recursive(arr, sel, v, 0, 0);
	}
	
	// arr : 원본 배열, sel : 선택 배열, idx : 원본 배열 인덱스, k : 선택 배열 인덱스
	private static void recursive(int[] arr, int[] sel, boolean[] v, int idx, int k) {
		// basis part
		if(k == sel.length) { // M개 골랐으면 출력
			for(int s = 0; s < sel.length; s++) {
				System.out.print(sel[s] + " ");
			}
			System.out.println();
			return;
		}
		
		// inductive part
		for(int i = 0; i < arr.length; i++) {
			if(v[i] == false) { // 미방문 인덱스에 대해서 
				sel[k] = arr[i]; // 하나 선택하기
				v[i] = true; // 방문 처리
				recursive(arr, sel, v, idx+1, k+1);
				v[i] = false; // 방문 처리 해제
			}
		}
	}
}
