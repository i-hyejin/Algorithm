import java.io.*;
import java.util.*;

public class b2920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		
		int prev = Integer.parseInt(st.nextToken()); // 첫 번째 음 입력
		for (int i = 1; i < 8; i++) { // 나머지 7개 음 입력 받기
			int now = Integer.parseInt(st.nextToken()); // 현재 음 임력
			if(prev < now) { // 첫 번째 음이 현재 음보다 작으면
				ans += 1; // 1 추가
			} else if(prev > now) { // 첫 번째 음이 현재 음보다 크면
				ans -= 1; // 1 감소
			}
			prev = now; // prev를 now로 고치기
		}
		 
		if(ans == 7) { // 1부터 8까지 차례로 연주해서 7이면
			System.out.println("ascending");
		} else if(ans == -7) { // 8부터 1까지 차례로 연주해서 -7이면
			System.out.println("descending");
		} else { // 7도 -7도 아니면
			System.out.println("mixed");
		}
		
	}

}
