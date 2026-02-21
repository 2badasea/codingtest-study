package programmers.level3;

import java.util.Arrays;

/**
 * Platform: Programmers
 * Problem: 43238
 * Title: 입국심사
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/43238
 */
public class P_43238 {
	
	public long solution(int n, int[] times) {
		// 이진탐색 활용 -> 1 ~ 최악의 시간 구성 -> 이진탐색 진행 (탐색값 기준으로 모든 인원을 처리할 수 있는지 체크)
		long answer = 0L;
		// 1) 심사대 오름차순 정렬
		Arrays.sort(times);
		long start = 1;
		long end = (long) n * (long) times[times.length - 1];
		while (end >= start) {
			long mid = (start + end) / 2;
			long total = 0;
			for(int i = 0; i < times.length; i++) {
				total += mid / times[i];
			}
			// 시간안에 모두 처리하지 못하는 경우
			if (total < n) {
				start = mid + 1;
			} else {
				end = mid - 1;
				answer = mid;
			}
		}
		return answer;
	}
}
