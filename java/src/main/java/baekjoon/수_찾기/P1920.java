package baekjoon.수_찾기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Platform: BOJ
 * Problem: 1920
 * Title: 수 찾기
 * URL: https://www.acmicpc.net/problem/1920
 * NOTE: 정렬과 이진탐색을 활용한 방식
 */
public class P1920 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// N을 입력하고 크기 N의 배열을 생성한다.
		int n = Integer.parseInt(br.readLine());
		int[] aryN = new int[n];
		
		// 크기 N의 정수배열을 구성한다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			aryN[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정수배열 aryN을 오름차순으로 정렬한다(N logN)
		Arrays.sort(aryN);
		
		// aryN 배열에서 찾아야 하는 수의 배열을 생성한다 다음 값을 담는다.
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());
			int hasX = Arrays.binarySearch(aryN, x);
			// 없는 경우
			if (hasX < 0) {
				sb.append(0 + "\n");
			} else {
				sb.append(1 + "\n");
			}
		}
		
		br.close();
		bw.write(sb.toString());
		bw.flush();
		// bw.close(); // 굳이 닫지 않는 것을 권장(특히 System.out 래핑 시)
		
		// 위에서 bw.flush(), bw.close()까지 한 상태에서 System.out을 통한 출력은 아예 안 되거나 환경에 따라 예외/무시가 될 수 있음
		// System.out.println(sb);
	}
}
