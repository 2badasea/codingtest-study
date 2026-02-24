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
		long end = (long) n * times[times.length - 1];
		while (end >= start) {
			long mid = (start + end) / 2;
			long total = 0;
			// 심사관 한 명당 소요시간 합산
			for (int i = 0; i < times.length; i++) {
				total += mid / times[i];
			}
			// 시간안에 모두 처리하지 못하는 경우	=> 소요시간 더 필요 (중심을 우측으로)
			if (total < n) {
				start = mid + 1;
			} else {
				end = mid - 1;
				answer = mid;
			}
		}
		return answer;
	}
	
	// 재풀이
	public long solutionRe(int n, int[] times) {
		// 모든 사람이 심사를 받는데 걸리는 시간의 최소값 리턴
		// 소요시간 오름차순 정렬
		long answer = 0L;
		Arrays.sort(times);
		long start = 1;        // 최저 소요시간
		long end = (long) n * times[times.length - 1];        // 최대 소요시간
		while (end >= start) {
			long mid = (start + end) / 2;
			long total = 0;
			for (int i = 0; i < times.length; i++) {
				total += mid / times[i];
			}
			// 사람을 모두 심사하지 못함
			if (total < n) {
				start = mid + 1;
			} else {
				end = mid - 1;
				answer = end;
			}
		}
		return answer;
	}
	
	// 교재식 문제풀이
	public long solutionBook(int n, int[] times) {
		long answer = 0L;
		long start = 0;    // 최소소요시간
		long end = 1000000000000000000L;    // 최대소요시간
		while (end >= start) {
			long mid = (start + end) / 2;        // 중간 소요시간
			// 모든 인원수를 커버할 수 있는지 체크
			if (isValid(mid, n, times)) {
				answer = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return answer;
	}
	
	private boolean isValid (long mid, int n, int[] times) {
		long total = 0;
		// 심사관 한 명당 처리할 수 있는 사람의 숫자를 모두 더한다.
		for (int t : times) {
			total += mid / t;
		}
		// 모두 처리하지 못한 경우, 소요시간을 중간보다 큰 범위로 축소시킨다.
		if (total < n) {
			return false;
		} else {
			return true;
		}
	}
}
