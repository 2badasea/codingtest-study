package com.bada;

import java.util.ArrayList;
import java.util.StringTokenizer;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	
	public static void main(String[] args) {
		Main m = new Main();
	}
	
	public int[] solution(int[][] arr) {
		int[] answer = {};
		
		return answer;
	}
	
	// 이진탐색 메서드 직접 구현해볼 것
	public int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length;		// end는 미포함
		
		// 조건문 지정
		while (start < end) {		// '='를 할 경우 start == end == arr.length에 의해서 mid = arr.length가 될 수 있으며, ary[mid]는 예외가 터지게 된다.
			int mid = (start + end) / 2;
			int midVal = arr[mid];
			
			if (midVal == target) {
				return mid;
			} else if (midVal < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		return -1;
	}
	
}