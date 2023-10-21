import java.io.*;
import java.util.*;

public class b2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// input
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		// logic
		Collections.sort(list);
		
		// output
		for (int j = 0; j < N; j++) {
			sb.append(list.get(j)+ "\n");
		}
		System.out.println(sb.toString());
	}

}
