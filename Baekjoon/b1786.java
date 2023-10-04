import java.io.*;
import java.util.*;

public class b1786 {

	private static char[] text;
	private static char[] pattern;
	private static int tsize;
	private static int psize;
	private static int[] piTable;
	private static int cnt;
	private static StringBuilder index;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// input
		text = br.readLine().toCharArray(); // 텍스트
		pattern = br.readLine().toCharArray(); // 패턴
		tsize = text.length; // 텍스트의 길이
		psize = pattern.length; // 패턴의 길이
		
		cnt = 0; // P가 몇 번 나타나는지
		index = new StringBuilder(); // P가 나타나는 위치
		piTable = new int[psize]; // 부분일치 테이블
		
		// logic
		getPiTable(); // 부분일치 테이블 구하기
		KMP(); // KMP 알고리즘 적용
		
		// output
		System.out.println(cnt);
		System.out.println(index.toString());
	}

	private static void KMP() {
		int p = 0; // 패턴 인덱스
		
		for (int t = 0; t < tsize; t++) { // 텍스트 인덱스
			while(p > 0 && text[t] != pattern[p]) { // 다르면
				p = piTable[p-1]; // 테이블 참조하여 이동
			}
			
			if(text[t] == pattern[p]) { // 같으면
				if(p == psize - 1) { // 패턴 끝까지 봤으면
					++cnt; // cnt 1 추가
					index.append(t-p+1 + " "); // 시작 위치 저장
					p = piTable[p]; // 테이블 참조하여 이동
				}
				else { // 패턴 끝까지 못 본거면
					p++; // 한 칸 이동
				}
			}
		}
	}

	private static void getPiTable() {
		int prev = 0; // 시작 인덱스
		for (int now = 1; now < psize; now++) { // 같은지 확인할 인덱스
			while(prev > 0 && pattern[now] != pattern[prev]) { // 다르면
				prev = piTable[prev-1]; // 테이블 참조하여 이동
			}
			
			if(pattern[now] == pattern[prev]) // 같으면
				piTable[now] = ++prev; // 시작 인덱스 한 칸 뒤부터 살펴보면 된다
		}
	}

}
