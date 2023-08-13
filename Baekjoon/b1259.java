import java.io.*;
import java.util.*;

public class b1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine(); // 한 줄 입력 받기
			if(str.equals("0")) // 0이면 그만 (문자열 비교이므로 equals 사용)
				break;
			
			boolean flag = true; // flag를 true로 설정
			for (int i = 0; i < str.length(); i++) { // 문자열의 개수만큼 반복
				if(str.charAt(i) != str.charAt(str.length() - i - 1)) { // i번째와 str.length()-i-1번째가 다르면
					flag = false; // flag를 false로 설정
				}
			}
			
			if(flag == false) { // flag가 false면 no
				sb.append("no\n");
			} else { // flag가 true이면 yes
				sb.append("yes\n");
			}
		}
		bw.write(sb.toString()); // StringBuilder에 추가한 문자열 String으로 바꾸기
		bw.flush(); // 버퍼 작성하기
		bw.close();
	}

}
