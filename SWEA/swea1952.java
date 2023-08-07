import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1952 {
	private static int[] fees;
	private static int[] plans;
	private static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream(new File("swea1952_input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			fees = new int[4]; // 이용권 가격들[1일, 1달, 3달, 1년]
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < fees.length; i++) {
				fees[i] = Integer.parseInt(st.nextToken());
			}
			plans = new int[13]; // 12개월 이용 계획
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < plans.length; i++) {
				plans[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = fees[3]; // 정답. 1년 이용권 가격으로 초기화.
			
			recursive(1, 0); // 탐색
			
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.print(sb.toString());
	}

	private static void recursive(int month, int value) {
		// basis part
		if(month > 12) {
			ans = Math.min(ans, value);
			return;
		}
		
		// recursive part
		recursive(month + 1, value + plans[month] * fees[0]);
		recursive(month + 1, value + fees[1]);
		recursive(month + 3, value + fees[2]);
	}

}
