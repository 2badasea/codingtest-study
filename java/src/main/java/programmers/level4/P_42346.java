package programmers.level4;

import java.util.Arrays;

/**
 * Platform: Programmers
 * Problem: 42346
 * Title: 징검다리
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42346
 */
public class P_42346 {
	
	public int solution(int distance, int[] rocks, int n) {
		// 마지막 바위 위치와 도착지점까의 거리도 판단해야 하므로 배열 복사 (크기 + 1)
		rocks = Arrays.copyOf(rocks, rocks.length + 1);
		rocks[rocks.length - 1] = distance;
		Arrays.sort(rocks);		// 오름차순 정렬
		
		int start = 1;
		int end = distance + 1;
		while (end - start > 1) {
			int d = (start + end) / 2;
			if (isValid(d, rocks, n)) {
				start = d;
			} else {
				end = d;
			}
		}
		return start;
	}
	
	private boolean isValid (int d, int[] rocks, int n) {
		int removed = 0;
		int last = 0;
		
		for (int rock : rocks) {
			if (rock - last < d) {
				removed++;
				continue;
			}
			last = rock;
		}
		return removed <= n;
	}
	
}
