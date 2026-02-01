package programmers.level2.수식_최대화;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Platform: Programmers
 * Problem: 67257
 * Title: 수식 최대화
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/67257
 */
public class P_67257 {
	
	public long solution(String expression) {
		long answer = 0;
		
		// 수, 연산자 분리
		ArrayList<Long> numList = new ArrayList<>();
		ArrayList<String> opList = new ArrayList<>();
		
		// 연산자 기준으로 분리. (true일 경우, 구분자도 포함됨)
		StringTokenizer st = new StringTokenizer(expression, "+-*", true);
		
		// 수, 연산자 리스트에 분리해서 넣기  (while문 조건에 바로 st.hasMoreTokens() 넣어도 됨)
		while (true) {
			if (st.hasMoreTokens()) {
				String token = st.nextToken();
				if ("+".equals(token) || "-".equals(token) || "*".equals(token)) {
					opList.add(token);
				} else {
					numList.add(Long.parseLong(token));
				}
			} else {
				break;
			}
		}
		
		// 연산 경우의 수. 3! => 6가지 (시간복잡도 측면에서 하드코딩해도 무방)
		String[][] opCaseAry = {
				{"+", "-", "*"},
				{"+", "*", "-"},
				{"-", "+", "*"},
				{"-", "*", "+"},
				{"*", "+", "-"},
				{"*", "-", "+"}
		};
		
		// 6가지 경우 순회
		for (int o = 0; o < opCaseAry.length; o++) {
			String[] curOpCase = opCaseAry[o];    // 연산 우선순위 케이스
			
			ArrayList<Long> copyNumList = new ArrayList<>(numList);
			ArrayList<String> copyOpList = new ArrayList<>(opList);
			
			// 연산 순회
			for (int i = 0; i < 3; i++) {
				String op = curOpCase[i]; // 이번에 계산할 연산자
				
				for (int j = 0; j < copyOpList.size(); j++) {
					if (copyOpList.get(j).equals(op)) {
						
						long pre = copyNumList.get(j);
						long post = copyNumList.get(j + 1);
						long res = cal(pre, post, op);
						
						copyNumList.remove(j + 1); // 뒤 숫자 삭제
						copyNumList.set(j, res);        // 앞의 숫자를 결과값으로 변경
						copyOpList.remove(j);            // 사용한 연산자 삭제
						j--;    // 연산자 삭제 후 위치 조정
					}
				}
			}
			
			long result = Math.abs(copyNumList.get(0));    // 음수 감안하여 절대값 표기
			answer = Math.max(answer, result);        // 더 큰 값으로 교체
		}
		return answer;
	}
	
	// 전후 수 계산
	public long cal(long pre, long post, String op) {
		if ("+".equals(op)) {
			return pre + post;
		} else if ("-".equals(op)) {
			return pre - post;
		} else {
			return pre * post;
		}
	}
	
}
