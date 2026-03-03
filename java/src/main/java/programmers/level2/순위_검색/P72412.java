package programmers.level2.순위_검색;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/72412
// 교재 확인 전 풀이
public class P72412 {
	
	public int[] solution(String[] info, String[] query) {
		
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		
		// 지원자별 케이스 모두 key로 생성
		for (String i : info) {
			String[] data = i.split(" ");
			
			// 각 정보별로 원래 값과 '-' 두 가지 경우의 수에 대한 배열 선언
			String[] lang = {data[0], "-"};
			String[] job = {data[1], "-"};
			String[] career = {data[2], "-"};
			String[] food = {data[3], "-"};
			int score = Integer.parseInt(data[4]);        // 점수
			
			for (String l : lang) {
				for (String j : job) {
					for (String c : career) {
						for (String f : food) {
							String key = l + j + c + f;        // '-'도 포함
							
							// map에 문자열 key가 없는 경우 추가
							if (!map.containsKey(key)) {
								map.put(key, new ArrayList<>());
							}
							// 조건별 점수 추가
							map.get(key).add(score);
						}
					}
				}
			}
		}
		
		// 조건별 점수분포(list) 오름차순 정렬. 최대 108
		for (ArrayList<Integer> list : map.values()) {
			list.sort(null);
		}
		
		int[] answer = new int[query.length];
		
		// 조건 순회
		for (int i = 0; i < query.length; i++) {
			// 조건에서 점수 분리
			String[] qData = query[i].replaceAll(" and ", "").split(" ");
			
			String key = qData[0];    // 검색 대상 키
			int targetScore = Integer.parseInt(qData[1]);        // 점수
			
			if (map.containsKey(key)) {
				ArrayList<Integer> list = map.get(key);
				
				// 이진탐색 진행
				int left = 0;
				int right = list.size();
				
				// [50, 80, 150, 150, 210]  score: 100 가정
				while (left < right) {
					int mid = (left + right) / 2;
					
					if (list.get(mid) >= targetScore) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				answer[i] = list.size() - left;
			} else {
				answer[i] = 0;
			}
		}
		
		return answer;
	}
	
}
