import java.io.*;
import java.util.StringTokenizer;

public class b15652 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 1. 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 2. N개 중에 중복 없이 M개 고르기
		int[] arr = new int[N]; // 원본 배열 
		int[] sel = new int[M]; // 선택 배열
		
		for(int n = 0; n < N; n++) { // 원본 배열 생성
			arr[n] = n+1;
		}
		
		recursive(arr, sel, 0, 0);
		
		bw.flush(); // flush로 시간 초과 해결
		bw.close();
	}
	
	// arr : 원본 배열, sel : 선택 배열, idx : 원본 배열 인덱스, k : 선택 배열 인덱스
	private static void recursive(int[] arr, int[] sel, int idx, int k) throws IOException {
		// basis part
		if(k == sel.length) { // M개 골랐으면 출력
			for(int s = 0; s < sel.length; s++) {
				sb.append(sel[s] + " ");
			}
			sb.append("\n");
			bw.write(sb.toString());
			sb.setLength(0);
			return;
		}
		
		// inductive part
		for(int i = idx; i < arr.length; i++) {
			sel[k] = arr[i]; // 하나 선택하기
			recursive(arr, sel, i, k+1);
		}
	}
}
