package com.topic.swordoffer;

public class Fibonacci {
	public static void main(String[] args) {
	/*	for (int i = 1; i <= 4; i++) {
			System.out.print(RectCover(i) + ", ");
		}*/
		
		System.out.println(RectCover(15));
	}
	
	public static int getFibonacci(int n) {
		if( n <= 0 ) {
			return 0;
		} else if( n == 1) {
			return 1;
		} else {
			return getFibonacci(n - 1) + getFibonacci(n - 2);
		}
	}
	
	public static int getFibonacci1(int n) {
		if( n <= 0 ) {
			return 0;
		} else if( n == 1) {
			return 1;
		} else {
			int a=0,b=1,temp = 0;
			for (int i = 1; i < n ; i++) {
				temp = b;
				b += a;
				a = temp;
			}
			return b;
		}
	}
	/**
	 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
	 * �����������һ��n����̨���ܹ��ж������� 
	 * @param target ̨����
	 * @return ��ķ�ʽ
	 */
	public static int JumpFloor(int target) {
		if(target == 0) {
			return 0;
		} else if(target == 1){
			return 1;
		} else if(target == 2) {
			return 2;
		} else {
			return JumpFloor(target - 1) + JumpFloor(target - 2);
		}
	}
	
	/***
	 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
	 * �����������һ��n����̨���ܹ��ж�������
	 * 
	 * ���ۣ�2^n-1
	 */
	public static int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }
	/**
	 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ��ľ��Ρ�
	 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
	 * @param target
	 * @return
	 */
	public static int RectCover(int target) {
        if( target <= 0 ) {
            return 0;
        } else if( target == 1) {
            return 1;
        } else if(target == 2) {
			return 2;
		} else {
            int a=1,b=2,temp = 0;
            for (int i = 2; i < target ; i++) {
                temp = b;
                b += a;
                a = temp;
            }
            return b;
        }
    }
}
