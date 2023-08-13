import java.io.*;
import java.util.*;

public class b1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 과목의 개수
		int[] arr = new int[N]; // 점수 배열
		int M = 0; // 최대값 점수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			M = Math.max(M, arr[i]); // 최대값 점수 찾기
		}
		
		double avg = 0; // 새로운 평균
		for (int i = 0; i < N; i++) {
			double newScore = (double)arr[i] / M * 100;
			avg += newScore; // 점수 / 최고점 * 100
		}
		avg /= N; // 과목의 개수로 나누어서 평균 구하기
		
		System.out.println(avg); // 출력
	}

}
