package baekjoon.수_찾기;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * HashSet 자료구조를 이용 => 시간복잡도 O(N+M)으로 해결이 가능하다.
 */
public class P1920_HashSet {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// HashSet 자료구조에 담는다. => 시간복잡도 O(N)
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		// m의 크기만큼 찾는다. O(M)
		for (int i = 0; i < m; i++) {
			if (set.contains(Integer.parseInt(st.nextToken()))) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
