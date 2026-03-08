package programmers.level2;


import java.util.HashSet;

/**
 * Platform: Programmersz
 * Problem: 42577
 * Title: 전화번호 목록
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class P42577 {
	
	// 시간복잡도 생각하면서 풀어보기 => phone_book의 길이 100만 -> 단순 루프를 돌 경우 100만 x 100만
	public boolean solution(String[] phone_book) {
		
		// HashSet 활용
		HashSet<String> phoneSet = new HashSet<>();
		for (String phone : phone_book) {
			phoneSet.add(phone);
		}
		
		// 한 개씩 꺼내서 검사
		for (String phone : phone_book) {
			if (hasPrefix(phone, phoneSet)) {
				return false;
			}
		}
		return true;
	}
	
	// 전달받은 번호의 앞부분이 셋에 존재하는지 확인 (분리 안 해도 무방)
	private boolean hasPrefix(String phone, HashSet<String> set) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < phone.length() - 1; i++) {
			sb.append(phone.charAt(i));
			// 해시셋 확인
			if (set.contains(sb.toString())) {
				return true;
			}
		}
		return false;
	}
	
	
}
