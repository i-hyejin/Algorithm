import java.io.*;
import java.util.*;

public class b9663 {

	private static int N;
	private static int[] arr;
	private static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 체스판의 크기
		arr = new int[N];
		
		nQueen(0);
		System.out.println(ans);		
	}

	private static void nQueen(int depth) {
		// basis part
		if(depth == N) { // depth를 다 채웠으면
			ans++;
			return;
		}
		
		// inductive part
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			if(isPossible(depth)) { // 놓을 수 있는 위치인지
				nQueen(depth + 1);
			}
		}
	}

	private static boolean isPossible(int col) { // col에 놓을 수 있는지
		for (int i = 0; i < col; i++) {
			if(arr[col] == arr[i]) { // 같은 열이면
				return false;  // 놓을 수 없음
			}
			
			else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) { // col-row 차이가 같으면
				return false; // 놓을 수 없음
			}
		}
		return true;
	}

}
