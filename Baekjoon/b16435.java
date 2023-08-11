import java.io.*;
import java.util.*;

public class b16435 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 과일의 개수
		int L = Integer.parseInt(st.nextToken()); // 초기 길이
		
		st = new StringTokenizer(br.readLine());
		int[] h = new int[N]; // 과일
		for (int i = 0; i < N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(h); // 과일 정렬
		
		for (int i = 0; i < N; i++) {
			if(L >= h[i]) { // 자신의 길이보다 작거나 같은 높이에 있는 과일 먹기
				L++; // 1 늘어남
			}
		}
		
		System.out.println(L);
	}

}
