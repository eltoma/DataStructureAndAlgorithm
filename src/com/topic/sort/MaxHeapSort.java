package com.topic.sort;

/**
 * ��a[0]Ϊ��Ԫ��
 * ������ʵ��
 * @author elotoma
 */
public class MaxHeapSort extends Base{
	// �����һ���к��ӽڵ�Ľڵ���ǰ�������³�
	public static void buildMaxHeap(int[] a) {
		// ���һ���к��ӽڵ������Ϊ i = (a.length - 2) / 2
		for (int i = (a.length - 2) / 2; i >= 0; i--) {
			sink(a, i, a.length);
		}
	}
	/**
	 * ���³�����
	 * ��a[0]��Ϊ�ѵ���ʼ��
	 * ���ӣ�2 * k + 1  �Һ���  2 * k + 2
	 * @param a ����������
	 * @param K Ҫ�³���Ԫ�ص�����
	 * @param N �ѵ�������Χ (0~N-1)
	 */
	public static void sink(int[] a, int k, int N) {
/*		System.out.printf("sink index %d, the val is %d |   ", k, a[k]);
		System.out.println();*/
		while (2*k + 1 < N) {
			int j = 2 * k + 1 ;
			if (j + 1 < N && a[j + 1] > a[j]) j++;// �ҵ��ϴ�ĺ��ӽڵ�
			
			if(a[k] > a[j]) break;    // a[k]�������к��ӽڵ㣬�����³�
			swap(a, k, j);            // �³�һ��
			k = j;
		}
	}
	
	public static void heapSort(int[] a) {
		buildMaxHeap(a);
		int N = a.length -1;
		// ����ֻ������Ԫ��ʱ����������Ȼ����
		while(N > 0) {
/*			System.out.printf("N: %d | ", N);
			show(a);*/
			// ���Ѷ���β�������������Ѵ�С
			swap(a, 0, N--);
			// �ѶѶ�Ԫ���³������µ���������Ϊ�ѽṹ
			// ���������� a <= b  �ȼ��� a < b + 1
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
