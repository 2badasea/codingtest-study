package programmers.level1.문자열_내림차순으로_배치하기;


import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Platform: Programmers
 * Problem: 12917
 * Title: 문자열_내림차순으로_배치하기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12917
 * NOTE: 교재내용 풀이
 */
public class P_12917 {
	
	public String solution(String s) {
		// 아스키코드 상으로 대문자가 소문자보다 작음
		StringBuilder sb = new StringBuilder();
		// 데이터의 양이 아주 많은 경우라면 forEach를 순회하는 것보단 .collect(Collectors.joining()); 호출하는 것이 빠름
		s.chars().mapToObj(i -> (char) i).sorted((v1, v2) -> v2 - v1).forEach(sb::append);
		
		// .collect(
		// 		StringBuilder::new,           // 1. Supplier: 결과를 담을 빈 그릇(StringBuilder) 생성
		// 		StringBuilder::appendCodePoint, // 2. Accumulator: 스트림의 요소(int)를 그릇에 어떻게 담을지
		// 		StringBuilder::append         // 3. Combiner: 병렬 스트림일 때 여러 그릇을 어떻게 합칠지
		// )
		
		return sb.toString();
	}
}
