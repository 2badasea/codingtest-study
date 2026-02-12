package programmers.level1.이상한_문자_만들기;

// 재풀이
public class P_12930_RE {
	
	// 한 개 이상의 공백을 기준으로 단어들이 구성되어 있는 문자열
	// 짝수번째는 대문자, 홀수번째는 소문자로 변환해서 반환
	public String solution(String s) {
		// 대문자가 되는 기준 -> 단어 기준 인덱스가 0
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean isNextUpper = true;
		for (char c : chars) {
			if (Character.isAlphabetic(c)) {
				sb.append(c);
				isNextUpper = true;
				continue;
			}
			if (isNextUpper) {
				sb.append(Character.toUpperCase(c));
			} else {
				sb.append(Character.toLowerCase(c));
			}
			isNextUpper = !isNextUpper;
		}
		
		return sb.toString();
	}
}
