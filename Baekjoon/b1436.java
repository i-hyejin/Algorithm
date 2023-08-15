import java.util.Scanner;

public class b1436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int num = 666;
		int cnt = 1;
		
		while(cnt != N) {
			num++;
			if(String.valueOf(num).contains("666")) { // 666을 포함하고 있다면
				cnt++; // cnt 추가
			}
		}

		System.out.println(num);
	}

}
