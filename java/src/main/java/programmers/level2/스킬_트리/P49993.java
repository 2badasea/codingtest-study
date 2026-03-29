package programmers.level2.스킬_트리;


/**
 * Platform: Programmers
 * Problem: P49993
 * Title: 스킬트리
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/49993
 */
public class P49993 {
	
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for (String tree : skill_trees) {
			if (verifyOrder(skill, tree)) {
				System.out.println("상승: " + tree);
				answer++;
			}
		}
		// 순서가 보장?
		return answer;
	}
	
	// tree 순회
	private boolean verifyOrder(String skill, String tree) {
		int orderIndex = 0;
		
		// tree를 순회하면서 검증
		for (int i = 0; i < tree.length(); i++) {
			char curSkill = tree.charAt(i);
			int skillPos = skill.indexOf(curSkill);
			// 존재한다는 가정
			if (skillPos != -1) {
				if (skillPos == orderIndex) {
					orderIndex++;
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	// skill 순회방식으로 검증
	private boolean verifyLoopSkill(String skill, String tree) {
		char[] sk = skill.toCharArray();
		int preIndex = tree.indexOf(sk[0]);
		
		for (int i = 1; i < sk.length; i++) {
			int curIndex = tree.indexOf(sk[i]);
			// 첫 번째 스킬이 존재하지 트리에 존재하지 않았다면 false
			if (preIndex == -1 && curIndex != -1) {
				return false;
			}
			// 두 조건을 만족하지만, 순서가 바뀐 경우
			if (preIndex != -1 && curIndex != -1) {
				if (curIndex < preIndex) {
					return false;
				}
			}
			preIndex = curIndex;
		}
		return true;
	}
	
	public static void main(String[] args) {
		P49993 p49993 = new P49993();
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		int res = p49993.solution(skill, skill_trees);
		System.out.println("결과: " + res);
	}
}
