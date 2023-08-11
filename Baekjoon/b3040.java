import java.io.*;
import java.util.*;

public class b3040 {

	private static int[] works;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		works = new int[9]; // 아홉 난쟁이의 모자에 쓰여진 수
		for (int i = 0; i < works.length; i++) {
			works[i] = Integer.parseInt(br.readLine());
		}
		
		recursive(new int[7], 0, 0);
	}

	// idx : 원본 배열의 인덱스, k : 선택 배열의 인덱스
	private static void recursive(int[] sel, int idx, int k) {
		// basis part
		if(k == sel.length) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			
			if(sum == 100) {
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}
			}
			return;
		}
		
		// inductive part
		for (int i = idx; i < works.length; i++) {
			sel[k] = works[i];
			recursive(sel, i+1, k+1);
		}
	}

}
