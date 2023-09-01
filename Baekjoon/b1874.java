import java.io.*;
import java.util.*;

public class b1874 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>(); // 스택 생성
		StringBuilder sb = new StringBuilder(); // 정답을 저장할 StringBuilder
		
		int n = sc.nextInt(); // n개의 수를 입력 받음
		int cnt = 1; // 몇 번째까지 숫자를 넣었는지 세는 변수
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt(); // 숫자 하나를 입력 받음
			
			if(num >= cnt) { // 입력 받은 숫자가 cnt보다 크거나 같으면
				while(num >= cnt) { 
					stack.push(cnt++); // stack에 push
					sb.append("+\n");
				}
			}
			
			if(!stack.isEmpty() && stack.peek() == num) { // 스택이 비어 있지 않고 peek 값이 num과 같으면
				stack.pop(); // stack에서 pop
				sb.append("-\n");
			}
			
			if(num < cnt) { // 입력 받은 숫자가 cnt보다 작으면
				while(num == cnt) { // cnt와 같아질 때까지
					stack.pop(); // stack에서 pop
					sb.append("-\n");
				}
			}
		}
		
		if(stack.isEmpty()) // stack이 비어 있으면 입력된 수열을 만들 수 있으므로
			System.out.println(sb); // sb 출력
		else 				// stack이 비어 있지 않으면
			System.out.println("NO"); // NO 출력
	
	}	

}
