import java.io.*;
import java.util.*;

public class b3052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> set = new HashSet<>(); // 중복 없이 저장할 수 있는 set 이용
		
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine()); // 숫자 입력 받기
			set.add(n % 42); // 42로 나눈 나머지 set에 저장
		}
		
		System.out.println(set.size()); // set의 크기 출력
		
	}

}
