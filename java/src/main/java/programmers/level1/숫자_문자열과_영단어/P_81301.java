package programmers.level1.숫자_문자열과_영단어;

import java.util.HashMap;
import java.util.Map;

/**
 * Platform: Programmers
 * Problem: 81301
 * Title: 숫자 문자열과 영단어
 * 정답률: 73%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/81301
 * NOTE: 아래 주석처리된 부분과 같이 람다식의 경우에 .forEach 안에서는 외부 지역 변수(s)의 값을 변경할 수 없음 -> 람다식이 아닌 for문으로 해결
 */
public class P_81301 {
	
	public int solution(String s) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("zero", "0");
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		map.put("four", "4");
		map.put("five", "5");
		map.put("six", "6");
		map.put("seven", "7");
		map.put("eight", "8");
		map.put("nine", "9");
		
		for (String key : map.keySet()) {
			if (s.contains(key)) {
				s = s.replace(key, map.get(key).toString());
			}
		}
		// map.keySet().stream().forEach(key -> {
		// 	if (s.contains(key)) {
		// 		s.replace(key, map.get(key).toString());
		// 	}
		// });
		
		return Integer.parseInt(s);
	}
}
