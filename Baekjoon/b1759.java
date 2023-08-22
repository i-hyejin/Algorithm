import java.io.*;
import java.util.*;

public class b1759 {

	private static StringBuilder sb;
	private static int L;
	private static int C;
	private static String[] pwd;
	private static String[] alpha;
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken()); // L개의 알파벳 소문자로 구성
		C = Integer.parseInt(st.nextToken()); // C개의 문자가 공백을 주어짐
		
		pwd = new String[L]; // 패스워드 문자열 저장
		alpha = new String[C]; // 주어지는 알파벳 저장
		alpha = br.readLine().split(" "); // 공백 기준으로 읽어서 저장
		
		Arrays.sort(alpha); // 사전순 정렬
		recursive(0, 0); 
	
		System.out.println(sb); // 출력
	}

	private static void recursive(int len, int start) {
		// basis part
		if(len >= L) { // 길이가 L보다 크거나 같고
			if(check(pwd)) { // 조건에 맞으면
				for(String p : pwd) { // sb에 저장
					sb.append(p);
				}
				sb.append("\n");
			}
			return;
		}
		
		// recursive part
		for(int i = start; i < C; i++) {
			pwd[len] = alpha[i]; // 한 자리씩 채우기
			recursive(len + 1, i + 1); // 한 칸 채우고 다시 반복
		}
	}

	private static boolean check(String[] s) {
		int c = 0; // 자음 개수
		int v = 0; // 모음 개수
		
		for (int i = 0; i < s.length; i++) { // s 하나씩 살펴보면서 자음, 모음 개수 세기
			if(s[i].equals("a") || s[i].equals("e") || s[i].equals("i") || s[i].equals("o") || s[i].equals("u")) {
				v++;
			} else {
				c++;
			}
		
		}
		
		if(c >= 2 && v >= 1) // 자음 2개 이상 && 모음 1개 이상
			return true; // true 반환
		else
			return false;
	}

	

}
