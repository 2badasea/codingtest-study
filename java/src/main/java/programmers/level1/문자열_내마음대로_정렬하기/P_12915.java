package programmers.level1.문자열_내마음대로_정렬하기;

import java.util.Arrays;

/**
 * Platform: Programmers
 * Problem: 12915
 * Title: 문자열_내마음대로_정렬하기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12915
 * NOTE: 교재내용 풀이
 */
public class P_12915 {
	
	public String[] solution(String[] strings, int n) {
		// 스트림을 사용하지 않고, 바로 Arrays.sort(). 스트림의 경우엔 sorted() 사용 시, 정렬된 스트림을 반환한다
		Arrays.sort(strings, (s1, s2) -> {
			// 문자를 비교 후 다를 때만 정렬이 필요하다
			if (s1.charAt(n) != s2.charAt(n)) {
				return s1.charAt(n) - s2.charAt(n);
			}
			return s1.compareTo(s2);
		});
		
		return strings;
	}
}
