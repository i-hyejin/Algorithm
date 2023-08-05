import java.io.*;
import java.util.*;

class Tower{
	int height;
	int idx;
	
	public Tower(int height, int idx) {
		this.height = height;
		this.idx = idx;
	}
}

public class b2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 탑의 수
		int[] arr = new int[N]; // 탑의 높이
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] ans = new int[N]; // 수신한 탑의 번호
		
		Stack<Tower> s = new Stack(); // 스택 생성
		for(int i = N-1; i >= 0; i--) {
			Tower tmp = new Tower(arr[i], i+1); // 타워 신호, 인덱스 번호 저장
			
			if(s.isEmpty()) { // 비어 있으면
				s.push(tmp); // 넣기
				
			} else { // 비어 있지 않으면
				while(!s.isEmpty()) { // 비어 있지 않을 때까지 반복
					int peekIdx = s.peek().idx; // 제일 위에 있는 idx
					int peekHeight = s.peek().height; // 제일 위에 있는 height
					if(peekHeight < tmp.height) { // 넣을 거보다 작으면
						s.pop(); // 꺼내기
						ans[peekIdx-1] = i+1; // 수신한 타워 저장
					} else {
						break;
					}
				}
				s.push(tmp); // 넣기
			}
		}
		
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		
	}
}
