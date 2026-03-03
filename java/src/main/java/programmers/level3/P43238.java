package programmers.level3;

import java.util.*;

/**
 * Title: 입국심사
 * https://school.programmers.co.kr/learn/courses/30/lessons/43238
 * 복습 풀이
 */
public class P43238 {
	public long solution(int n, int[] times) {
		// 심사관들의 처리시간 오름차순 정렬
		Arrays.sort(times);
		
		long left = 1; // 가능한 최소 시간
		long right = (long) times[times.length - 1] * n;    // 가장 느린 심사관 혼자서 n명 소요 시간
		
		while (left < right) {
			long mid = (left + right) / 2;
			
			// 시간동안 심사가능 인원수
			long count = 0;
			for (int t : times) {
				count += mid / t; // 각 심사관이 mid 시간 동안 몇 명을 처리할 수 있는지 더함
			}
			
			if (count >= n) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return left;
	}
}
