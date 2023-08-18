import java.util.*;

public class b1920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt(); // N개의 정수
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr); // 정렬
		
		int M = sc.nextInt(); // M개의 정수
		for (int i = 0; i < M; i++) {
			if(binarySearch(arr, sc.nextInt()) >= 0){ // arr에 존재하는지
				sb.append(1).append("\n"); // 존재하면 1 추가
			} else {
				sb.append(0).append("\n"); // 존재하지 않으면 0 추가
			}
		}
		
		System.out.println(sb);
	}

	private static int binarySearch(int[] arr, int key) {
		int start = 0; // 시작 위치
		int end = arr.length - 1; // 종료 위치
		
		while(start <= end) { // 시작 위치보다 종료 위치가 작거나 같을 때까지 반복
			int mid = (start + end) / 2; // 중간 지점
			
			if(key < arr[mid]){ // key 값이 중간 지점보다 작으면
				end = mid - 1; // 종료 위치 조정
			} else if(key > arr[mid]) { // key 값이 중간 지점보다 크면
				start = mid + 1; // 시작 위치 조정
			} else { // key 값과 중간 지점 값과 같으면
				return mid; // mid가 찾는 값임
			}
		}
		
		return -1;
	}
}
