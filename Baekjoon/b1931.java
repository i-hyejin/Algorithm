import java.io.*;
import java.util.*;

public class b1931 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(new File("input.txt")));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 회의 수
		int[][] times = new int[N][2]; // 회의 정보
		for (int i = 0; i < times.length; i++) {
			times[i][0] = sc.nextInt();
			times[i][1] = sc.nextInt();
		}
		
		Arrays.sort(times, new Comparator<int[]>(){ // 회의의 종료 시간이 느린 순으로 정렬
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) { // 회의 종료 시간이 같으면 시작 시간이 느린 순으로 정렬
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		int sel = 0; // 첫 번째 회의 선택 가정
		int ans = 1; // 선택한 회의의 개수
		for (int i = 1; i < times.length; i++) {
			if(times[sel][1] <= times[i][0]) { // 마지막 회의의 종료 시간보다 선택한 회의의 시작 시간이 크거나 같으면
				sel = i;
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
