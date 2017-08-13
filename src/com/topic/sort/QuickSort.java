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
	
	// TODO ����
	public static void qsort(int[] a, int lo, int hi) {
		// ֻʣ��1��Ԫ��
		if(hi <= lo) return;
		
		show(a, lo, hi);
		int j = partition(a, lo, hi);
		show(a, lo, hi);
		System.out.println();
		
		// β�ݹ�
		// �ȵݹ� ���� ���� �̵� ������
		qsort(a, lo, j - 1);
		qsort(a, j + 1, hi);
	}
	
	/**
	 * ȡa[lo]��Ϊ����Ԫ��
	 * @param a
	 * @param lo
	 * @param hi
	 * @return ������ɺ󣬻���Ԫ�ص�λ��
	 */
    private static int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		while(true) {
			// ++i �Թ���һ�� ����Ԫ��
			while(a[++i] < a[lo]) {
				if(i == hi) {
					break;
				}
			}
			while(a[--j] > a[lo]) {
				// a[lo]�Ѿ���Ϊһ���ڱ�������j==lo����ȥ��
				if(j == lo) {
					break;
				}
			}
			// i j����, ���ֽ���
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
