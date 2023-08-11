import java.io.*;
import java.util.*;

public class b12100 {
	private static List<Integer> l;
	private static int N;
	private static int[][] map;
	private static int[] nums = {1, 2, 3, 4};
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 맵의 크기
		map = new int[N][N]; // 맵
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursive(new int[5], 0); // 5번 반복
		System.out.println(max); // 최대값 출력
	}
	
	private static void recursive(int[] sel, int idx) {
		// basis part
		if(idx == sel.length) { // 다 선택했으면
			int[][] arr = new int[N][N]; // 새로운 맵 만들어서 map 복사
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, arr[i], 0, N);
			}
			
			for (int i = 0; i < sel.length; i++) { // 선택한 command만큼 move
				arr = move(arr, sel[i]);
			}
			
			for (int i = 0; i < N; i++) { // 최대값 찾기
				for (int j = 0; j < N; j++) {
					max = Math.max(max, arr[i][j]);
				}
			}
			
			return;
		}
		
		// inductive part
		for (int i = 0; i < nums.length; i++) { // 4개 중에 중복해서 5개 구하기(중복 순열)
			sel[idx] = nums[i];
			recursive(sel, idx + 1);
		}
	}

	private static int[][] move(int[][] arr, int command) {
		switch(command) { // command 방향 대로 한 줄 빼기 -> 값이 같으면 연산하기 -> 다시 배열에 넣기
		case 1:
			for(int i = 0; i < N; i++) { // 리스트로 빼기
				l = new ArrayList<Integer>();
				for(int j = 0; j < N; j++) {
					if(arr[j][i] > 0) {
						l.add(arr[j][i]);
					}
				}
				for(int j = 0; j < l.size(); j++) { // 값이 같으면 연산하기
					if(j+1 < l.size() && l.get(j).equals(l.get(j+1))) {
						int temp = l.get(j);
						l.set(j, temp * 2);
						l.remove(j+1);
					}
				}
				for(int j = 0; j < N; j++) { // 다시 배열에 넣기
					if(j < l.size()) {
						arr[j][i] = l.get(j);
					} else {
						arr[j][i] = 0;
					}
				}
			}
			break;
		case 2:
			for(int i = 0; i < N; i++) { // 리스트로 빼기
				l = new ArrayList<Integer>();
				for(int j = N-1; j >= 0; j--) {
					if(arr[j][i] > 0) {
						l.add(arr[j][i]);
					}
				}
				for(int j = 0; j < l.size(); j++) { // 값이 같으면 연산하기
					if(j+1 < l.size() && l.get(j).equals(l.get(j+1))) {
						int temp = l.get(j);
						l.set(j, temp * 2);
						l.remove(j+1);
					}
				}
				for(int j = 0; j < N; j++) { // 다시 배열에 넣기
					if(j < l.size()) {
						arr[N-1-j][i] = l.get(j);
					} else {
						arr[N-1-j][i] = 0;
					}
				}
			}
			break;
		case 3:
			for(int i = 0; i < N; i++) { // 리스트로 빼기
				l = new ArrayList<Integer>();
				for(int j = 0; j < N; j++) {
					if(arr[i][j] > 0) {
						l.add(arr[i][j]);
					}
				}
				for(int j = 0; j < l.size(); j++) { // 값이 같으면 연산하기
					if(j+1 < l.size() && l.get(j).equals(l.get(j+1))) {
						int temp = l.get(j);
						l.set(j, temp * 2);
						l.remove(j+1);
					}
				}
				for(int j = 0; j < N; j++) { // 다시 배열에 넣기
					if(j < l.size()) {
						arr[i][j] = l.get(j);
					} else {
						arr[i][j] = 0;
					}
				}
			}
			break;
		case 4:
			for(int i = 0; i < N; i++) { // 리스트로 빼기
				l = new ArrayList<Integer>();
				for(int j = N-1; j >= 0; j--) {
					if(arr[i][j] > 0) {
						l.add(arr[i][j]);
					}
				}
				for(int j = 0; j < l.size()-1; j++) { // 값이 같으면 연산하기
					if(j+1 < l.size() && l.get(j).equals(l.get(j+1))) {
						int temp = l.get(j);
						l.set(j, temp * 2);
						l.remove(j+1);
					}
				}
				for(int j = 0; j < N; j++) { // 다시 배열에 넣기
					if(j < l.size()) {
						arr[i][N-1-j] = l.get(j);
					} else {
						arr[i][N-1-j] = 0;
					}
				}
			}
			break;
		}
		
		return arr;
	}

}
