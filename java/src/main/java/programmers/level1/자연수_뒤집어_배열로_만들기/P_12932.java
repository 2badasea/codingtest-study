package programmers.level1.자연수_뒤집어_배열로_만들기;

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
}
