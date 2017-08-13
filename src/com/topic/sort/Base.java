package com.topic.sort;

import java.util.Random;

public class Base {
    protected static void swap(int[] a, int i, int j) {
    	int c = a[i];
    	a[i] = a[j];
    	a[j] = c;
    }
    
	public static void show(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
	}
	
	public static boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i-1] > a[i]) return false;
		}
		return true;
	}
	
	public static int[] genTestCase(int length, int max) {
		Random random = new Random();
		int[] a = new int[length];
		for (int i = 0; i < length; i++) {
			a[i] = Math.abs(random.nextInt()) % max;
		}
		
		return a;
	}
}
