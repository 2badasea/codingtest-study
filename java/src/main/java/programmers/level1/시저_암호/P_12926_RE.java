package programmers.level1.시저_암호;

// 교재와 다른 방식으로 재풀이
public class P_12926_RE {
	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			char res = processor(c, n);
			System.out.print(res);
			sb.append(processor(c, n));
		}
		return sb.toString();
	}
	
	// n은 1이상, 25이하인 자연수 => 한 번에 대문자에서 소문자로 연달아 변경되는 경우는 없ㅁ음
	private char processor(char c, int n) {
		if (Character.isWhitespace(c)) {
			return c;
		}
		char st = Character.isUpperCase(c) ? 'A' : 'a';
		int curPosition = c - st;    // 기준점을 기준으로 어느 정도 거리에 위치해있는지
		int newPosition = curPosition + n;
		// 몫이 1이상이라는 건, 대문자 혹은 소문자 범위를 벗어난 것을 의미
		if (newPosition / ('Z' - 'A' + 1) > 0) {
			// 넘어간 경우, 나머지 만큼 기준점에서 더해준다.
			return (char) (st + (newPosition % ('Z' - 'A' + 1)));
		} else {
			// 넘어가지 않은 경우, 이동한 만큼 더해주고 리턴
			return (char) (c + n);
		}
	}
}
