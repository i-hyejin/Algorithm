import java.io.*;
import java.util.*;

public class b10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] alphabet = new int[26]; // alphabet 배열
		Arrays.fill(alphabet, -1); // alphabet 배열 -1로 초기화
		for (int i = 0; i < str.length(); i++) {
			if(alphabet[str.charAt(i) - 'a'] < 0) {
				alphabet[str.charAt(i) - 'a'] = i;
			}
		}
		
		for (int i = 0; i < alphabet.length; i++) {
			System.out.print(alphabet[i] + " ");
		}
		
	}

}
