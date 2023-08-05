import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class swea6808 {
	static final int cardNum = 9;
	static int[] guyoung;
	static int[] inyoung;
	static int[] sel;
	static boolean[] v = new boolean[cardNum];
	static int guScore, inScore, ans;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("swea6808_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			guyoung = new int[cardNum]; // 규영 카드
			inyoung = new int[cardNum]; // 인영 카드
			for(int i = 0; i < cardNum; i++) { // 규영 카드 입력
				guyoung[i] = sc.nextInt();
			}
			Arrays.sort(guyoung);
			int gu_idx = 0;
			int in_idx = 0;
			for(int i = 1; i < (cardNum*2)+1; i++) { // 1부터 18까지 카드 중에
				if(gu_idx < 9 && guyoung[gu_idx] == i) { // 규영이가 가지고 있으면
					gu_idx++;
				} else { // 규영이가 가지고 있지 않으면
					inyoung[in_idx] = i; // 인영이에게 추가
					in_idx++;
				}
			}
			
			ans = 0; // 규영이가 이기는 횟수
			sel = new int[9]; // 인영 카드 9! 경우의 수 정리
			recursive(0);
			
			System.out.printf("#%d %d %d\n", t, ans, factorial(9)-ans);
		}
	}
	
	private static void recursive(int idx) {
		// basis part
		if(idx == sel.length) { // 다 골랐으면
			guScore = 0; // 점수 초기화
			inScore = 0;
			
			for(int i = 0; i < cardNum; i++) { // 점수 계산
				if(guyoung[i] > sel[i]) {
					guScore += (guyoung[i] + sel[i]);
				} else if(guyoung[i] < sel[i]) {
					inScore += (guyoung[i] + sel[i]);
				}
			}
			
			if(guScore > inScore) { // 규영이가 이기면 ans 1 추가
				ans++;
			} 
			return;
		}
		
		// inductive part
		for(int i = 0; i < inyoung.length; i++) {
			if(v[i] == false) {
				v[i] = true;
				sel[idx] = inyoung[i];
				recursive(idx+1);
				v[i] = false;
			}
		}
	}

	static int factorial(int n) { // 팩토리얼 계산
		// basis part
		if(n == 1) {
			return 1;
		}
		return n * factorial(n-1);
	}

}
