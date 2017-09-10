package com.topic.Base;

public class Print {
	public static void showMat(int[][] m, int bitCnt){
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("%"+ bitCnt + "d",m[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void showArr(int[][] a, int bitCnt){
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%"+ bitCnt + "d",a[i]);
		}
	}
	
	public static void println(String s) {
		System.out.println(s);
	}
	
	public static void print(String s) {
		System.out.print(s);
	}
	
	public static void main(String[] args) {
		int[][] m = {{1,2,3}, {2,4,6}};
		showMat(m, 2);
	}
}
