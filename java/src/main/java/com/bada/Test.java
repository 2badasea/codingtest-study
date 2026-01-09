package com.bada;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("테스트 코드입니다.");
	}
	
	private int search(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}
}
