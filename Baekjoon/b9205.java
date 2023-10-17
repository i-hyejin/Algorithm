import java.awt.Point;
import java.io.*;
import java.util.*;

public class b9205 {
	private static int n;
	private static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		
		for (int t = 1; t <= T; t++) {
			
			// input
			n = Integer.parseInt(br.readLine()); // 편의점의 개수
			Point point[] = new Point[n+2]; // 좌표
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// logic
			map = new boolean[n+2][n+2]; // 연결 여부
			for (int i = 0; i < n+2; i++) {
				for (int j = i; j < n+2; j++) {
					int dis = Math.abs(point[i].x - point[j].x) + Math.abs(point[i].y - point[j].y);
					if(dis <= 1000) { // 거리가 1000보다 작으면 이동 가능
						map[i][j] = true;
						map[j][i] = true;
					}
				}
			}
			
			// output
			if(bfs()) { // 탐색
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}

	private static boolean bfs() {
		boolean v[] = new boolean[n+2];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		v[0] = true;
		
		while(!q.isEmpty()) {
			int p = q.poll();
			
			if(p == n+1) { // 도착 지점까지 도착하면
				return true;
			}
			
			for (int i = 0; i < n+2; i++) {
				if(map[p][i] && !v[i]) { // 이동할 수 있고, 아직 이동하기 전이면
					v[i] = true;
					q.add(i);
				}
			}
		}
		
		return false;
	}

}
