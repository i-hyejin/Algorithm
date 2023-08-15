import java.io.*;
import java.util.*;

public class b1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 단어의 개수
		String[] arr = new String[N]; // 단어를 저장할 배열
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() { // Comparator를 이용한 정렬
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) // 단어의 길이가 같다면
					return o1.compareTo(o2); // 사전순 정렬
				return o1.length() - o2.length(); // 단어의 길이를 기준으로 정렬
			}
		});
		
		Set<String> set = new HashSet<String>(); // 단어의 중복을 확인할 set 배열
		for (int i = 0; i < arr.length; i++) {
			if(set.add(arr[i])) { // set에 넣을 수 있다면(중복되지 않았다면)
				sb.append(arr[i] + "\n"); // StringBuilder에 추가
			}
		}
		
		System.out.println(sb.toString());
	}

}
