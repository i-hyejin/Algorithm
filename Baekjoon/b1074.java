import java.util.Scanner;

public class b1074 {
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		recursive(r, c, (int)Math.pow(2, N));
		
		System.out.println(cnt);
	}

	private static void recursive(int r, int c, int size) {
		// basis part
		if(size == 1) { // size가 1이 되면 종료
			return;
		}
		
		// inductive part
		int half = size / 2;
		if(r < half && c < half) { // 1사분면
			recursive(r, c, half);
		} else if(r < half && c >= half) { // 2사분면
			cnt += (size * size) / 4;
			recursive(r, c-half, half);
		} else if(r >= half && c < half) { // 3사분면
			cnt += (size * size) / 4 * 2;
			recursive(r-half, c, half);
		} else if(r >= half && c >= half) { // 4사분면
			cnt += (size * size) / 4 * 3;
			recursive(r-half, c-half, half);
		}
		
	}

}
