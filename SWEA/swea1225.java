import java.util.*;

public class swea1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테스트 케이스의 개수
		for(int t = 1; t <= T; t++) {
			int tc = sc.nextInt();
			Queue<Integer> q = new ArrayDeque<Integer>(); // 큐 생성
			for(int i = 0; i < 8; i++) { // 처음에는 스택에 저장
				q.offer(sc.nextInt());
			}
			
			int k = 1;
			boolean flag = false;
			while(true) {
				if(flag == true) {
					break;
				}
				
				int temp = q.peek(); // 제일 위에 있는 수
				q.poll(); // 하나 꺼내기
				if(temp - k > 0) { // temp - k가 0보다 크면 그대로 빼기
					temp -= k;
				} else { // temp - k 가 0이거나 0보다 작으면 0으로
					temp = 0;
					flag = true;
				}
				q.offer(temp); // k만큼 빼서 넣기
				k++; // k 증가
				if(k > 5) { // k가 5보다 크면 한 사이클 종료이므로 1 감소부터 시작
					k -= 5;
				}
			}
			
			// 출력
			System.out.printf("#%d ", t);
			while(!q.isEmpty()) { // 비어있을 때까지
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}

}
