import java.util.*;

public class swea1940 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 개수
		
		for(int t = 1; t <= T; t++) {
			int speed = 0; // 초기 속도
			int ans = 0; // 이동한 거리
			
			int N = sc.nextInt(); // command의 수
			
			for(int n = 0; n < N; n++) {
				switch(sc.nextInt()) { // 현재 속도 유지 / 가속 / 감속
				case 1: // 가속이면 속도 증가
					speed += sc.nextInt();
					break;
				case 2: // 감속이면 속도 감소
					speed -= sc.nextInt();
					if(speed < 0) speed = 0;
					break;
				default: // 현재 속도 유지
					break;
				}
				ans += speed; // 거리 계산
			}
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
