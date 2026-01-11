package baekjoon.p10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Platform: BOJ
 * Problem: 10816
 * Title: 숫자 카드 2
 * URL: https://www.acmicpc.net/problem/10816
 * 정답률: 39.380%
 * NOTE: 이진 탐색 활용해보기
 */
public class P10816_BinarySearch_Manual {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] aryN = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			aryN[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 정렬
		Arrays.sort(aryN);
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			int findNum = Integer.parseInt(st.nextToken());
			int findCnt = getNumCount(aryN, findNum);
			sb.append(findCnt).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	// 이진 탐색을 통해 숫자 findNum이 배열N에 몇 개가 있는지 반환
	static int getNumCount(int[] ary, int findNum) {
		int minIndex = 0;
		int maxIndex = ary.length - 1;
		int cnt = 0;
		
		while (minIndex <= maxIndex) {
			int midIndex = (minIndex + maxIndex) / 2;
			if (ary[midIndex] == findNum) {
				cnt++;
				int addCnt = aroundSearch(ary, midIndex, findNum);
				cnt += addCnt;
				break;
			} else if (ary[midIndex] < findNum) {
				minIndex = midIndex + 1;
			} else {
				maxIndex = midIndex - 1;
			}
		}
		return cnt;
	}
	
	static int aroundSearch(int[] ary, int stdIndex, int findNum) {
		int ascendIndex = stdIndex + 1;
		int descendIndex = stdIndex - 1;
		int addCnt = 0;
		// 기준보다 큰 것 탐색
		while (true) {
			if (ascendIndex >= ary.length) {
				break;
			}
			if (ary[ascendIndex] == findNum) {
				addCnt++;
				ascendIndex++;
			} else {
				break;
			}
		}
		// 기준보다 작은 것 탐색
		while (true) {
			if (descendIndex < 0) {
				break;
			}
			if (ary[descendIndex] == findNum) {
				addCnt++;
				descendIndex--;
			} else {
				break;
			}
		}
		return addCnt;
	}
	
}
