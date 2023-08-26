import java.awt.Point;
import java.io.*;
import java.util.*;

public class swea1767 {
	
	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {-1, 1, 0, 0};
	
	private static int N;
	private static int[][] map;
	private static ArrayList<Point> coreList;
	private static int minWire;
	private static int maxCore;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // cell의 한 변
			map = new int[N][N]; // cell
			coreList = new ArrayList<>(); // core 위치
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // 0:빈셀, 1:core
					// 가장자리에 있거나 빈칸이면 패쓰
					if(i == 0 || i == N-1 || j == 0 || j == N-1 || map[i][j]==0 ) continue; 
					// 가장자리가 아니고 core가 있으면 리스트에 저장
					coreList.add(new Point(i, j)); 
				}
			}
			
			maxCore = Integer.MIN_VALUE; // 선택할 수 있는 최대 코어의 개수
			minWire = Integer.MAX_VALUE; // 최소 와이어의 길이
			
			connectWire(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(minWire).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void connectWire(int idx, int wire, int core) {
		// basis part
		if(idx == coreList.size()) { // 모든 core를 살펴봤으면
			if(maxCore < core) { // 최대한 많은 core에 연결한 경우 업데이트
				maxCore = core;
				minWire = wire;
			} else if(maxCore == core) { // 같은 core를 연결한 경우 더 짧은 wire로 업데이트
				minWire = Math.min(wire, minWire);
			}
			return;
		}
		
		// inductive part
		int r = coreList.get(idx).x;
		int c = coreList.get(idx).y;
		
		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			int cnt = 0;
			
			// 한쪽 방향으로 쭉 가기
			while(true) {
				nr += dr[d];
				nc += dc[d];
				
				// 범위 밖으로 나가거나
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
					break;
				}
				// 다른 코어가 존재하면 다른 방향으로 감
				if(map[nr][nc] == 1) { 
					cnt = 0;
					break;
				}
				
				// 전선이 갈 수 있음
				cnt++;
			}
				
			// cnt 개수만큼 채우기
			int mr = r;
			int mc = c;
			for (int i = 0; i < cnt; i++) {
				mr += dr[d];
				mc += dc[d];
				map[mr][mc] = 1;
			}
			
			if(cnt == 0) { // 연결한 core가 없는 경우
				connectWire(idx+1, wire, core); // 다음 core 확인
			} else { // 연결한 core가 있는 경우
				connectWire(idx+1, wire+cnt, core+1); // 다음 core 확인 + 값 업데이트
				
				// cnt 개수만큼 채운거 되돌리기
				mr = r;
				mc = c;
				for (int i = 0; i < cnt; i++) { 
					mr += dr[d];
					mc += dc[d];
					map[mr][mc] = 0;
				}
			}
		}
	}

}
