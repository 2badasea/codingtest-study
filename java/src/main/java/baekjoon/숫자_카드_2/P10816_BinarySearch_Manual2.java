package baekjoon.숫자_카드_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * binarySearch를 이용하되, 우선적으로 배열 정렬
 */
public class P10816_BinarySearch_Manual2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] aryN = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			aryN[i] = Integer.parseInt(st.nextToken());
		}
		// 오름차순 정렬
		Arrays.sort(aryN);
		
		int[] uniqueValueAry = new int[N];	// 숫자를 담을 배열
		int[] countAry = new int[N];		// 숫자별 개수를 담을 배열
		
		int stdIndex = 0;		// 기준 인덱스
		int minIndex = 0;		// 순회 시작 인덱스
		// 한번 순회를 함으로써 수(uniqueValueAry)와 해당 수의 개수(countAry)에 대한 배열의 값을 채운다.
		while (minIndex < N) {
			int currentValue =  aryN[minIndex];
			int cnt = 1;
			
			int maxIndex = minIndex + 1;
			while (maxIndex < N && aryN[maxIndex] == currentValue) {
				cnt++;
				maxIndex++;
			}
			
			uniqueValueAry[stdIndex] = currentValue;
			countAry[stdIndex] = cnt;
			stdIndex++;
			
			minIndex = maxIndex;
		}
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(M * 2);
		
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int findNum =  Integer.parseInt(st.nextToken());
			int targetIndex = binarySearch(uniqueValueAry, stdIndex, findNum);
			if (targetIndex == -1) {
				sb.append(0).append(" ");
			} else {
				sb.append(countAry[targetIndex]).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	// 이진탐색을 통해 찾는 수 M(findNum)이 배열에 존재하는지 확인
	static int binarySearch(int[] uniqueValueAry, int size, int findNum) {
		int minIndex = 0;
		int maxIndex = size -1;
		
		while (minIndex <= maxIndex) {
			int midIndex =  (minIndex + maxIndex) / 2;
			if (uniqueValueAry[midIndex] == findNum) {
				return midIndex;
			} else if (uniqueValueAry[midIndex] < findNum) {
				minIndex = midIndex + 1;
			} else {
				maxIndex = midIndex - 1;
			}
		}
		return -1;
	}
	
}

