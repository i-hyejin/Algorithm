import java.io.*;
import java.util.*;

public class b16637 {

	private static int N;
	private static char[] arr;
	private static int ans;
	private static int opNum;
	private static ArrayList<Integer> num;
	private static ArrayList<Character> op;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine()); // 수식의 길이
		arr = br.readLine().toCharArray(); // 수식
		num = new ArrayList<>(); // 피연산자
		op = new ArrayList<>(); // 연산자
		for (int i = 0; i < N; i++) {
			if(i % 2 == 0) num.add(arr[i] - '0');
			else op.add(arr[i]);
		}
		ans = Integer.MIN_VALUE; // 최소값 정해주기
		
		// logic
		dfs(0, num.get(0));
		
		// output
		System.out.println(ans);
	}

	private static void dfs(int index, int sum) {
		// basis part
		if(index == op.size()) { // 연산자 계산 다했으면 재귀 종료
			ans = Math.max(ans, sum);
			return;
		}
		
		// inductive part
		// 괄호 치기
		// sum op(index) num(index+1) 먼저 계산해서 sum에 넣기
		dfs(index + 1, calc(sum, op.get(index), num.get(index + 1)));
		
		// 괄호 안치기
		if(index + 2 <= op.size()) {
			// num(index+1) op(index+1) num(index+2) 계산
			int tmp = calc(num.get(index + 1), op.get(index + 1), num.get(index + 2));
			dfs(index + 2, calc(sum, op.get(index), tmp));
		}
	}

	private static int calc(int a, char opr, int b) { // a opr b 연산
		if(opr == '+') {
			return a + b;
		} else if(opr == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

}
