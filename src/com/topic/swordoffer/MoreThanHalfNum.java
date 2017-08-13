package com.topic.swordoffer;

import javax.print.attribute.standard.Media;

import com.topic.sort.Base;

public class MoreThanHalfNum extends Base{
	public static int partition(int[] a, int begin, int end) {
		int pivot = median3(a);
		System.out.println("pivot:" + pivot);
		show(a);
		int lo = begin;
		int hi = end - 1;
		while(true) {
			// median3�����������������ڱ�, ���õ���Խ��
			while(a[++lo] < pivot);
			while(a[--hi] > pivot);
			
			if(lo < hi) {
				// ���lo < hi ˵�����Խ���Ԫ��
				swap(a, lo, hi);
			} else {
				// ���ֻ��ֽ�����
				break;
			}
		}
		
		swap(a, lo, end - 1);
		return lo;
	}
	
	public static int median3(int[] a) {
		int center = a.length / 2,
			left = 0,
			right = a.length - 1;
		
		if(a[left] > a[center]) {
			swap(a, left, center);
		}
		
		if(a[left] > a[right]) {
			swap(a, left, right);
		}
		
		if(a[center] > a[right]) {
			swap(a, center, right);
		}
		
		// ����Ԫ���ڵ����ڶ���λ��
		swap(a, center, right - 1);
		
		return a[right - 1];
	}
	
	public static void swap(int[] a, int i, int j) {
		int c = a[i];
		a[i] = a[j];
		a[j] = c;
	}
	
	
	public static int MoreThanHalfNum(int array[]) {
		int res = -1;
		int times = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(times == 0) {
				res = array[i];
				times ++;
			} else {
				if(res == array[i]) {
					times ++;
				} else {
					times--;
				}
			}
		}
		
		times = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] == res) times++;
		}
		
		if(times * 2 > array.length) {
			return res;
			
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
//		 int[] a = genTestCase(10, 100);
		int[] a = {1,2,3,2,2,2,5,4,2};
		show(a);
		System.out.println(MoreThanHalfNum(a));
		show(a);
	}
}
