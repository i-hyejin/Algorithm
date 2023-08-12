import java.util.Scanner;

public class b2439 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < N; j++) {
				if(j < N-i) {
					sb.append(" ");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
