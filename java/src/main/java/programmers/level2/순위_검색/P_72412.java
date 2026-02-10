package programmers.level2.순위_검색;

/**
 * Platform: Programmers
 * Problem: 72412
 * Title: 순위_검색
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/72412
 */
public class P_72412 {
	
	public int[] solution(String[] info, String[] query) {
		int[] answer = {};
		return answer;
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
