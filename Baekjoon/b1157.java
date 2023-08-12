import java.util.*;

public class b1157 {
	public static void main(String[] args) {
		int[] alphabet = new int[26]; // 알파벳 계수기
		int max = -1; // 최대값 찾기
		int maxIdx = -1; // 최대값의 인덱스
		char ans = ' '; // 가장 많이 사용된 알파벳
		
		// 1. 입력
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		// 2. 문자열에서 한 글자씩 개수 세기
		str = str.toUpperCase(); // 대문자로 변경
		for (int i = 0; i < str.length(); i++) { // 입력된 문자열의 개수만큼 반복
			alphabet[str.charAt(i) - 'A']++; // 아스키 코드 활용
		}
		
		// 3. 가장 많이 사용된 알파벳 찾기
		for (int i = 0; i < alphabet.length; i++) { // 알파벳 개수만큼 반복
			if(max < alphabet[i]) { // 최대값을 찾았다면
				max = alphabet[i]; // 최대값을 max에 저장
				maxIdx = i; // 최대값의 인덱스를 maxIdx에 저장
			} else if (max == alphabet[i]) { // 현재 최대값과 같다면
				maxIdx = -1; // -1을 maxIdx에 저장
			}
		}
	
		// 4. 정답 출력
		if(maxIdx == -1) { // maxIdx가 -1이라면
			ans = '?'; // 가장 많이 사용된 알파벳이 여러 개 존재하므로 ? 출력
		} else { // 최대값이 정상적으로 들어가 있다면
			ans = (char) ('A' + maxIdx); // 'A'에서 maxIdx만큼 더한 char 문자를 출력
		}		
		System.out.println(ans);
	}
}
