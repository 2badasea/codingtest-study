package programmers.level1.숫자_문자열과_영단어;

import java.util.HashMap;
import java.util.Map;

/**
 * Platform: Programmers
 * Problem: 81301
 * Title: 숫자 문자열과 영단어
 * 정답률: 73%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/81301
 * NOTE: 교재 풀이 => 영어단어가 담긴 String 배열의 인덱스 활용
 */
public class P_81301_BOOK {
	
	public int solution(String s) {
		String[] numArys = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		for (int i = 0; i < numArys.length; i++) {
			if (s.contains(numArys[i])) {
				s = s.replace(numArys[i], Integer.toString(i));
			}
		}
		return Integer.parseInt(s);
	}
}
