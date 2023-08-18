import java.io.*;
import java.util.*;

@SuppressWarnings("hiding")
class MyStack<Integer>{
	private int[] stack;
	private int top = -1;
	private int size;
	
	public MyStack() {
		this(10000); // 처음 사이즈는 100으로 초기화
	}
	
	public MyStack(int size) {
		this.size = size;
		stack = new int[size];
	}
	
	public void push(int value) {
		top++;
		stack[top] = value;
	}
	
	public int top() {
		if(top < 0) {
			return -1;
		}
		else return stack[top];
	}
	
	public int size() {
		return top + 1;
	}
	
	public int empty() {
		if(top < 0) {
			return 1;
		}
		else return 0;
	}
	
	public int pop() {
		if(top < 0) {
			return -1;
		}
		else return stack[top--];
	}
}

public class b10828_stack {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수
//		Stack<Integer> stack = new Stack<Integer>(); // 스택
		MyStack<Integer> stack = new MyStack<Integer>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); // 한 줄 읽기
			String command = st.nextToken(); // 명렁어
			
			switch(command) {
			case("push"): 
				int value = Integer.parseInt(st.nextToken()); // 이어서 정수 하나 읽기
				stack.push(value); // stack에 추가
				break;
			case("top"):
				sb.append(stack.top() + "\n");
				break;
			case("size"): 
				sb.append(stack.size() + "\n"); 
				break;
			case("empty"):
				sb.append(stack.empty() + "\n");
				break;
			case("pop"): 
				sb.append(stack.pop() + "\n");
			 	break;
			}
		}
		
		bw.write(sb.toString()); // bw로 내보내기
		bw.flush();
		bw.close();
	}

}
