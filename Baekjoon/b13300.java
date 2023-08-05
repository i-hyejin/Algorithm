import java.util.Scanner;

public class b13300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 수학여행에 참가하는 학생 수(1000)
		int K = sc.nextInt(); // 한 방에 배정할 수 있는 최대 인원 수(1000)
		int[][] rooms = new int[2][6];
		int S = 0; // 성별
		int Y = 0; // 학년
		int ans = 0; // 필요한 방의 수
		
		for(int n = 0; n < N; n++) {
			S = sc.nextInt(); // 성별(여 : 0 / 남 : 1)
			Y = sc.nextInt(); // 학년
			rooms[S][Y-1]++;
		}
		
		for(int s = 0; s < 2; s++) {
			for(int y = 0; y < 6; y++) {
				if(rooms[s][y] > 0) { // 학생이 있으면 방 배정
					ans += rooms[s][y] / K; // 몫만큼 방이 필요
					if(rooms[s][y] % K > 0) { // 나머지가 있으면 방이 무조건 필요
						ans++;
					}
				} // 학생이 없으면 방 배정 x
			}
		}
		
		System.out.println(ans);
	}
}
