package com.bada;

import java.util.*;
import java.util.function.Consumer;

public class Main {
	
	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.solution("aabbaccc"));
	}
	
	// 압축 문자열
	public int solution(String s) {
		int minVal = s.length();    // 최악의 경우 (압축이 되지 않았을 때 처음 길이 그대로)
		if (minVal == 1) {
			return minVal;
		}
		// 절반까지만 잘라낸다.
		for (int i = 1; i <= s.length() / 2; i++) {
			// 1 ~ n개까지 잘라서 압축된 문자열의 길이를 반환
			int res = compressedLength(s, i);
			minVal = Math.min(minVal, res);
		}
		return minVal;
	}
	
	private int compressedLength(String s, int n) {
		StringBuilder sb = new StringBuilder();
		String compareStr = s.substring(0, n);    // 비교 기준 문자열
		int repeat = 1;
		for (int i = n; i <= s.length(); i += n) {
			int endIndex = Math.min(i + n, s.length());
			String subStr = s.substring(i, endIndex);
			if (compareStr.equals(subStr)) {
				repeat++;
			} else {
				if (repeat > 1) {
					sb.append(repeat);
				}
				sb.append(compareStr);
				compareStr = subStr;
				repeat = 1;
			}
		}
		sb.append(compareStr);
		return sb.length();
	}
	
	// 조건에 부합하는 사람의 숫자를 배열로 리턴
	public int[] solution72412(String[] info, String[] query) {
		// 참여자들의 정보를 기반으로 전처리 진행
		Map<String, List<Integer>> datas = processInfos(info);
		
		int[] answers = new int[query.length];
		for (int i = 0; i < query.length - 1; i++) {
			answers[i] = count(query[i], datas);
		}
		return answers;
	}
	
	// 조건에 부합하는 개수 찾기
	private int count(String qry, Map<String, List<Integer>> datas) {
		String[] qrys = qry.split(" (and )");
		int targetScore = Integer.parseInt(qrys[qrys.length - 1]);
		String condition = String.join("", Arrays.copyOfRange(qrys, 0, qry.length() - 1));
		if (datas.containsKey(condition)) {
			List<Integer> scores = datas.get(condition);
			// 타겟점수보다 같거나 큰 수의 index
			int resCount = search(targetScore, scores);    // 0을 리턴할 수도 있음
			return resCount;
		} else {
			return 0;
		}
	}
	
	// 점수 리스트중 score 이상인 사람의 수를 반환
	private int search(int score, List<Integer> scoreList) {
		// 리스트 중 score 기준으로 같거나 큰 수의 인덱스를 가져온다.
		int start = 0;
		int end = scoreList.size() - 1;  // inclusive, inclusive
		while (end > start) {
			int mid = (start + end) / 2;
			if (scoreList.get(mid) >= score) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		if (scoreList.get(start) < score) {
			return 0;
		}
		return scoreList.size() - start;
	}
	
	// 경우의수별로 나누어 map 생성
	private Map<String, List<Integer>> processInfos(String[] infos) {
		Map<String, List<Integer>> map = new HashMap<>();
		for (String s : infos) {
			String[] tokens = s.split(" ");
			int score = Integer.parseInt(tokens[tokens.length - 1]);
			forEachKey(0, "", tokens, key -> {
				map.putIfAbsent(key, new ArrayList<Integer>());
				map.get(key).add(score);
			});
		}
		// key별로 점수들 오름차순 정렬
		for (List<Integer> scoreList : map.values()) {
			Collections.sort(scoreList);
		}
		return map;
	}
	
	private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
		if (index == tokens.length - 1) {
			action.accept(prefix);
			return;
		}
		forEachKey(index + 1, prefix + tokens[index], tokens, action);
		forEachKey(index + 1, prefix + "-", tokens, action);
	}
	
	
}