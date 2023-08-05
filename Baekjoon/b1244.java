import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class b1244 {
	static boolean[] arr;

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("b1244_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 스위치의 개수
		arr = new boolean[N]; // 스위치의 상태
		for(int n = 0; n < N; n++) {
			if(sc.nextInt() == 1) { // 1 : 켜져 있음, 0 : 꺼져 있음
				arr[n] = true;
			} else {
				arr[n] = false; 
			}
		}
		int student = sc.nextInt(); // 학생 수
		for(int s = 0; s < student; s++) {
			int selection = sc.nextInt(); // 1(남) : 자기 배수 , 2 : 좌우대칭 구간
			int value = sc.nextInt(); // 스위치 기준
			
			switch(selection) {
			case 1: // 자기 배수
				for(int n = 0; n < N; n++) {
					if((n+1) % value == 0) {
						arr[n] = !arr[n]; // 스위치 조작
					}
				}
				break;
			case 2: // 좌우대칭 구간
				symmetry(value-1, value-2, value);
				break;
			default:
				break;
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int n = 0; n < N; n++) {
			if((n > 0) && (n % 20 == 0)) {
				sb.append("\n");
			}
			if(arr[n] == true) {
				sb.append(1 + " ");
			} else {
				sb.append(0 + " ");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void symmetry(int value, int left, int right) {
		if(left >= 0 && left < arr.length && right >= 0 && right < arr.length) { // 범위 내
			if(arr[left] == arr[right]) { // 대칭
				if(left == 0 || right == arr.length-1) { // 마지막
					for(int i = left; i <= right; i++) {
						arr[i] = !arr[i]; // 스위치 조작
					}
				}
				else{ // 마지막이 아니면 한번 더
					symmetry(value, left-1, right+1);
				}
			} else { // 대칭이 아니면 여기까지 조작
				for(int i = left+1; i <= right-1; i++) {
					arr[i] = !arr[i]; // 스위치 조작
				}
			}
		} else { // 범위 내에 없으면
			arr[value] = !arr[value];
		}
	}

}
