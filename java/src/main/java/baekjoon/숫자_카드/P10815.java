package baekjoon.숫자_카드;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Platform: BOJ
 * Problem: 10815
 * Title: 숫자 카드
 * URL: https://www.acmicpc.net/problem/10815
 * 정답률: 43.430%
 * NOTE: 정렬과 이진탐색을 활용한 1920번과 거의 동일한 문제인데, 출력값만 개행처리가 아닌 한 줄로 표현
 */
public class P10815 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 상근이 숫자 카드 N개 입력
		int N = Integer.parseInt(br.readLine());
		
		// 크기 N의 배열 선언
		int[] aryN = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			if (st.hasMoreTokens()) {
				aryN[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 정수 M개 입력
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		// 상근이가 가진 정수N개를 오름차순으로 정렬한다.
		Arrays.sort(aryN);
		
		while (st.hasMoreTokens()) {
			int findNum = Integer.parseInt(st.nextToken());
			
			if (Arrays.binarySearch(aryN, findNum) >= 0) {
				bw.write(1 + " ");
			} else {
				bw.write(0 + " ");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
}
