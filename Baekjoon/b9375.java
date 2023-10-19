import java.io.*;
import java.util.*;

public class b9375 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스의 개수
		for (int t = 1; t <= T; t++) {
			// input
			int n = sc.nextInt();
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String name = sc.next(); // 옷 이름
				String type = sc.next(); // 옷 종류
				if(map.containsKey(type)) { // 이미 있는 종류이면
					map.put(type, map.get(type) + 1);
				}
				else map.put(type, 1); // 처음 보는 종류이면
			}
			
			// logic
			int ans = 1;
			Set<String> set = map.keySet();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				int cnt = map.get(it.next());
				ans *= (cnt + 1); // 입지 않는 경우를 하나 더함
			}
			
			// output
			System.out.println(ans - 1); // 모두 입지 않는 경우를 뺌
		}
	}

}
