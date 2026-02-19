package programmers.level1.자연수_뒤집어_배열로_만들기;


import java.util.ArrayList;
import java.util.List;

/**
 * Platform: Programmers
 * Problem: 12932
 * Title: 자연수 뒤집어 배열로 만들기
 * 정답률: 88%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12932
 * NOTE: 교재 확인 전 풀이
 */
public class P_12932 {
	
	// 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴
	public int[] solution(long n) {
		String s = String.valueOf(n);
		char[] nums = s.toCharArray();
		int[] ans = new int[nums.length];
		int index = 0;
		for (int i = nums.length -1 ; i >= 0; i--) {
			ans[index++] = Character.getNumericValue(nums[i]); // num[i] - '0' 을 해도 int형 리턴
		}
		return ans;
	}
	
	// 1. while문을 통해 10으로 나눈 나머지를 배열의 요소로 구성하는 방식
	public int[] solution2(long n) {
		List<Integer> list = new ArrayList<>();
		while (n > 0) {
			list.add((int)(n % 10));
			n = n / 10;
		}
		return list.stream().mapToInt(i -> i).toArray();
	}
	
	public int[] solution3(long n) {
		String s = String.valueOf(n);
		char[] ary = s.toCharArray();
		int[] answer = new int[ary.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = Character.getNumericValue(ary[ary.length - 1 - i]);
		}
		return answer;
	}
	
	// stringbuilder 활용하기
	public int[] solution4(long n) {
		String s = Long.toString(n);
		char[] ary = new StringBuilder(s).reverse().toString().toCharArray();
		int[] answer = new int[ary.length];
		int index = 0;
		for (char c : ary) {
			answer[index++] = Character.getNumericValue(c);
		}
		return answer;
	}
	
}
