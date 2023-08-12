import java.io.*;
import java.util.*;

public class b10250 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 데이터의 개수
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // 호텔 층 수
			int W = Integer.parseInt(st.nextToken()); // 각 층의 방 수
			int N = Integer.parseInt(st.nextToken()); // 몇 번째 손님
			
			int h = N % H; // 방 결정
			if(h == 0) { // 나머지가 0이면 마지막 방으로 배정
				h = H;
			}
			int w = N / H + 1; // 층 수 결정
			if(N % H == 0) { // 나머지가 없으면 몫이 1 늘어나므로 1 빼기 
				w -= 1;
			}
					
			int ans = 100 * h + w;
			
			System.out.println(ans);
		}
	}

}
