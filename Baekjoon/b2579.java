import java.io.*;
import java.util.*;

public class b2579 {

	private static int[] stairs;
	private static int N;
	private static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 계단의 개수
		stairs = new int[N+1]; // 계단의 점수
		for (int i = 1; i < stairs.length; i++) {
			stairs[i] = sc.nextInt();
		}
		ans = 0; // 점수의 최대값
		
		int[][] stairsSum = new int[N+1][2];
		stairsSum[1][0] = stairs[1];
		stairsSum[1][1] = stairs[1];
		for (int i = 2; i <= N; i++) {
			// 전칸 최대값(한 칸 올라가므로, 두 칸 올라온 경우만 가능)
			stairsSum[i][0] = stairsSum[i-1][1] + stairs[i];
			// 전전칸 최대값(두 칸 올라가므로, 한 칸이나 두 칸 올라온 경우 가능)
			stairsSum[i][1] = Math.max(stairsSum[i-2][0], stairsSum[i-2][1]) + stairs[i];
		}
		
		System.out.println(Math.max(stairsSum[N][0], stairsSum[N][1]));
	}

	/** 재귀로 구현할 경우 시간 초과 발생
	// idx: 현재 위치, score : 현재 점수, cnt: 몇 번 연속 올랐는지
	private static void getScore(int idx, int score, int cnt) {
		if(idx > N) { // 마지막 계단을 밟지 않으면
			return;
		}
		
		if(cnt == 3) { // 연속된 3개의 계단을 밟을 수 없음
			return;
		}
		
		if(idx == N) { // 끝까지 도달했으면
			score += stairs[idx]; // 마지막 발판의 점수 더하고
			ans = Math.max(ans, score); // 최대값 업데이트
			return;
		}
		
		
		// 계단을 밟아 점수 추가
		score += stairs[idx];
		
		// 한 계단 오르기
		getScore(idx + 1, score, cnt + 1);
		// 두 계단 오르기
		getScore(idx + 2, score, 1);
		
	}
	*/

}
