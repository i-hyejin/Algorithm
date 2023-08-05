import java.io.*;
import java.util.*;

public class b12891 {
	static int S, P;
	static char[] strS,strP;
	static int[] contains;
	static char[] c = {'A', 'C', 'G', 'T'};
	static int ans;
	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 1. 입력
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken()); // 임의로 만든 DNA 문자열 길이
		P = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분문자열의 길이
		strS = br.readLine().toCharArray(); // 임의로 만든 DNA 문장
		strP = new char[P]; // 비밀번호로 사용할 문자열
		contains = new int[4]; // A, C, G, T 최소 개수
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < contains.length; i++) {
			contains[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0; // 만들 수 있는 비밀번호의 종류의 수
		
		// 2. 초기값 설정
		temp = new int[4]; // 생성한 문자열의 A, C, G, T 개수 
		boolean flag = true;
		
		for(int j = 0; j < P; j++) { // 생성한 문자열의 A, C, G, T 개수 세기
			cntUp(strS[j]);
		}
		
		for(int j = 0; j < 4; j++) { // 필수 문자의 개수 > 생성 문자의 개수
			if(contains[j] > temp[j]) { 
				flag = false;
			}
		}
		
		if(flag == true) { // 조건을 만족하면 ans 증가
			ans++;
		}
		
		// 3. S-P만큼 반복
		for(int i = 1; i <= S-P; i++) {
			flag = true;
			cntDown(strS[i-1]); // i번째 감소	
			cntUp(strS[i+P-1]); // i+P번째 증가	
			
			for(int j = 0; j < 4; j++) { // 필수 문자의 개수 > 생성 문자의 개수
				if(contains[j] > temp[j]) { 
					flag = false;
				}
			}
			
			if(flag == true) { // 조건을 만족하면 ans 증가
				ans++;
			}
		}
		
		// 4. 출력
		System.out.println(ans);
	}
	
	private static void cntUp(char c) { // 해당하는 문자의 개수 더하기
		switch(c){
		case 'A':
			temp[0]++;
			break;
		case 'C':
			temp[1]++;
			break;
		case 'G':
			temp[2]++;
			break;
		case 'T':
			temp[3]++;
			break;
		default:
			break;
		}
	}
	
	private static void cntDown(char c) { // 해당하는 문자의 개수 빼기
		switch(c){
		case 'A':
			temp[0]--;
			break;
		case 'C':
			temp[1]--;
			break;
		case 'G':
			temp[2]--;
			break;
		case 'T':
			temp[3]--;
			break;
		default:
			break;
		}
	}
}
