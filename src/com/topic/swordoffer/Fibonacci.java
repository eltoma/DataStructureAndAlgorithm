package com.topic.swordoffer;

public class Fibonacci {
	public static void main(String[] args) {
		for (int i = 1; i <= 4; i++) {
			System.out.print(RectCover(i) + ", ");
		}
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
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
	 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。 
	 * @param target 台阶数
	 * @return 跳的方式
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
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
	 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 
	 * 结论：2^n-1
	 */
	public static int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }
	/**
	 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
	 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
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
