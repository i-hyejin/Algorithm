import java.util.*;

public class b2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N장의 카드
		Queue<Integer> q = new ArrayDeque<Integer>(); // 큐 생성
		
		for(int i = 1; i <= N; i++) { // N만큼 카드 쌓기
			q.offer(i);
		}
		
		int temp = 0;
		while(true) {
			if(q.size() == 1) {
				break;
			}
			
			q.poll(); // 카드 버리기
			
			if(q.size() == 1) {
				break;
			}
			
			temp = q.peek(); // 카드 꺼내기
			q.poll(); // 카드 버리기
			q.offer(temp); // 카드 밑으로 옮기기
		}
		
		System.out.println(q.peek()); // 제일 위에 있는 카드		
	}

}
