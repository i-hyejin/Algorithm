import java.io.*;
import java.util.*;

public class b10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수
		Stack<Integer> stack = new Stack<Integer>(); // 스택
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); // 한 줄 읽기
			String command = st.nextToken(); // 명렁어
			
			switch(command) {
			case("push"): 
				int value = Integer.parseInt(st.nextToken()); // 이어서 정수 하나 읽기
				stack.add(value); // stack에 추가
				break;
			case("top"):
				if(stack.isEmpty()) { // 비어 있으면 -1
					sb.append(-1 + "\n");
				} else { // 비어 있지 않으면 가장 위에 있는 정수
					sb.append(stack.peek() + "\n");
				}
				break;
			case("size"): 
				sb.append(stack.size() + "\n"); // 스택의 크기
				break;
			case("empty"):
				if(stack.isEmpty()) { // 비어 있으면 1
					sb.append(1 + "\n");
				} else { // 비어 있지 않으면 0
					sb.append(0 + "\n");
				}
				break;
			case("pop"): 
				if(stack.isEmpty()) { // 비어 있으면 -1
					sb.append(-1 + "\n"); 
				} else { // 비어 있지 않으면 가장 위에 있는 정수 하나 꺼내기
					sb.append(stack.pop() + "\n");
				}
				break;
			}
		}
		
		bw.write(sb.toString()); // bw로 내보내기
		bw.flush();
		bw.close();
	}

}
