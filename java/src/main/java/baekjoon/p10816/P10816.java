package baekjoon.p10816;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Platform: BOJ
 * Problem: 10816
 * Title: 숫자 카드 2
 * URL: https://www.acmicpc.net/problem/10816
 * 정답률: 39.380%
 * NOTE: 숫자 카드1인 10815에서 변형된 문제 => HashMap을 이용하여 풀이
 */
public class P10816 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// Map 자료구조를 활용한다.
		Map<Integer, Integer> map = new HashMap<>();
		while (st.hasMoreTokens()) {
			Integer key = Integer.parseInt(st.nextToken());
			if (map.containsKey(key)) {
				Integer value = map.get(key);
				value++;
				map.put(key, value);
			} else {
				map.put(key, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());	// 필요없음
		st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		// 찾아야 하는 숫자를 순회하면서 map의 key중에 존재하면 해당 value를 반환. (key에 존재하지 않으면 0리턴)
		while(st.hasMoreTokens()) {
			Integer findNum = Integer.parseInt(st.nextToken());
			if (map.containsKey(findNum)) {
				Integer value = map.get(findNum);
				sb.append(value).append(" ");
			} else {
				sb.append(0 + " ");
			}
		}
		
		br.close();
		System.out.println(sb.toString());
	}
	
	static int findNumCount(int[] ary, int findNum) {
		
		int findCount = 0;
		int minIndex = 0;
		int maxIndex = ary.length - 1;
		while (minIndex <= maxIndex) {
			int midIndex = (minIndex + maxIndex) / 2;
			if (ary[midIndex] == findNum) {
				findCount++;
				minIndex++;
			} else if (ary[midIndex] < findNum) {
				minIndex = midIndex + 1;
			} else {
				maxIndex = midIndex - 1;
			}
		}
		System.out.printf("findCount:  " + findCount);
		return findCount;
	}
}
