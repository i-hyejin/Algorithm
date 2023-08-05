import java.util.*;

public class swea1289 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int ans = 0; // 수정 횟수
			String str = sc.next(); // 메모리
			char base = '0'; // 기준 문자
			
			for(int i = 0; i < str.length(); i++) {
				if(base != str.charAt(i)) { // 연속된 두 문자가 다르면
					ans++; // 1회 수정
					base = str.charAt(i); // 기준 문자 바꾸기
				}
			}
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
