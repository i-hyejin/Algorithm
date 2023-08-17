import java.awt.Point;
import java.io.*;
import java.util.*;

public class b16918 {
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C]; // 지도
		int[][] bomb = new int[R][C]; // 폭탄이 터지는 시간
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'O') {
					bomb[i][j] = 3; // 3초 후 터짐
				}
			}
		}
		
		int time = 0;
		while(time++ < N) { // N초 동안 반복
			if(time % 2 == 0) { // 짝수 시간에는 폭탄 놓기
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(map[i][j] == '.') { // 폭탄이 없으면
							map[i][j] = 'O'; // 폭탄 놓기
							bomb[i][j] = time + 3; // 현재로부터 3초 후에 터짐
						}
					}
				}
			} else if(time % 2 == 1) { // 홀수 시간에는 폭탄 터뜨리기
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(bomb[i][j] == time) { // 터뜨릴 폭탄이면
							map[i][j] = '.'; // 폭탄 터뜨리기
							for (int d = 0; d < 4; d++) {
								int nr = i + dr[d];
								int nc = j + dc[d];
								if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
									if(map[nr][nc] == 'O' && bomb[nr][nc] != time) { // 폭탄이 있는데 터질 시간이 안되었으면
										map[nr][nc] = '.'; // 폭탄 제거
										bomb[nr][nc] = 0; // 시간 0으로 초기화
									}
								}
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			System.out.println(map[i]);
		}
		
		
		
		
	}

}
