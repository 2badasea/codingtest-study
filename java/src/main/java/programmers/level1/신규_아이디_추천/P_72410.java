package programmers.level1.신규_아이디_추천;

/**
 * Platform: Programmers
 * Problem: 72410
 * Title: 신규 아이디 추천
 * 정답률: 52%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/72410
 */
public class P_72410 {
	public String solution(String new_id) {
		// 1단계: 소문자 치환
		new_id = new_id.toLowerCase();
		
		// 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
		// [^...] : 대괄호 안의 문자들을 '제외한' 것들을 선택
		new_id = new_id.replaceAll("[^a-z0-9._-]", "");
		
		// 3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
		// \\. : 실제 점 문자를 의미 ({2,} : 2개 이상)
		new_id = new_id.replaceAll("\\.{2,}", ".");
		
		// 4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거
		// ^[.] : 시작 부분의 점, [.]$ : 끝 부분의 점, | : OR 연산
		new_id = new_id.replaceAll("^[.]|[.]$", "");
		
		// 5단계: 빈 문자열이라면 "a"를 대입
		if (new_id.isEmpty()) {
			new_id = "a";
		}
		
		// 6단계: 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			// 제거 후 마침표(.)가 끝에 위치한다면 제거
			new_id = new_id.replaceAll("[.]$", "");
		}
		
		// 7단계: 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
		StringBuilder sb = new StringBuilder(new_id);
		while (sb.length() < 3) {
			sb.append(sb.charAt(sb.length() - 1));
		}
		
		return sb.toString();
	}
	
}
