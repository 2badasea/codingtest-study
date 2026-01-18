package programmers.level2.문자열_압축;

import java.util.ArrayList;
import java.util.List;

/**
 * Platform: Programmers
 * Problem: 60057
 * Title: 문자열 압축
 * 정답률: 44%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */
public class P_60057 {
	
	public int solution(String s) {
		
		// 문자열을 쪼개서 길이 1부터 문자열의 길이까지 쪼개서 List에 모두 담음
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= s.length(); i++) {
			int result = split(s, i);
			if (result < min) {
				min = result;
			}
		}
		return min;
		// list에 담은 것을 반복문을 통해 한 개씩 꺼내어, 카운팅을 시작
		// 위 결과를 통해서 길이 1부터~길이N까지 잘랐을 때의 결과값을 순차적으로 비교하여 가장 작은 값을 최종 반환
	}
	
	public int split(String s, int length) {
		
		List<String> list = new ArrayList<>();
		for (int startIndex = 0; startIndex < s.length(); startIndex += length) {
			int endIndex = startIndex + length;
			if (endIndex > s.length()) {
				endIndex = s.length();
			}
			list.add(s.substring(startIndex, endIndex));
		}
		
		// 길이 단위로 분할 시킨 요소들을 기준으로 압축한 다음 길이를 반환한다
		return compressedLength(list);
	}
	
	public int compressedLength(List<String> list) {
		StringBuilder sb = new StringBuilder();
		
		String last = "";
		int count = 1;
		for (String s : list) {
			if (s.equals(last)) {
				count++;
			} else {
				if (count > 1) {
					sb.append(count);
				}
				sb.append(last);
				last = s;
				count = 1;
			}
		}
		if (count > 1) {
			sb.append(count);
		}
		sb.append(last);
		
		return sb.length();
	}
	
}
