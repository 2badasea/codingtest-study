package programmers.level2.순위_검색;

import java.util.*;
import java.util.function.Consumer;

/**
 * Platform: Programmers
 * Problem: 72412
 * Title: 순위_검색
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/72412
 */
public class P_72412 {
	
	public int[] solution(String[] info, String[] query) {
		// 왜 map구조로 해야 했는지?  참가자 수 N에 대해서 질의 M을 만족하는지 모두 체크 -> N * M (50,000 * 100,000 => 약 50억의 시간복잡도로 구성)
		// 개별 참가자별 조합할 수 있는 모든 조합 구성. 해당 구성과 그에 따른 점수를 관리
		Map<String, List<Integer>> conditions = buildConditions(info);
		int[] answer = new int[query.length];
		
		// 질의를 다시 해체하기
		for (int i = 0; i < query.length; i++) {
			String[] ary = query[i].split(" (and )?");
			String key = String.join("", Arrays.copyOf(ary, ary.length - 1));
			// 질의에 맞는 조건자가 없는 경우 0 리턴
			if (!conditions.containsKey(key)) {
				answer[i] = 0;
				continue;
			}
			int targetScore = Integer.parseInt(ary[ary.length - 1]);
			// 이진탐색을 통해서 확인
			List<Integer> scores = conditions.get(key);
			int start = 0;
			int end = scores.size() - 1;
			while (end > start) {
				int mid = (end + start) / 2;
				if (scores.get(mid) >= targetScore) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}
			if (scores.get(start) >= targetScore) {
				answer[i] = scores.size() - start;
			} else {
				answer[i] = 0;
			}
		}
		return answer;
	}
	
	private Map<String, List<Integer>> buildConditions(String[] info) {
		Map<String, List<Integer>> conditions = new HashMap<>();
		
		// 모든 사용자에 대한 조건과 점수 리스트들을 추가
		for (String s : info) {
			String[] tokens = s.split(" ");    // 공백을 기준으로 모두 분리
			int score = Integer.parseInt(tokens[tokens.length - 1]);
			// key는 생성된 문자열 조건
			forEachBuildKey(0, "", tokens, key -> {
				conditions.putIfAbsent(key, new ArrayList<>());
				conditions.get(key).add(score);
			});
		}
		
		// 각 조건별 점수를 오름차순으로 정렬
		for (List<Integer> list : conditions.values()) {
			Collections.sort(list);
		}
		return conditions;
	}
	
	private void forEachBuildKey(int index, String prefix, String[] tokens, Consumer<String> consumer) {
		// consumer가 aceept한 요소들이 key로 반환된다고 보면 된다.
		if (index == tokens.length - 1) {
			consumer.accept(prefix);
			return;
		}
		forEachBuildKey(index + 1, prefix + tokens[index], tokens, consumer);
		forEachBuildKey(index + 1, prefix + "-", tokens, consumer);
	}
	
	
	// 무지성 풀이(시간초과)
	public int[] worstSolution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		
		for (int q = 0; q < query.length; q++) {
			int count = 0;
			String[] conditions = query[q].split(" and ");
			
			for (int i = 0; i < info.length; i++) {
				String[] infoAry = info[i].split(" ");
				if (!infoAry[0].equals(conditions[0]) && !"-".equals(conditions[0])) {
					continue;
				}
				if (!infoAry[1].equals(conditions[1]) && !"-".equals(conditions[1])) {
					continue;
				}
				if (!infoAry[2].equals(conditions[2]) && !"-".equals(conditions[2])) {
					continue;
				}
				if (!conditions[3].startsWith(infoAry[3]) && '-' != conditions[3].charAt(0)) {
					continue;
				}
				int score = Integer.parseInt(conditions[3].split(" ")[1]);
				if (Integer.parseInt(infoAry[4]) >= score) {
					count++;
				}
			}
			answer[q] = count;
		}
		return answer;
	}
	
}
