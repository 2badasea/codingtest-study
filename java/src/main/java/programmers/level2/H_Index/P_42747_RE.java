package programmers.level2.H_Index;

import java.util.Arrays;

/**
 * Platform: Programmers
 * Problem: 42747
 * Title: H_Index
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class P_42747_RE {
	
	// 풀이 1
	public int solution(int[] citations) {
		int n = citations.length;
		Arrays.sort(citations);
		for (int h = n; h >= 1; h--) {
			int count = 0;
			for (int citation : citations) {
				if (citation >= h) {
					count++;
				}
			}
			if (count >= h) {
				return h;
			}
		}
		return 0;
	}
	
	// 풀이2
	public int solution2(int[] citations) {
		// h-index: h번 이상 인용된 논문의 개수가 h편 이상인 것에서 최대값
		// 3, 0, 6, 1, 5
		
		int n = citations.length;
		Arrays.sort(citations);			// 0, 1, 3, 5, 6
		for (int i = 0; i < n; i++) {
			int h = n - i;
			
			// h값을 감소시키면서 h값보다 같거나 큰 요소가 h개 이상인 조건 충족 시 리턴
			if (citations[i] >= h) {
				return h;
			}
		}
		return 0;
	}
}
