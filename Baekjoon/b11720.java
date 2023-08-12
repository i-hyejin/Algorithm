import java.util.Scanner;

public class b11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); // 숫자의 개수
		String nums = sc.next(); // 숫자 - 문자열로 받기
		int ans = 0; // 숫자의 합
		
		for (int i = 0; i < num; i++) {
			ans += nums.charAt(i) - '0'; // 아스키 문자에서 0 빼서 숫자 값 가져오기
		}
		
		System.out.println(ans); // 출력
	}

}
