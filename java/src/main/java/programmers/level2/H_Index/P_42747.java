package programmers.level2.H_Index;

import java.util.Arrays;

/**
 * Platform: Programmers
 * Problem: 42747
 * Title: H_Index
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class P_42747 {
	
	public int solution(int[] citations) {
		
		Arrays.sort(citations);
		for (int h = citations.length; h > 0; h--) {
			if (isValid2(citations, h)) {
				return h;
			}
			// if (isValid(citations, h)) {
			// 	return h;
			// }
		}
		return 0;
	}
	
	private boolean isValid2(int[] citations, int h) {
		int index = citations.length - h;
		return citations[index] >= h;
		
	}
	
	private boolean isValid(int[] citations, int h) {
		int cnt = 0;
		
		for (int citation : citations) {
			if (citation >= h) {
				cnt++;
			}
		}
		return cnt >= h;
	}
	
}
