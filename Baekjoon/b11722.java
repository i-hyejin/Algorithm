import java.io.*;
import java.util.*;

public class b11722 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] d = new int[N];
		int max = 0;
		
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		d[0] = 1;
		for (int i = 1; i < d.length; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if(a[i] < a[j] && d[i] <= d[j]) {
					d[i] = d[j] + 1;
				} else if(a[i] == a[j]) {
					d[i] = d[j];
				}
			}
		}
		
		for (int i = 0; i < d.length; i++) {
			max = Math.max(max, d[i]);
		}
		
		System.out.println(max);
	}
}
