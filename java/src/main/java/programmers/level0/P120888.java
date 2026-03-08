package programmers.level0;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Platform: Programmers
 * Problem: 120888
 * Title: 중복된 문자 제거
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/120888
 * NOTE: stream문법도 활용해볼 것
 */
public class P120888 {
	
	public String solution(String my_string) {
		String answer = "";
		// 중복제거 & 담았을 때 순서유지
		LinkedHashSet<Character> linkedSet = new LinkedHashSet<>();
		
		for (int i = 0; i < my_string.length(); i++) {
			// 공백을 포함해서 중복된 건 거름 & 담는 순서 유지
			linkedSet.add(my_string.charAt(i));		// O(N)
		}
		
		StringBuilder sb = new StringBuilder();
		for (char c : linkedSet) {
			sb.append(c);			// O(N)
		}
		answer = sb.toString();
		return answer;
	}
}
