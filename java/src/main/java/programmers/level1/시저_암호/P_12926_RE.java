package programmers.level1.시저_암호;

// 재풀이
public class P_12926 {
	
	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			char res = processor(c, n);
			System.out.print(res);
			sb.append(processor(c, n));
		}
		return sb.toString();
	}
	
	// n은 1이상, 25이하인 자연수 => 한 번에 대문자에서 소문자로 연달아 변경되는 경우는 없음
	private char processor(char c, int n) {
		if (Character.isWhitespace(c)) {
			return c;
		}
		char st = Character.isUpperCase(c) ? 'A' : 'a';
		int curPosition = c - st;    // 기준점을 기준으로 어느 정도 거리에 위치해있는지
		int newPosition = curPosition + n;
		if (newPosition / ('Z' - 'A' + 1) > 0) {
			return (char) (st + (newPosition % ('Z' - 'A' + 1)));
		} else {
			return (char) (c + n);
		}
	}
}
