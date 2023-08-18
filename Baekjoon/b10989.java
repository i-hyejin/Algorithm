import java.io.*;
import java.util.*;

public class b10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 수의 개수
		int[] arr = new int[N]; // 수의 배열
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr); // 정렬
		
		for (int i = 0; i < N; i++) {
			sb.append(arr[i] + "\n"); // sb에 저장
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
