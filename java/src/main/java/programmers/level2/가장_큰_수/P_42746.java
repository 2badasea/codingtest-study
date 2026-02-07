package programmers.level2.가장_큰_수;


import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Platform: Programmers
 * Problem: 42746
 * Title: 가장_큰_수
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class P_42746 {
	public String solution(int[] numbers) {
		
		// 숫자들의 조합을 비교하여 내림차순으로 정렬
		return Arrays.stream(numbers).mapToObj(String::valueOf)
				.sorted((s1, s2) -> {
					int originSet = Integer.parseInt(s1 + s2);
					int reversedSet = Integer.parseInt(s2 + s1);
					// 조합의 결과에서 내림차순 정렬
					return reversedSet - originSet;
				})
				.collect(Collectors.joining(""))
				.replaceAll("^0+", "0");
	}
}
