package baekjoon.p1920;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Arrays.binarySearch()를 메서드가 아닌 직접 구현해서 풀이해보기
 */
public class P1920_BinarySearch_Manual {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] aryN = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			aryN[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(aryN);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			int hasIn = binarySearch(aryN, x);
			if (hasIn > 0) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		}
		
		br.close();
		System.out.println(sb);
	}
	
	
	/**
	 * 이진탐색을 수행하는 함수
	 * @param ary 탐색대상 배열
	 * @param findNum 찾아야 하는 수
	 * @return
	 */
	static int binarySearch(int[] ary, int findNum) {
		int minIndex = 0;
		int maxIndex = ary.length - 1;
		
		while (minIndex <= maxIndex) {
			int midIndex = (maxIndex + minIndex) / 2;
			
			// 찾는 숫자가 일치하면 바로 1턴 리턴
			if (ary[midIndex] == findNum) {
				return 1;
			}
			// 찾는 수가 기준보다 큰 경우 => minIndex를 수정해서 범위를 좁힌다.
			else if (ary[midIndex] < findNum) {
				minIndex = midIndex + 1;
			}
			// 찾는 수가 기준보다 작은 경우 => maxIndex를 수정한다.
			else {
				maxIndex = midIndex - 1;
			}
		}
		// 최종적으로 못 찾은 경우엔 -1리턴
		return -1;
	}
	
}
