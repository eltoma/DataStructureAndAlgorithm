package com.topic.sort;

public class QuickSort extends Base{
	public static void main(String[] args) {
		int[] a = {6,4,2,5,2,3,1,7,9,10};
		show(a);
		qsort(a) ;//(a, 0, a.length - 1);
		show(a);
	}
	
	

	public static void show(int[] a, int lo, int hi) {
		System.out.println();
		for (int i = lo; i <= hi; i++) {
			System.out.print(a[i] + ", ");
		}
	}
	public static void qsort(int[] a) {
		qsort(a, 0, a.length - 1);
	}
	
	// TODO 测试
	public static void qsort(int[] a, int lo, int hi) {
		// 只剩下1个元素
		if(hi <= lo) return;
		
		show(a, lo, hi);
		int j = partition(a, lo, hi);
		show(a, lo, hi);
		System.out.println();
		
		// 尾递归
		// 先递归 长的 还是 短的 子数组
		qsort(a, lo, j - 1);
		qsort(a, j + 1, hi);
	}
	
	/**
	 * 取a[lo]作为划分元素
	 * @param a
	 * @param lo
	 * @param hi
	 * @return 划分完成后，划分元素的位置
	 */
    private static int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		while(true) {
			// ++i 略过第一个 划分元素
			while(a[++i] < a[lo]) {
				if(i == hi) {
					break;
				}
			}
			while(a[--j] > a[lo]) {
				// a[lo]已经最为一个哨兵，测试j==lo可以去掉
				if(j == lo) {
					break;
				}
			}
			// i j相遇, 划分结束
			if(i >= j) break;
			swap(a, i, j);
		}
		
		swap(a, lo, j);
		return j;
	}
/*    private static void swap(int[] a, int i, int j) {
    	int c = a[i];
    	a[i] = a[j];
    	a[j] = c;
    }*/
}
