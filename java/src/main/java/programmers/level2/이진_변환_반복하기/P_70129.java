package programmers.level2.이진_변환_반복하기;

/**
 * Platform: Programmers
 * Problem: 70129
 * Title: 이진 변환 반복하기
 * 정답률: 78%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/70129
 * NOTE: 교재 확인 전 풀이
 * cf.1) 0을 제거할 때, StringBuilder를 이용하는 것 대신 s = s.replaceAll("0", "");를 활용하면 조금 더 간결해진다.
 * cf.2) Integer.toString(숫자, 2); 외에 Integer.toBinaryString(숫자); 를 활용 가능
 */
public class P_70129 {
	
	public int[] solution(String s) {
		int removeZeroCnt = 0;
		int radixCnt = 0;
		
		// 문자열 s에서 0모두 제거
		while (!s.equals("1")) {
			radixCnt++;        // "1"이 아니면 무조건 이진변환 실행
			char[] chars = s.toCharArray();
			StringBuilder sb = new StringBuilder();
			for (char c : chars) {
				if (c == '1') {
					sb.append(c);
				}
			}
			String str = sb.toString();        // 숫자 1로만 구성됨
			removeZeroCnt += s.length() - str.length();
			if (str.equals("1")) {
				break;
			} else {
				s = Integer.toString(str.length(), 2);
			}
		}
		
		return new int[]{radixCnt, removeZeroCnt};
	}
}
