import java.io.*;
import java.util.*;

public class swea1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = 10; // 테스트 케이스의 개수
		for(int t = 1; t <= T; t++) {
			int ans = 1; // 유효함
			int N = Integer.parseInt(br.readLine()); // 테스트 케이스의 길이
			String str = br.readLine(); // 테스트 케이스의 문자열
			Stack<String> s = new Stack(); // 스택 생성
			
			for(int i = 0; i < N; i++) {
				if(ans == 0) break;
				String c = String.valueOf(str.charAt(i)); // 현재 넣을 괄호
				
				if(!s.isEmpty()) { // 스택이 비어 있지 않다면
					String tmp = s.peek(); // 제일 위에 있는거 가져옴
					switch(c) { // 닫는 괄호 짝이 맞으면 꺼내기
						case ")":
							if(tmp.equals("(")) s.pop();
							else ans = 0;
							break;
						case "}":
							if(tmp.equals("{")) s.pop();
							else ans = 0;
							break;
						case "]":
							if(tmp.equals("[")) s.pop();
							else ans = 0;
							break;
						case ">":
							if(tmp.equals("<")) s.pop();
							else ans = 0;
							break;
						case "(" :
							s.push(c);
							break;
						case "{" :
							s.push(c);
							break;
						case "[" :
							s.push(c);
							break;
						case "<" :
							s.push(c);
							break;
						default: // 아니면 유효하지 않음
							ans = 0;
							break;
					}
				} else { // 비어 있으면 추가
					s.push(c);
				}
			}

			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
