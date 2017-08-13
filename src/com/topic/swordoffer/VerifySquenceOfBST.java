package com.topic.swordoffer;

import org.junit.Test;

public class VerifySquenceOfBST {
    public static boolean VerifySquenceOfBST(int [] sequence) {
    	if(sequence.length == 0) return false;
    	if(sequence.length == 1) return true;
    	
    	return verifySquenceOfBST(sequence, 0, sequence.length - 1);
    }
    
    /**
     * �ĵã� �ݹ���Է����д�� ���� ��״ �ĵ����������
     * 		 һ�� ѭ��ֻ��д�� ���� �ĵ���������̣�Ҫ����״�ļ�����̣���Ҫ���ѭ��
     */
	public static boolean verifySquenceOfBST(int[] sequence, int lo, int hi) {
		if(hi <= lo) return true;
		 
		int i = lo, j = hi - 1;
		while(i < hi && sequence[i] < sequence[hi]) i++;
		while(j > lo && sequence[j] > sequence[hi]) j--;
		
		System.out.println(i + " " + j);
		
		if(i == j + 1 || i == j) {
			return verifySquenceOfBST(sequence, 0, j) 
					&& verifySquenceOfBST(sequence, i, hi - 1);
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		int a[] = {7,4,6,5};
		System.out.println(VerifySquenceOfBST(a));
	}

}
