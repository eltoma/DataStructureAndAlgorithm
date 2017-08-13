package com.topic.sort;

/**
 * 以a[0]为根元素
 * 堆排序实现
 * @author elotoma
 */
public class MaxHeapSort extends Base{
	// 从最后一个有孩子节点的节点向前，依次下沉
	public static void buildMaxHeap(int[] a) {
		// 最后一个有孩子节点的索引为 i = (a.length - 2) / 2
		for (int i = (a.length - 2) / 2; i >= 0; i--) {
			sink(a, i, a.length);
		}
	}
	/**
	 * 堆下沉操作
	 * 以a[0]作为堆的起始点
	 * 左孩子：2 * k + 1  右孩子  2 * k + 2
	 * @param a 被操作数组
	 * @param K 要下沉的元素的索引
	 * @param N 堆的索引范围 (0~N-1)
	 */
	public static void sink(int[] a, int k, int N) {
/*		System.out.printf("sink index %d, the val is %d |   ", k, a[k]);
		System.out.println();*/
		while (2*k + 1 < N) {
			int j = 2 * k + 1 ;
			if (j + 1 < N && a[j + 1] > a[j]) j++;// 找到较大的孩子节点
			
			if(a[k] > a[j]) break;    // a[k]大于所有孩子节点，结束下沉
			swap(a, k, j);            // 下沉一次
			k = j;
		}
	}
	
	public static void heapSort(int[] a) {
		buildMaxHeap(a);
		int N = a.length -1;
		// 当堆只有两个元素时，子数组自然有序
		while(N > 0) {
/*			System.out.printf("N: %d | ", N);
			show(a);*/
			// 将堆顶堆尾交换，并缩减堆大小
			swap(a, 0, N--);
			// 把堆顶元素下沉，重新调整子数组为堆结构
			// 对于整数有 a <= b  等价于 a < b + 1
			sink(a, 0, N+1);
		}
	}
	
	public static void main(String[] args) {
		while(true) {
			int[] in = genTestCase(100, 100);
			show(in);
			heapSort(in);
			show(in);
			System.out.println();
			if(!isSorted(in)) break;
		}
	}
}
