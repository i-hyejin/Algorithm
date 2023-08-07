import java.util.*;

public class b1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N명의 사람
		int K = sc.nextInt(); // K번째 사람 제거
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> l = new ArrayList<Integer>(); // 링크드리스트
		int[] arr = new int[N]; // 정답 배열
		for(int i = 1; i <= N; i++) {
			l.add(i);
		}
		int index = 0;
		for(int i = 0; i < N; i++) {
			index = index + K - 1; // index 구하기
			if(index >= l.size()) { // index가 l.size()보다 크거나 같으면 크기만큼 빼기
				index -= l.size() * (index / l.size());
			}			
			
			arr[i] = l.get(index); // 정답 배열에 추가
			l.remove(index); // 요소 삭제
		}
		
		// 출력
		System.out.print("<");
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) 
				System.out.print(arr[i]);
			else
				System.out.print(", " + arr[i]);
		}
		System.out.print(">");
	}

}
