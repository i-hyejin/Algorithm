import java.io.*;
import java.util.*;

public class b1992 {
	private static StringBuilder sb = new StringBuilder();
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 영상의 크기
		map = new int[N][N]; // 영상
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0'; // String 형태로 받았으므로 '0' 빼기
			}
		}
		
		recursive(0, 0, N);

		System.out.println(sb);
	}

	private static void recursive(int r, int c, int size) {
		if(isPossible(r, c, size)) { // 모두 같은 값이면 색 정보 추가
			sb.append(map[r][c]);
			return;
		}
		
		int half = size / 2; // 사이즈 반으로 줄이기
		
		sb.append('(');
		
		recursive(r, c, half); // 1사분면
		recursive(r, c+half, half); // 2사분면
		recursive(r+half, c, half); // 3사분면
		recursive(r+half, c+half, half); // 4사분면
		
		sb.append(')');
		
	}

	private static boolean isPossible(int r, int c, int size) { // (r,c)~(r+size,c+size)가 모두 같은 값인지 판단하는 함수
		int value = map[r][c]; // 맵 정보
		
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(value != map[i][j]) // 값이 다르면
					return false; // false 반환
			}
		}
		return true; // 끝까지 왔으면 true 반환
	}

}
